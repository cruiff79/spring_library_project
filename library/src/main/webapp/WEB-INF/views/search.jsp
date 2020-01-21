		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container main_container">
				<div class="row">
					<h3>Just add</h3>
				</div>
				<div class="card-deck">
					<c:forEach var="item" items="${list}">
		                <div class="card text-center">
		                    <div class="card-block">
		                    	<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" class="card-img-top" /></a>
		                        <h5 class="card-title">${item.title}</h5>
		                        <h6 class="card-title">by ${item.author}</h6>
		                    </div>
		                </div>
					</c:forEach>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
