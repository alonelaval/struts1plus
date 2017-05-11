<%@ tag body-content="empty" %>
<%@ tag pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="form" required="true"%> 
<%@ attribute name="pageNum" required="true"%> 
<input type="hidden" id="currentPage" name="page.currentPage" value="${page.currentPage}"/>
<input type="hidden" id="pageNum" name="page.pageNum" value="${pageNum}"/>
<input type="hidden" id="orderBy" name="page.orderBy" value="${page.orderBy}"/>
<input type="hidden" id="isAsc" name="page.isAsc" value="${page.isAsc}"/>
<c:if test="${page.hasPre}">
	<a href="javascript:toPage(${page.currentPage -1})">上一页</a>
</c:if>

<c:forEach begin="${page.begin}" end="${page.end}" var="c" step="1" >
	<c:if test="${c == page.currentPage}">
		当前页：${page.currentPage}
	</c:if>
	<c:if test="${c != page.currentPage}">
		<a href="javascript:toPage(${c})">第${c}页</a>
	</c:if>
</c:forEach>

<c:if test="${page.hasNext}">
	<a href="javascript:toPage(${page.currentPage +1})">下一页</a>
</c:if>
总页数:${page.pageCount}

<script type="text/javascript"> 
	function toPage(currentPage){
		$('#currentPage').val(currentPage);
		$('#${form}').submit();
	}
	$("td[orderBy]").click(function(){
		$('#orderBy').val($(this).attr('orderBy'));
		var isAsc =$('#isAsc').val();
		if(isAsc === 'true'){
			$('#isAsc').val(false);
		}
		else{
			$('#isAsc').val(true);
		}
		$('#${form}').submit();
	 }
	);
</script>