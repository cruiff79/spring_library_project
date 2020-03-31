		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container book_info">
				<div class="rental_info"><h5>Total Users: ${fn:length(allUser)}</h5></div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">ID</th>
							<th scope="col">Uer Type</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${allUser}" varStatus="loopCounter">
						<tr>
							<th scope="row">${loopCounter.count}</th>
							<td><a href="userInfo?user_id=${item.user_id}"><b>${item.name}</b></a></td>
							<td>${item.user_id}</td>
							<td>${item.type_name}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
