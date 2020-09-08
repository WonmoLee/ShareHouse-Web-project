$(document).ready(function() {
    var activeSystemClass = $('.list-group-item.active');

    //something is entered in search form
    $('#system-search').keyup( function() {
       var that = this;
        // affect all table rows on in systems table
        var tableBody = $('.table-list-search tbody');
        var tableRowsClass = $('.table-list-search tbody tr');
        $('.search-sf').remove();
        tableRowsClass.each( function(i, val) {
        
            //Lower text for case insensitive
            var rowText = $(val).text().toLowerCase();
            var inputText = $(that).val().toLowerCase();
            if(inputText != '')
            {
                $('.search-query-sf').remove();
                
            }
            else
            {
                $('.search-query-sf').remove();
            }

            if( rowText.indexOf( inputText ) == -1 )
            {
                //hide rows
                tableRowsClass.eq(i).hide();
                
            }
            else
            {
                $('.search-sf').remove();
                tableRowsClass.eq(i).show();
            }
        });
        //all tr elements are hidden
        if(tableRowsClass.children(':visible').length == 0)
        {
           
        }
    });
});


function counselAnswer(id){
	location.href="/admin/counselAnswer?id="+id;
}


function answerUpdate() {
	let data = {
			id: $("#id").val(),
			userId: $("#userId").val(),
			title: $("#title").val(),
			content: $("#content").val(),
			answer: $("#answer").val(),
			process: "답변완료"
	};
	
	console.log(data);
	
	$.ajax({
		type: "PUT",
		url: "/admin/counselAnswerUpdate",
		data: JSON.stringify(data), // json 으로 바꿔줌
		contentType: "application/json; charset=utf-8", 
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("답변 성공");
		location.href="/admin/counselSelectAll";
	}).fail(function(error){
		alert("답변 실패");
		console.log(error);
	});
}


function answerDelete() {
	let data = {
			id: $("#id").val()
	};
	
	
	$.ajax({
		type: "DELETE",
		url: "/admin/counselAnswerDelete/"+data.id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/counselSelectAll";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}
