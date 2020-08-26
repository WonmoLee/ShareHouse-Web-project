function signup() {
	$('.email__check').empty();
	$('#password').remove();
	$('#signup_btn').remove();
	$('#login_btn').remove();
	$('.social_login').empty();
	$('#signup_form').append(
		'<input id="email" class="text-input1" type="email" placeholder=" 이메일을 입력해주세요."/>',
		'<input id="ph_num" class="text-input1" type="tel" placeholder=" 연락처를 입력해주세요."/>',
		'<input id="address" class="text-input1" type="text" placeholder=" 주소를 입력해주세요."/>',
		'<input id="bank_name" class="text-input1" type="text" placeholder=" 은행명을 입력해주세요."/>',
		'<button id="signup_btn" class="btn2" onclick="" style="width: 435px;height: 37px;border-radius: 0.4vw;border: 0.5px;background: #da553b;color: white;cursor: pointer;margin-bottom: 50px;">이 정보로 회원가입</button>'
	);
}