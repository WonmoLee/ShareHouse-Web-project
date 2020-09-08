
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
			url: "/admin/houseDetailSelect/"+houseNumber,
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			if(resp == null){
				alert("존재하지 않는 하우스 넘버 입니다.");
			}else{
				console.log(resp);
				$(".admin-detail-UD").empty();
				renderDetail(resp);
				alert("검색 성공");
			}
			
		}).fail(function(error){
			alert("검색 실패");
			
		})
	},
	

}

index1.init();

function detailUpdate() {
	let data = {
			id: $("#id").val(),
			house_num: $("#houseNumber").val(),
			img1: $("#img1").val(),
			img2: $("#img2").val(),
			img3: $("#img3").val(),
			title: $("#title").val(),
			content: $("#content").val(),
			hash_tag: $("#hashTag").val(),
			tourPoint: $("#tourPoint").val(),
			address: $("#address").val(),
			gender: $("#gender").val(),
			contractEndDate: $("#contractEndDate").val(),
			maxResidencePersonnel: $("#maxResidencePersonnel").val(),
			house_form: $("#houseForm").val(),
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
	
	$.ajax({
		type: "PUT",
		url: "/admin/houseDetailUpdate",
		data: JSON.stringify(data), // json 으로 바꿔줌
		contentType: "application/json; charset=utf-8", 
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("수정 성공");
		location.href="/admin/houseDetailUD";
	}).fail(function(error){
		alert("수정 실패");
		console.log(error);
	});
}


function detailDelete() {
	let data = {
			id: $("#id").val()
	};
	
	
	$.ajax({
		type: "DELETE",
		url: "/admin/houseDetailDelete/"+data.id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		alert("삭제 성공");
		location.href="/admin/houseDetailUD";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}




function renderDetail(resp){
	
		var mapItem = `<div class="form-group">`;
		mapItem +=  `<label for="img1">하우스번호</label> <input type="text" class="form-control" id="houseNumber" name="houseNumber" value="${resp.house_num}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img1">사진1 예: /img/d사이에하우스넘버넣으세요a.jpg</label> <input type="text" class="form-control" id="img1" name="img1" value="${resp.img1}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img2">사진2 예: /img/d124b.jpg</label> <input type="text" class="form-control" id="img2" name="img2" value="${resp.img2}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="img3">사진3 예: /img/d124c.jpg</label> <input type="text" class="form-control" id="img3" name="img3" value="${resp.img3}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="title">타이틀</label> <input type="text" class="form-control" id="title" name="title" value="${resp.title}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="content">내용</label>
							<textarea class="form-control" rows="6" id="content" name="content" >${resp.content}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="hashTag">해쉬태그</label> <input type="text" class="form-control" id="hashTag" name="hashTag" value="${resp.hash_tag}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="tourPoint">투어포인트</label>
							<textarea class="form-control" rows="6" id="tourPoint" name="tourPoint" >${resp.tourPoint}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="address">주소</label> <input type="text" class="form-control" id="address" name="address" value="${resp.address}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="gender">여 or 남 한글자로</label> <input type="text" class="form-control" id="gender" name="gender" value="${resp.gender}" maxlength=1>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="contractEndDate">지점계약종료일</label> <input type="text" class="form-control" id="contractEndDate" name="contractEndDate" value="${resp.contractEndDate}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="maxResidencePersonnel">최대거주인원</label> <input type="text" class="form-control" id="maxResidencePersonnel" name="maxResidencePersonnel" value="${resp.maxResidencePersonnel}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="houseForm">주택유형</label> <input type="text" class="form-control" id="houseForm" name="houseForm" value="${resp.house_form}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="construction">구조</label> <input type="text" class="form-control" id="construction" name="construction" value="${resp.construction}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="drawing">도면 예: /img/draw124.png or .jpg</label> <input type="text" class="form-control" id="drawing" name="drawing" value="${resp.drawing}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="tourApply">투어신청 설명</label>
							<textarea class="form-control" rows="6" id="tourApply" name="tourApply">${resp.tourApply}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="subway">지하철</label>
							<textarea class="form-control" rows="3" id="subway" name="subway" >${resp.subway}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="bus">버스</label> <input type="text" class="form-control" id="bus" name="bus" value="${resp.bus}">`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="univercity">대학교</label>
							<textarea class="form-control" rows="3" id="univercity" name="univercity" >${resp.university}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="mart">마트</label>
							<textarea class="form-control" rows="3" id="mart" name="mart" >${resp.mart}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="facilities">편의시설</label>
							<textarea class="form-control" rows="3" id="facilities" name="facilities" >${resp.facilities}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<div class="form-group">`;
		mapItem +=  `<label for="heal">병원</label>
							<textarea class="form-control" rows="3" id="heal" name="heal" >${resp.heal}</textarea>`;
		mapItem +=  `</div>`;
		mapItem +=  `<input type="hidden" id="id" value="${resp.id}">`;
		mapItem +=  `<button id="btn-update" type="button" class="btn btn-warning" onclick="detailUpdate()" >수정</button>&emsp;&emsp;`;
		mapItem +=  `<button id="btn-deleteByNum" type="button" class="btn btn-danger" onclick="detailDelete()">삭제</button>`;
		
		
		
		$(".admin-detail-UD").append(mapItem);
} 


