		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container main_container">
				<div class="row">
					<h3>ALL Subjects</h3>
				</div>
				<div class="card-columns">
					<c:forEach var="item" items="${list}">
		                <div class="card text-center">
		                    <div class="card-block">
		                    	<a href="searchSubject?category_id=${item.category_id}&category_name=${item.category_name}">${item.category_name}</a>
		                    </div>
		                </div>
					</c:forEach>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
