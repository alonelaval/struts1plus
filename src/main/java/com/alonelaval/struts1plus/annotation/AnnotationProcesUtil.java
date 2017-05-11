package com.alonelaval.struts1plus.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class AnnotationProcesUtil
{
    public <T extends Annotation> boolean check(Method method,Class<T> annotationClass){
        return method.getAnnotation(annotationClass) != null;
    }
    
    public <T extends Annotation> T getAnnotation(Method method,Class<T> annotationClass){
        T mOverrideMethod = method.getAnnotation(annotationClass);
        if(mOverrideMethod  != null)
            return mOverrideMethod;
        return null;
    }
    
    public static AnnotationProcesUtil getInstance() {
        return AnnotationProcesUtilHolder.instance;
    }
    
    private static class AnnotationProcesUtilHolder{
        private static AnnotationProcesUtil instance = new AnnotationProcesUtil();
    }
}


/**
 * $Log: AnnotationProcesUtil.java,v $
 * 
 * @version 1.0 2015-3-10 
 *
 */