
let index1 = {
		
	init: function(){
		
		$("#btn-search").on("click", ()=>{
			this.select();
		});
	
		$("#btn-deleteById").on("click", ()=>{
			this.deleteById();
		});
		
		$("#btn-update").on("click", ()=>{	
			this.update();
		});
			
	},
	
	select: function(){
		var id = $("#searchId").val();
		
		if(id == null || id == ""){
			alert("id 를 입력하세요.");
			return;
		} 
		$.ajax({
			type: "get",
			url: "/admin/houseFaqSelect/"+id,
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			if(resp == null){
				alert("존재하지 않는 id값 입니다.");
			}else{
				$(".admin__Faq").empty();
				renderFAQ(resp);
				alert("검색 성공");
			}
			
		}).fail(function(error){
			alert("검색 실패");
			
		})
	},
	
	
	update: function(){
		console.log("여기옴?");
		
		let data = {
				id: $("#id").val(),
				type: $("#type").val(),
				title: $("#title").val(),
				content: $("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/admin/houseFaqUpdate",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
			alert("수정 성공");
			
		}).fail(function(error){
			alert("수정 실패");
			console.log(error);
		})
	},
	
	deleteById: function(){
		let data = {
				id: $("#id").val()
		};
		
		$.ajax({
			type: "DELETE",
			url: "/admin/houseFaqDelete/"+data.id,
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
			alert("삭제 성공");
		}).fail(function(error){
			alert("삭제 실패");
			console.log(error);
		})
	},
	
}

index1.init();

function faqUpdate() {
	let data = {
			id: $("#id").val(),
			type: $("#type").val(),
			title: $("#title").val(),
			content: $("#content").val()
	};
	
	$.ajax({
		type: "PUT",
		url: "/admin/houseFaqUpdate",
		data: JSON.stringify(data), // json 으로 바꿔줌
		contentType: "application/json; charset=utf-8", 
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("수정 성공");
		location.href="/admin/houseFaqUD";
	}).fail(function(error){
		alert("수정 실패");
		console.log(error);
	});
}


function faqDelete() {
	let data = {
			id: $("#id").val()
	};
	
	
	$.ajax({
		type: "DELETE",
		url: "/admin/houseFaqDelete/"+data.id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/houseFaqUD";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}




function renderFAQ(resp){
	
		var mapItem = `<div class="form-group">`;
		mapItem +=  `<label for="type">타입 (입주관련 or 계약관련)</label> <input type="text" class="form-control" id="type" name="type" value="${resp.type}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">타이틀</label> <input type="text" class="form-control" id="title" name="title" value="${resp.title}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">내용</label> <input type="text" class="form-control" id="content" name="content" value="${resp.content}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<input type="hidden" id="id" value="${resp.id}">`;
		mapItem +=  `<button id="btn-update" type="button" class="btn btn-warning" onclick="faqUpdate()" >수정</button>&emsp;&emsp;`;
		mapItem +=  `<button id="btn-deleteById" type="button" class="btn btn-danger" onclick="faqDelete()">삭제</button>`;
		
		$(".admin__Faq").append(mapItem);
} 


