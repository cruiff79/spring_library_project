		<%@ include file = "header.jsp" %>
		
		<main role="main">
			<div class="container sign_in">
				<div class="row">
					<div class="col-1"></div>
					<div class="col-5">
						<div>
							<h1>Welcome!</h1>
							<p>Please sign in</p>
						</div>
						<form>
							<div class="form-group">
								<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
							</div>
							<button type="submit" class="btn btn-primary">Sign in</button>
						</form>
					</div>
					<div class="col-1"></div>
					<div class="col-5">
						<div><img src="/library/resources/img/login.jpg" alt="" /></div>
					</div>
				</div>
			</div>
		</main>

		<%@ include file ="footer.jsp" %>
