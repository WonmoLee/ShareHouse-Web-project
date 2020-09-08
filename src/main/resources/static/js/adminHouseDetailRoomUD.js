
let index1 = {
		
	init: function(){
		
		$("#btn-search").on("click", ()=>{
			this.select();
		});
			
	},
	
	select: function(){
		var house_num = $("#search__houseNumber").val();
		var roomName = $("#search__houseRoom").val();
		
		if(house_num == null || house_num == ""){
			alert("하우스 넘버를 입력하세요.");
			return;
		} else if(roomName == null || roomName == "") {
			alert("룸 네임을 입력하세요.");
			return;
		}
	
		$.ajax({
			type: "get",
			url: "/admin/houseDetailRoomSelect?house_num="+house_num+"&roomName="+roomName,
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			if(resp == null){
				alert("존재하지 않는 하우스 넘버 입니다.");
			}else{
				console.log(resp);
				$(".house-detail-room-UD").empty();
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
			house_num: $("#houseNumber").val(),
			roomName: $("#roomName").val(),
			gender: $("#gender").val(),
			type: $("#type").val(),
			area: $("#area").val(),
			deposit: $("#deposit").val(),
			monthly: $("#monthly").val(),
			moveInDate: $("#moveInDate").val()
	};
	
	$.ajax({
		type: "PUT",
		url: "/admin/houseDetailRoomUpdate",
		data: JSON.stringify(data), // json 으로 바꿔줌
		contentType: "application/json; charset=utf-8", 
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("수정 성공");
		location.href="/admin/houseDetailRoomUD";
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
		url: "/admin/houseDetailRoomDelete/"+data.id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/houseDetailRoomUD";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}


function houseDeleteAll() {
	let data = {
			house_num: $("#houseNumber").val()
	};
	
	
	console.log(data);
		
	$.ajax({
		type: "DELETE",
		url: "/admin/houseDetailRoomDeleteAll/"+data.house_num,
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("전체 삭제 성공");
		location.href="/admin/houseDetailRoomUD";
	}).fail(function(error){
		alert("전체 삭제 실패");
		console.log(error);
	});
}




function renderHouse(resp){
	
		var mapItem = `<div class="form-group">`;
		mapItem +=  `<label for="houseNumber">하우스 넘버</label> <input type="text" class="form-control" id="houseNumber" name="houseNumber" value="${resp.house_num}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="roomName">이름</label> <input type="text" class="form-control" id="roomName" name="roomName" value="${resp.roomName}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="gender">성별</label> <input type="text" class="form-control" id="gender" name="gender" value="${resp.gender}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="type">타입</label> <input type="text" class="form-control" id="type" name="type" value="${resp.type}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="area">면적</label> <input type="text" class="form-control" id="area" name="area" value="${resp.area}" >`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="deposit">보증금</label> <input type="text" class="form-control" id="deposit" name="deposit" value="${resp.deposit}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="monthly">월세</label> <input type="text" class="form-control" id="monthly" name="monthly" value="${resp.monthly}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="moveInDate">입주가능일</label> <input type="text" class="form-control" id="moveInDate" name="moveInDate" value="${resp.moveInDate}">`;
		mapItem +=  `</div>`;
		
		mapItem +=  `<input type="hidden" id="id" value="${resp.id}">`;
		mapItem +=  `<button id="btn-update" type="button" class="btn btn-warning" onclick="houseUpdate()">수정</button>&emsp;&emsp;`;
		mapItem +=  `<button id="btn-deleteById" type="button" class="btn btn-danger" onclick="houseDelete()">삭제</button>&emsp;&emsp;`;
		mapItem +=  `<button id="btn-deleteByAll" type="button" class="btn btn-danger" onclick="houseDeleteAll()">전체 삭제</button>`;
			
		$(".house-detail-room-UD").append(mapItem);
} 


