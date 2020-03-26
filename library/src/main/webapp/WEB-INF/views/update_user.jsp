		<%@ include file = "header.jsp" %>
		
		<main role="main">
		    <div class="cotainer sign_in">
		        <div class="row justify-content-center">
		            <div class="col-md-8">
	                    <div class="card">
	                        <div class="card-header">UPDATE USER INFORMATION</div>
	                        <div class="card-body">
	                            <form id="myForm" name="myForm">
	                                <div class="form-group row">
	                                    <label for="email" class="col-md-4 col-form-label text-md-right">E-MAIL</label>
	                                    <div class="col-md-6">
	                                        <input type="email" id="email" class="form-control" name="email" value="${user.user_id}" readonly/>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <label for="password" class="col-md-4 col-form-label text-md-right">PASSWORD</label>
	                                    <div class="col-md-6">
	                                        <input type="password" id="password" class="form-control" name="password"/>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <label for="user_name" class="col-md-4 col-form-label text-md-right">USER NAME</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="user_name" class="form-control" name="user_name" value="${user.name}"/>
	                                    </div>
	                                </div>           
	                                <div class="form-group row">
	                                    <label for="address" class="col-md-4 col-form-label text-md-right">ADDRESS</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="address" class="form-control" name="address" value="${user.address}"/>
	                                    </div>
	                                </div>              
	                                <div class="form-group row">
	                                    <label for="post_code" class="col-md-4 col-form-label text-md-right">POST CODE</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="post_code" class="form-control" name="post_code" value="${user.post_code}"/>
	                                    </div>
	                                </div>
	                                <div class="form-group row">
	                                    <label for="phone_number" class="col-md-4 col-form-label text-md-right">PHONE NUMBER</label>
	                                    <div class="col-md-6">
	                                        <input type="text" id="phone_number" class="form-control" name="phone_number" value="${user.phone}"/>
	                                    </div>
	                                </div>
                                    <div class="col-md-6 offset-md-4">
                                        <button id="update_user" class="btn btn-primary">Update</button>
                                    </div>
	                            </form>
	                        </div>
	                    </div>
		            </div>
		        </div>
		    </div>
		</main>

		<%@ include file ="footer.jsp" %>
