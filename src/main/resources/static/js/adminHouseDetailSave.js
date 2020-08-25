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
				img1: $("#img1").val(),
				img2: $("#img2").val(),
				img3: $("#img3").val(),
				title: $("#title").val(),
				content: $("#content").val(),
				hashTag: $("#hashTag").val(),
				tourPoint: $("#tourPoint").val(),
				address: $("#address").val(),
				gender: $("#gender").val(),
				contractEndDate: $("#contractEndDate").val(),
				maxResidencePersonnel: $("#maxResidencePersonnel").val(),
				houseForm: $("#houseForm").val(),
				construction: $("#construction").val(),
				drawing: $("#drawing").val(),
				tourApply: $("#tourApply").val(),
				subway: $("#subway").val(),
				bus: $("#bus").val(),
				univercity: $("#univercity").val(),
				mart: $("#mart").val(),
				facilities: $("#facilities").val(),
				heal: $("#heal").val()
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/admin/houseDetail",
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