
let index1 = {
		
	init: function(){
	
		$("#btn-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.save();
		});
			
	},
	
	
	save: function(){
		let data = {
				type: $("#type").val(),
				title: $("#title").val(),
				content: $("#content").val(),
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/admin/houseFaq",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
				alert("등록 성공");
				location.href="/admin/houseFaqSave";
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	}
	
}

index1.init();