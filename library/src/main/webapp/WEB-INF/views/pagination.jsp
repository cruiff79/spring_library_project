<c:if test="${pageMaker.totalCount > 0}">
<div>
	<ul class="pagination paging">
		<c:if test="${!pageMaker.prev}">
			<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">PREV</a></li>
		</c:if>
		<c:if test="${pageMaker.prev}">
			<li class="page-item"><a class="page-link" tabindex="-1" href="/library/search_book?searchBook=${searchBook}&&page=${pageMaker.startPage - 1}">PREV</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<c:if test="${pageMaker.criteria.page == idx}">
				<li class="page-item active"><span class="page-link">${idx}</span></li>
			</c:if>
			<c:if test="${pageMaker.criteria.page != idx}">
				<li class="page-item"><a class="page-link" href="/library/search_book?searchBook=${searchBook}&&page=${idx}">${idx}</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${!pageMaker.next || pageMaker.endPage <= 0}">
			<li class="page-item disabled"><a class="page-link" href="#" tabindex="-1">NEXT</a></li>
		</c:if>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li class="page-item"><a class="page-link" tabindex="-1" href="/library/search_book?searchBook=${searchBook}&&page=${pageMaker.endPage + 1}">NEXT</a></li>
		</c:if>
	</ul>
</div>
</c:if>