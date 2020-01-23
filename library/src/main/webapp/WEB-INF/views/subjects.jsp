		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container main_container">
				<div class="card-deck">
					<c:forEach var="item" items="${list}">
		                <div class="card text-center">
		                    <div class="card-block">
		                    	<a href="">${item.category_name}</a>
		                    </div>
		                </div>
					</c:forEach>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
