		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container book_info">
				<div class="rental_info"><h5>Total borrowed: ${fn:length(list)}</h5></div>
				<c:forEach var="item" items="${list}">
				<div class="row">
					<div class="col-3">
						<a href="bookInfo?book_id=${item.book_id}"><img src="${item.image}" alt="" /></a>
					</div>
					<div class="col-9">
						<div>
							<a href="bookInfo?book_id=${item.book_id}"><h3>${item.title}</h3></a>
						</div>
						<div>
							<a href="">${item.publisher}</a>
						</div>
						<div>
							<p>by <a href="">${item.author}</a></p>
						</div>
						<div>
							<b>Borrowed</b>: ${item.start_date} ~ ${item.end_date}
						</div>
					</div>
				</div>
				<div><hr/></div>
				</c:forEach>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
