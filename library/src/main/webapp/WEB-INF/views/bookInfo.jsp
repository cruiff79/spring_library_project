		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container book_info">
				<div class="row">
					<div class="col-4">
						<img src="${bookInfo.image}" alt="" class="book_info_image" />
					</div>
					<div class="col-8">
						<div>
							<h3>${bookInfo.title}</h3>
						</div>
						<div>
							<a href="">${bookInfo.publisher}</a>
						</div>
						<div>
							<p>by <a href="">${bookInfo.author}</a></p>
						</div>
						<div>
							<b>ISBN</b>: ${bookInfo.isbn}
						</div>
						<div>
							<b>Release date</b>: ${bookInfo.published_date}
						</div>
						<div>
							<b>Borrowed</b>: <c:out value="${bookInfo.borrowed == 1 ? 'YES' : 'NO'}"/>
							<c:if test="${bookInfo.borrowed == 1}">, ${bookInfo.start_date} ~ ${bookInfo.end_date}</c:if>
						</div>
						<div>
							<h5>Description</h5>
							<p>${bookInfo.description}</p>
						</div>
						<div>
							<button id="btnBorrow" class="btn btn-lg btn-primary" <c:out value="${bookInfo.borrowed == 1 ? 'disabled' : ''}"/>>TAKE</button>
						</div>
					</div>
					<form id="borrowForm">
						<input type="hidden" name="book_id" value="${bookInfo.book_id}"/>
					</form>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
