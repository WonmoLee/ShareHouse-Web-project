var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.438819878223335, 126.99057600910417), // 지도의 중심좌표 
        level : 10 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 1 // 클러스터 할 최소 지도 레벨 
    });
    
    /* kakao.maps.event.addListener(map, 'center_changed', function() {

        // 지도의  레벨을 얻어옵니다
        var level = map.getLevel();

        // 지도의 중심좌표를 얻어옵니다 
        var latlng = map.getCenter(); 

        console.log("지도레벨 : "+ level);
        
        console.log("중심좌표 : "+ latlng);

 

    }); */
    

    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
   
     //alert(data);
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다

        
        
		kakao.maps.event.addListener(map, 'bounds_changed', function() {             
            
            // 지도 영역정보를 얻어옵니다 
            var bounds = map.getBounds();
            
            // 영역정보의 남서쪽 정보를 얻어옵니다 
            var swLatlng = bounds.getSouthWest().toString();
            
            // 영역정보의 북동쪽 정보를 얻어옵니다 
            var neLatlng = bounds.getNorthEast().toString();
            
            // 남서쪽 위도
            var sLatlng = swLatlng.split(",")[0].replace("(","");
            
            // 남서쪽 경도
            var wLatlng = swLatlng.split(",")[1].replace(")","").replace(" ","");
            
            // 북동쪽 위도
            var nLatlng = neLatlng.split(",")[0].replace("(","");
            
            // 북동 경도
            var eLatlng = neLatlng.split(",")[1].replace(")","").replace(" ","");
            
//              console.log("영역좌표는 남서쪽 위도는 : "+sLatlng);
//             console.log("영역좌표는 남서쪽 경도는 : "+wLatlng);
            
//           console.log("영역좌표는 북동쪽 위도는 : "+nLatlng);
//             console.log("영역좌표는 북동쪽 경도는 : "+eLatlng);
            
//             if(sLatlng > 33.45){
//              console.log("범위안");
//             }
            
//             if(sLatlng < a && nLatlng < a && wLatlng < b && eLatlng > b){
//              console.log("범위안입니다.");
//             }else {
//              console.log("범위 밖입니다.");
//             }
            let data = {
    				"latMin": sLatlng,
    				"latMax": nLatlng,
    				"lngMin": wLatlng,
    				"lngMax": eLatlng
    		};
  		
    		$.ajax({
    			type: "GET",
    			url: "/test/map?latMin="+sLatlng+"&lngMin="+wLatlng+"&latMax="+nLatlng+"&lngMax="+eLatlng,
    			//data: JSON.stringify(data), // json 으로 바꿔줌
    			contentType: "application/json; charset=utf-8", 
    			dataType: "json"
    			
    		}).done(function(resp){
    			
    			//console.log(resp); 
    			//alert("목록 불러오기 성공");
    			$("#Map-id").empty();
    			renderMapList(resp);
		
    		}).fail(function(error){
    			alert("목록 불러오기 실패");
    			console.log(error);
    		});
    	
    		var respsize = null;
    		
    		function renderMapList(resp){
    			respsize = resp.length;
    			//console.log(respsize);
    			for(var res of resp){
    				$("#Map-id").append(makeMapItem(res));
    				//console.log(makeMapItem(res));
    			}
    		}
    		
    		function makeMapItem(res){
    			
    			var genderType = res.genderType;
    			var reservation = res.reservation;
    			
    			if(res.genderType == '남'){
    				genderType = '남성전용';
    			}else {
    				genderType = '여성전용'
    			}
    			
    			if(res.reservation == '예'){
    				reservation = '예약가능';
    			} else {
    				reservation = '신청가능';
    			}
    			
    			
    			var mapItem = `<div class="house-map">`;
				mapItem +=  `<div style="background-image: url('${res.imageTitle}'); background-size: 100%; width: 230px; height: 180px; ">`;
				mapItem +=  `</div>`;
				mapItem +=  `<div>`;
				mapItem +=  `<p><span class="house__num__area">&emsp;${res.houseNumber}호점(${res.area})</span></p>`;
				mapItem +=  `<p>&ensp;${genderType} <span class="house__houseform">${res.houseForm}</span> &emsp;${reservation}</p>`;
				mapItem +=  `</div>`;
				mapItem +=  `</div>`;
				
				return mapItem;
    			
    		} 



           
        });
		
	
		$.ajax({
			type: "GET",
			url: "/test/all",
			//data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			//console.log(resp); 
			house = resp;
			clusHouse(house);
			$("#Map-id").empty();
			renderMapListAll(resp);
			//console.log(house); 
		}).fail(function(error){
			alert("목록 불러오기 실패");
			console.log(error);
		});
		
		function renderMapListAll(resp){
			respsize = resp.length;
			//console.log(respsize);
			for(var res of resp){
				$("#Map-id").append(makeMapItemAll(res));
				//console.log(makeMapItem(res));
			}
		}
		
		function makeMapItemAll(res){
			
			var genderType = res.genderType;
			var reservation = res.reservation;
			
			if(res.genderType == '남'){
				genderType = '남성전용';
			}else {
				genderType = '여성전용'
			}
			
			if(res.reservation == '예'){
				reservation = '예약가능';
			} else {
				reservation = '신청가능';
			}
			
			
				var mapItem = `<div class="house-map">`;
				mapItem +=  `<div style="background-image: url('${res.imageTitle}'); background-size: 100%; width: 230px; height: 180px; ">`;
				mapItem +=  `</div>`;
				mapItem +=  `<div>`;
				mapItem +=  `<p><span class="house__num__area">&emsp;${res.houseNumber}호점(${res.area})</span></p>`;
				mapItem +=  `<p>&ensp;${genderType} <span class="house__houseform">${res.houseForm}</span> &emsp;${reservation}</p>`;
				mapItem +=  `</div>`;
				mapItem +=  `</div>`;
				
				return mapItem;
    			
			
		} 
		
	    
		function clusHouse(house){
		
        var markers = $(house).map(function(i, position) {
         //console.log(house);
         
         return new kakao.maps.Marker({
               position : new kakao.maps.LatLng(position.lat, position.lng)
           });
		});
      

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
         
		}