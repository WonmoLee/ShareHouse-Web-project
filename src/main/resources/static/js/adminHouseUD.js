
let index1 = {
		
	init: function(){
		
		$("#btn-search").on("click", ()=>{
			this.select();
		});
			
	},
	
	select: function(){
		var houseNumber = $("#search__houseNumber").val();
		
		if(houseNumber == null || houseNumber == ""){
			alert("하우스 넘버 를 입력하세요.");
			return;
		} 
		
		$.ajax({
			type: "get",
			url: "/admin/houseSelect/"+houseNumber,
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			if(resp == null){
				alert("존재하지 않는 하우스 넘버 입니다.");
			}else{
				console.log(resp);
				$(".admin-house-UD").empty();
				renderHouse(resp);
				alert("검색 성공");
			}
			
		}).fail(function(error){
			alert("검색 실패");
			
		})
	},
	

}

index1.init();

function houseUpdate() {
	let data = {
			id: $("#id").val(),
			discountType: $("#discountType").val(),
			imageTitle: $("#imageTitle").val(),
			nearStation: $("#nearStation").val(),
			houseNumber: $("#houseNumber").val(),
			lat: $("#lat").val(),
			lng: $("#lng").val(),
			area: $("#area").val(),
			genderType: $("#genderType").val(),
			reservation: $("#reservation").val(),
			houseForm: $("#houseForm").val()
	};
	
	$.ajax({
		type: "PUT",
		url: "/admin/houseUpdate",
		data: JSON.stringify(data), // json 으로 바꿔줌
		contentType: "application/json; charset=utf-8", 
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("수정 성공");
		location.href="/admin/houseUD";
	}).fail(function(error){
		alert("수정 실패");
		console.log(error);
	});
}


function houseDelete() {
	let data = {
			id: $("#id").val()
	};
		
	$.ajax({
		type: "DELETE",
		url: "/admin/houseDelete/"+data.id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/houseUD";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}




function renderHouse(resp){
	
		var mapItem = `<div class="form-group">`;
		mapItem +=  `<label for="discountType">할인 유무</label> <input type="text" class="form-control" id="discountType" name="discountType" maxlength=1 placeholder="Y or N 로 적으세요. " value="${resp.discountType}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">이미지 타이틀</label> <input type="text" class="form-control" id="imageTitle" name="imageTitle" value="${resp.imageTitle}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">주변역</label> <input type="text" class="form-control" id="nearStation" name="nearStation" value="${resp.nearStation}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">하우스번호</label> <input type="text" class="form-control" id="houseNumber" name="houseNumber" value="${resp.houseNumber}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="title">lat</label> <input type="text" class="form-control" id="lat" name="lat" value="${resp.lat}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="title">lng</label> <input type="text" class="form-control" id="lng" name="lng" value="${resp.lng}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="hashTag">지역(무슨 구 인지)</label> <input type="text" class="form-control" id="area" name="area" value="${resp.area}" >`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="genderType">성별 (여 or 남으로 적으세요.)</label> <input type="text" class="form-control" maxlength=1 id="genderType" name="genderType" value="${resp.genderType}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="gender">예약정보 (예 or 신 으로 적으세요.)</label> <input type="text" class="form-control" maxlength=1 id="reservation" name="reservation" value="${resp.reservation}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="houseForm">주거형태 (ex 빌라)</label> <input type="text" class="form-control" id="houseForm" name="houseForm" value="${resp.houseForm}">`;
		mapItem +=  `</div>`;
		
		mapItem +=  `<input type="hidden" id="id" value="${resp.id}">`;
		mapItem +=  `<button id="btn-update" type="button" class="btn btn-warning" onclick="houseUpdate()" >수정</button>&emsp;&emsp;`;
		mapItem +=  `<button id="btn-deleteById" type="button" class="btn btn-danger" onclick="houseDelete()">삭제</button>`;
		
		
		
		$(".admin-house-UD").append(mapItem);
} 


