		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container main_container">
				<div class="row searchingBook">Searching: ${searchBook}</div>
				<div class="row">
					<c:if test="${fn:length(list) == 0}">
						<div class="col-sm-3">There is no book.</div>
					</c:if>
					<c:if test="${fn:length(list) > 0}">
					<c:forEach var="item" items="${list}">
						<div class="col-sm-3">
							<div class="card">
								<div class="card-body">
									<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" class="card-img-top" /></a>
									<h5 class="card-title">${item.title}</h5>
									<h6 class="card-title">by ${item.author}</h6>
								</div>
							</div>
						</div>
					</c:forEach>
					</c:if>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
	