
let index = {
		
	init: function(){
	
		$("#btn-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.save();
		});
			
	},
	
	
	save: function(){
		let data = {
				houseNumber: $("#houseNumber").val(),
				roomName: $("#roomName").val(),
				gender: $("#gender").val(),
				type: $("#type").val(),
				area: $("#area").val(),
				deposit: $("#deposit").val(),
				monthly: $("#monthly").val(),
				moveInDate: $("#moveInDate").val()
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/admin/houseDetailRoom",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
				alert("등록 성공");
				location.href="/admin/houseDetailRoomSave";
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	}
	
}

index.init();