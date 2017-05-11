package com.alonelaval.struts1plus.action;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.upload.MultipartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alonelaval.struts1plus.annotation.AnnotationProcesUtil;
import com.alonelaval.struts1plus.annotation.RedirectUrlParamMethod;
import com.alonelaval.struts1plus.annotation.UrlOverrideMethod;
import com.alonelaval.struts1plus.converter.DateConverter;
import com.alonelaval.struts1plus.converter.IConverter;
import com.alonelaval.struts1plus.validator.IValidator;
import com.alonelaval.struts1plus.validator.ValidateException;
import com.alonelaval.struts1plus.validator.validate.RequestTokenException;



/**
 * 
 * Purpose: 抽象的strutsAction，该Action将承担数据验证，数据转换，数据封装到对应的业务aciotn中，
 * 而业务Action将纯粹的担任业务调用，如数据查询，数据更新，业务处理，根据对应的返回字符,返回到改Action中
 * 该strutsAction将负责转发具体业务Action中返回的路径字符，json,文件
 * 可以继续往下抽象，具体的业务模块可以抽象一个baseStrutsAction,用来做session，数据权限等验证
 * @see	    
 * @since   1.1.0
 */
public abstract class AbstractBaseStrutsAction extends Action
{   
    private Map<Class, Converter> converters = new HashMap<Class, Converter>();
    private Map<String,IConverter> propertisConverter = new HashMap<String,IConverter>();
    private Map<String, IValidator> propertisValidator= new HashMap<String, IValidator>();
    public  static final String ERROR = "error";
    private static final String ERRORINFO = "errorInfo";
    private static final String SPLIT ="!";
    private static final String EXECUTE ="execute";
    private BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
    private ConvertUtilsBean convertUtilsBean = beanUtilsBean.getConvertUtils();
    private PropertyUtilsBean propertyUtilsBean = beanUtilsBean.getPropertyUtils();
    private static  Logger logger ;
    
    public AbstractBaseStrutsAction(){
        logger = LoggerFactory.getLogger(getClass());
    }
     @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
         IBusinessAction action = (IBusinessAction) getBussinessAction().newInstance();
         Method method = getExecuteMethod(action,mapping.getPath());
         Map<String, Object> params = getParameters(request);
         try{
             before(request);
             doPropertyConverter(params);
             initBusinessAction(action,form,request,params,mapping);
            
        }catch (Exception e) {
           logger.error("AbstractBaseStrutsAction:initBusinessAction 参数异常！",e);
           return errorValidateProcess(action,request, e, mapping,response,method);
        }
        String result = null;
        try
        {
            result  = execute(action,method);
        }
        catch (Exception e)
        {
            logger.error("AbstractBaseStrutsAction:execute 无法获取业务方法！",e);
            request.setAttribute(ERRORINFO, "无法获取业务方法！");
            return  mapping.findForward(ERROR);
        }
        ActionForward actionForward = getResponseActionForward(mapping, response, request, action, result,method);
        after(request);
        return actionForward;
    }
     
     /***
      * 
      * errorValidateProcess：error的处理
      * 
      * @param request
      * @param e
      * @param mapping
      * @return
      * 
      * @author huawei  
     * @throws Exception 
      * @see <参见的内容>
      */
     protected ActionForward errorValidateProcess(IBusinessAction action,HttpServletRequest request,Exception e,ActionMapping mapping, HttpServletResponse response,Method method ) throws Exception{
         if(e instanceof ValidateException )
         {
             ValidateException validateException = (ValidateException) e;
             if(validateException.getErrorPath() != null){
                 if(!(validateException instanceof RequestTokenException))
                     savaParameters(action,request);
                 request.setAttribute(ERRORINFO, validateException.getErrorString());
                 return  mapping.findForward(validateException.getErrorPath());
             }
         }
         if(!(e instanceof RequestTokenException))
            savaParameters(action,request);
         request.setAttribute(ERRORINFO, e.getMessage());
         return  mapping.findForward(ERROR);
     }
     /**
      * 封锁接口
      * (non-Javadoc)
      * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.ServletRequest, javax.servlet.ServletResponse)
      */
    @Override
    public final ActionForward execute(ActionMapping mapping, ActionForm form, ServletRequest request, ServletResponse response) throws Exception
    {
        try {
            return execute(mapping, form, (HttpServletRequest) request,
                (HttpServletResponse) response);
        } catch (ClassCastException e) {
            return null;
        }
    }
    protected ActionForward getResponseActionForward(ActionMapping mapping,HttpServletResponse response,HttpServletRequest request,IBusinessAction businessAction,String result,Method method) throws Exception{
        ActionForward actionForward = mapping.findForward(result);
        if(actionForward == null)
            return null;
        
        UrlOverrideMethod urlOverrideMethod= AnnotationProcesUtil.getInstance().getAnnotation(method, UrlOverrideMethod.class);  //重写URL
        if(null != urlOverrideMethod && result.equals(urlOverrideMethod.forwardName())){
            ActionRedirect redirect = new ActionRedirect(actionForward);
            String paramNames[] = urlOverrideMethod.paramsName();
            savaRedirectParameters(businessAction,redirect,true,paramNames);
            return redirect;
        }
        
        if(!actionForward.getRedirect()){
            savaParameters(businessAction,request);
            return actionForward;
        }
        
        if(actionForward.getRedirect())
        {
            ActionRedirect redirect = new ActionRedirect(actionForward);
            RedirectUrlParamMethod redirectUrlParamMethod=   AnnotationProcesUtil.getInstance().getAnnotation(method, RedirectUrlParamMethod.class);
            if(null != redirectUrlParamMethod && result.equals(redirectUrlParamMethod.forwardName()))
            {
                String paramNames[] = redirectUrlParamMethod.paramsName();
                savaRedirectParameters(businessAction,redirect,false,paramNames);
            }
            return redirect;
        }
        return null;
    }
    
    private void savaRedirectParameters(IBusinessAction actionBean, ActionRedirect redirect,boolean overwriteUrl,String paramNames[]) throws Exception
    {
        if(paramNames != null){
            StringBuilder builder = new StringBuilder();
            builder.append(redirect.getPath());
            for (String paramName : paramNames)
            {
                if(!isSetProperties(actionBean, paramName))
                    continue;
                Object value = propertyUtilsBean.getProperty(actionBean, paramName);
                if(!overwriteUrl){
                    redirect.addParameter(paramName, value);
                }
                else{
                    builder.append(value).append("/");
                }
            }
            if(overwriteUrl)
                if(builder.toString().endsWith("/"))
                    redirect.setPath(builder.substring(0,builder.length()-1));
        }
    }
    
    private void savaParameters(IBusinessAction actionBean, HttpServletRequest request) throws Exception
    {
        PropertyDescriptor[] descriptors= getPropertyDescriptors(actionBean.getClass());
        for (PropertyDescriptor descriptor : descriptors)
        {
            String name = descriptor.getName();
            if(!isSetProperties(actionBean, name))
                continue;
            Object value = propertyUtilsBean.getProperty(actionBean, name);
            request.setAttribute(name,value);
        }
    }
    
    
    private Method getExecuteMethod(IBusinessAction action,String path){
        String methodName=EXECUTE;
        if(path.lastIndexOf(SPLIT) > 0){ //必须大于0
            methodName =  path.substring(path.lastIndexOf(SPLIT)+1);
        }
        return  MethodUtils.getAccessibleMethod(action.getClass(), methodName, new Class[]{});
    }
    private String execute(IBusinessAction action, Method method)throws Exception
    {
        Object result =method.invoke(action, null);
        return  result == null ? null : result.toString();
    }
  

    private void test(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
    	System.out.println(mapping.getPath());
//    	System.out.println(mapping.findForward("index").getName());
    }
    /***
     * 
     * after：不建议重写
     * 
     * @param request
     * 
     * @author huawei   
     * @see <参见的内容>
     */
    protected  void after(HttpServletRequest request){
        HttpSessionFactory.getIntance().removeHttpSession();
        ServletContextFactory.getIntance().removeServletContext();
        HttpRequestFactory.getIntance().removeHttpRequest();
    };
    /**
     * 
     * before：开始整个流程之前做一些初始化的动作
     * session 级别的操作
     * @author huawei   
     * @see <参见的内容>
     */ 
    protected  void before(HttpServletRequest request)throws Exception{};
    
    protected abstract Class getBussinessAction();
    /***
     * 
     * initBusinessAction：初始化
     * 
     * @param businessAction
     * @param form
     * @param request
     * 
     * @author huawei   
     * @param mapping 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @see <参见的内容>
     */
    private void initBusinessAction(IBusinessAction actionBean,ActionForm form,HttpServletRequest request,Map<String,Object> parameters,ActionMapping mapping) throws Exception{
        register(convertUtilsBean);
        if(form != null)
            beanUtilsBean.copyProperties(actionBean,form);
        else{
            beanUtilsBean.populate(actionBean, parameters);
        }
        if(mapping.getValidate())
            doValidateParameters(parameters);
        HttpSessionFactory.getIntance().putHttpSession(request.getSession());
        ServletContextFactory.getIntance().putServletContext(getServlet().getServletContext());
        HttpRequestFactory.getIntance().putHttpRequest(request);
    }
    
    private Map<String,Object>  getParameters(HttpServletRequest request) throws Exception{
        Map<String,Object> parameters = new HashMap<String, Object>();
        if(request instanceof MultipartRequestWrapper)
             return getFileRequestParameters(request,parameters);
        
       return getRequestParameters(request);
    }
    
    private void doPropertyConverter(Map<String,Object> parameters){
        for(Map.Entry<String, IConverter> entry:propertisConverter.entrySet()){
            String key = entry.getKey().toString();
            Object value = parameters.get(key);
            if(value != null && value.getClass() == new String[0].getClass()){
                String [] va = (String[]) value;
                if(va.length == 0)
                    value = null;
                if(va.length ==1)
                    value = va[0];
            }
            parameters.put(key, entry.getValue().convert(value));
        }
    }
    private Map<String, Object> getFileRequestParameters(HttpServletRequest request, Map<String, Object> parameters) throws Exception
    {
            FileItemFactory factory = new DiskFileItemFactory(); 
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items)
            {
                if (item.isFormField()) 
                    parameters.put(item.getFieldName(), item.getString("UTF-8"));
                else
                    parameters.put(item.getFieldName(), item);
            }
            parameters.putAll(getRequestParameters(request));
            return parameters;
    }
    private boolean isSetProperties(IBusinessAction actionBean,String name){
        if ("class".equals(name)) 
            return false; // No point in trying to set an object's class
        if(!(propertyUtilsBean.isReadable(actionBean, name) && propertyUtilsBean.isWriteable(actionBean, name))) 
             return false;
        return true;
    } 
    private PropertyDescriptor[] getPropertyDescriptors(Class beanClass) throws IntrospectionException{
    	BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
    	PropertyDescriptor [] descriptors= beanInfo.getPropertyDescriptors();
        return descriptors == null ? new PropertyDescriptor[0] : descriptors;
    }
    
    private  Map<String,Object>  getRequestParameters(HttpServletRequest request) throws Exception{
        Iterator iterator = request.getParameterMap().entrySet().iterator();
        Map<String,Object> parameters = new HashMap<String, Object>();
        while(iterator.hasNext()){
            Entry entry = (Entry) iterator.next(); 
            String key = entry.getKey().toString();
            Object value = entry.getValue();
            parameters.put(key, value);
        }
        return parameters;
    }
//    
    private void doValidateParameters(Map parameters) throws Exception{
        for(Map.Entry<String, IValidator> entry:propertisValidator.entrySet()){
            String key = entry.getKey().toString();
            Object value = parameters.get(key);
            if(value != null && value.getClass() == new String[0].getClass()){
                String [] va = (String[]) value;
                if(va.length == 0)
                    value = null;
                if(va.length ==1)
                    value = va[0];
            }
            entry.getValue().doValidate(value);
        }
    }
    
    private void register(ConvertUtilsBean convertUtilsBean) {
		convertUtilsBean.deregister();
		converters.put(BigDecimal.class, new BigDecimalConverter(null));
		converters.put(BigInteger.class, new BigIntegerConverter(null));
		converters.put(Boolean.class, new BooleanConverter(null));
		converters.put(Byte.class, new ByteConverter(null));
		converters.put(Character.class, new CharacterConverter(null));
		converters.put(Double.class, new DoubleConverter(null));
		converters.put(Float.class, new FloatConverter(null));
		converters.put(Integer.class, new IntegerConverter(null));
		converters.put(Long.class, new LongConverter(null));
		converters.put(Short.class, new ShortConverter(null));
        converters.put(Date.class, new DateConverter(null));
		for (Map.Entry<Class, Converter> entry : converters.entrySet()) {
            convertUtilsBean.register(entry.getValue(), entry.getKey());
		}

	}

    protected final void addPropertyConverter(String propertyName,IConverter converter){
    	propertisConverter.put(propertyName, converter);
    }
    protected final void addConverter(Class clazz,Converter converter){
        converters.put(clazz, converter);
    }
    protected final void addPropertyValidator(String propertyName,IValidator validator){
        propertisValidator.put(propertyName, validator);
    }
    
    protected final void addPropertysValidator(String[] propertyNames,IValidator validator){
        for (String propertyName : propertyNames)
            propertisValidator.put(propertyName, validator);
    }
    
}


/**
 * 
 * @verion  1.4 2015-3-31 添加requestFactory
 * @version 1.3 2015-3-9 添加servletConext
 * 
 * @version 1.2 将配置文件里面的URL 重写，redirect传参从配置文件中移到annotation中，采用annotation标识一个一个ajax,file业务类中哪个方法是ajax输出的，哪个方法是需要输出file的 
 * 
 * @version 1.1  2015-3-5 添加 redirect 时保存参数的功能,保存方式?parma=11&parma2=
 *                          添加 redirect 根据参数重写URL的功能 /value/value2/value3
 *                         //true|true|param1,param2,param3,第一个值为是否传参数，第二个为是否重写URL，第3为要传的参数名称
 *                           如果不传参数，可以不用设置Parameter参数
 * $Log: BaseAction.java,v $
 * 
 * @version 1.0 2015-1-23 
 *
 */