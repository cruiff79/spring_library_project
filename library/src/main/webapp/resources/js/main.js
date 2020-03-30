$(document).ready(function() {
	$("#sign_in").click(function(){
		$("#signInForm").submit();
	});
	
	$("#sign_up").click(function() {
		if($("#email").val() == null || $("#email").val() == '') {
			alert('please insert email');
			return;
		} else if($("#password").val() == null || $("#password").val() == '') {
			alert('please insert password');
			return;
		} else if($("#user_name").val() == null || $("#user_name").val() == '') {
			alert('please insert user_name');
			return;
		} else if($("#address").val() == null || $("#address").val() == '') {
			alert('please insert address');
			return;
		} else if($("#post_code").val() == null || $("#post_code").val() == '') {
			alert('please insert post_code');
			return;
		} else if($("#phone_number").val() == null || $("#phone_number").val() == '') {
			alert('please insert phone_number');
			return;
		} else {
			$("#myForm").attr("action", "sign_up_insert");
			$("#myForm").attr("method", "POST");
			$("#myForm").submit();
			alert('Successfully Registered');
		}
	});
	
	$("#update_user").click(function() {
		if($("#email").val() == null || $("#email").val() == '') {
			alert('please insert email');
			return;
		} else if($("#password").val() == null || $("#password").val() == '') {
			alert('please insert password');
			return;
		} else if($("#user_name").val() == null || $("#user_name").val() == '') {
			alert('please insert user_name');
			return;
		} else if($("#address").val() == null || $("#address").val() == '') {
			alert('please insert address');
			return;
		} else if($("#post_code").val() == null || $("#post_code").val() == '') {
			alert('please insert post_code');
			return;
		} else if($("#phone_number").val() == null || $("#phone_number").val() == '') {
			alert('please insert phone_number');
			return;
		} else {
			$("#myForm").attr("action", "update_user_process");
			$("#myForm").attr("method", "POST");
			$("#myForm").submit();
			alert('Successfully Updated');
		}
	});
	
	$("#myBooks").click(function(e) {
		var user_id = $("#user_id").val();
		if(user_id == null || user_id == '') {
			alert("Please Sign in");
			window.location.href="/library/sign_in";
			return;
		}

		$("#myBooks").attr("href", "/library/myBooks");
	});
	
	$("#btnSearchBook").click(function(e){
		e.preventDefault();
		if($("#searchBook").val().trim() == null || $("#searchBook").val().trim() == "") {
			alert("Please enter search book!");
			return;
		}
		
		$("#formSearchBook").attr("action", "search_book");
		$("#formSearchBook").attr("method", "GET");
		$("#formSearchBook").submit();
	});
	
	$("#btnBorrow").click(function() {
		if(confirm("Do you want to get this book?")) {
			$("#borrowForm").attr("action", "borrow_book");
			$("#borrowForm").attr("method", "GET");
			$("#borrowForm").submit();
		} else {
			return false;
		}
	});
});

$(document).ready(function() {
    $("button").click(function(){
        var search = $("#books").val();

        if(search == '') {
            alert("Please enter title");
        } else {
            var url = '';
            var img = '';
            var title = '';
            var author = '';
            var publisher = '';
            var publishedDate = '';
            var description = '';
            var page = '';
            var isbn = '';
            var categories = '';
            
            $.get("https://www.googleapis.com/books/v1/volumes?q=" + search, (response) => {
                for(i=0; i<response.items.length; i++) {
                    title = response.items[i].volumeInfo.title;
                    author = response.items[i].volumeInfo.authors[0];
                    publisher = response.items[i].volumeInfo.publisher;
                    publishedDate = response.items[i].volumeInfo.publishedDate;
                    description = response.items[i].volumeInfo.description;
                    page = response.items[i].volumeInfo.pageCount;
                    isbn = response.items[i].volumeInfo.industryIdentifiers[0].identifier;
                    img = response.items[i].volumeInfo.imageLinks.thumbnail;
                    categories = response.items[i].volumeInfo.categories[0];

                    madeAjaxCall(title, author, publisher, publishedDate, description, page, isbn, img, categories);
                    alert(title);
                }
            });
        }
    });

    return false;
});

function madeAjaxCall(_title, _author, _publisher, _publishedDate, _description, _page, _isbn, _img, _categories) {
    $.ajax({
        type: "POST",
        url: "google_books_api_insert",
        timeout: 100000,
        catch: false,
        data: {
            title: _title,
            author: _author,
            publisher: _publisher,
            publishedDate: _publishedDate,
            description: _description,
            page: _page,
            isbn: _isbn,
            img: _img,
            categories: _categories
        },
        success: function(data) {
            console.log(data);
        },
        error: function(e) {
            console.log("ERROR", e);
        }
    });
}