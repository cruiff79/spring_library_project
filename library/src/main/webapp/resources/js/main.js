$(document).ready(function() {
	$("#sign_in").click(function(){
		$("#signInForm").submit();
	});
	
	$("#sign_up").click(function() {
		$("#myForm").submit();
		alert("success");
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