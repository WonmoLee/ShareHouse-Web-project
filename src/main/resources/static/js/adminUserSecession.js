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


function secessionDelete(userId) {
	
	$.ajax({
		type: "DELETE",
		url: "/admin/secessionDelete/"+userId,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/memberSecessionAll";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}


function secessionCancel(userId) {
	
	$.ajax({
		type: "DELETE",
		url: "/admin/secessionCancel/"+userId,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("취소 성공");
		location.href="/admin/memberSecessionAll";
	}).fail(function(error){
		alert("취소 실패");
		console.log(error);
	});
}


