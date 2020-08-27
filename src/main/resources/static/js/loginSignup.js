function signup() {
	$('.username__check').hide();
	$('#password').hide();
	$('#signup_btn').remove();
	$('#login_btn').remove();
	$('.social_login').empty();
	$('#signup_form').append(
		'<input id="email" class="text-input1" type="email" placeholder=" 이메일을 입력해주세요." required="required"/>',
		'<input id="ph_num" class="text-input1" type="tel" placeholder=" \'-\' 를 제외하고 연락처를 입력해주세요." required="required"/>',
		'<input id="address" class="text-input1" type="text" placeholder=" 주소를 입력해주세요." required="required"/>',
		'<input id="bank_name" class="text-input1" type="text" placeholder=" 은행명을 입력해주세요. ex)신한, IBK기업" required="required"/>',
		'<button id="signup_btn" class="btn2" onclick="javascript:signupProc()" style="width: 435px;height: 37px;border-radius: 0.4vw;border: 0.5px;background: #da553b;color: white;cursor: pointer;margin-bottom: 50px;">이 정보로 회원가입</button>'
	);
}

function signupProc() {
	
	let data = {
			userName: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			phNum: $("#ph_num").val(),
			address: $("#address").val(),
			bankName: $("#bank_name").val()
	}
	
	$.ajax({
		
		type : "POST",
		url : "/signUpProc",
		data : JSON.stringify(data),
		contentType : "application/json; charset=UTF-8",
		dataType : "json"
			
	}).done(function(resp) {
		
		if(resp.statusCode == 1) {
			alert("회원가입이 완료되었습니다.");
			location.href="/loginOrSignup";
		}
		
	}).fail(function(error) {
		alert("회원가입에 실패하였습니다.")
		console.log(error);
	})

}

function loginProc() {
	
	
	let data = {
			username: $("#username").val(),
			password: $("#password").val()
	}
	
	$.ajax({
			
			type : "POST",
			url : "/loginProc", //이거 타면 시큐리티 로그인 시도 
			data : $("#username").serialize()+"&"+$("#password").serialize(),
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "html"
				
	}).done(function(resp) {
			
			if(resp.statusCode == 1) {
				console.log(resp);
				alert("성공적으로 로그인 되었습니다.");
				location.href="/";
			}
			
	}).fail(function(error) {
		
			alert("로그인에 실패하였습니다.")
			console.log(data);
			console.log(error);
			
	});
}