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
						<form id="signInForm" method="post" action="sign_in_process">
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password">
							</div>
							<button id="sign_in" class="btn btn-primary">Sign in</button>
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
