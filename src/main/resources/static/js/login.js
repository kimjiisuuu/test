
/* 로그인 유효성 검사 */
 
 function func_login(loginError) {
	
	const frm = document.forms[0]
	const id = frm.id
	const password =  frm.password
	let isValid = true
	
	if(id.value == '') {
		alert('아이디는 필수 입력입니다.')
		id.focus()
		isValid = false
	}
	if(isValid && password.value == '') {
		alert('패스워드는 필수 입력입니다.')
		password.focus()
		isValid = false
	} else


	if(loginError) {
		alert('아이디 또는 비밀번호가 잘못되었습니다.');
		redirectToIndex(); // 페이지 이동 함수 호출
	}else {
		if (isValid) {
			frm.submit()
		}
	}

/*	/!* 아이디나 비밀번호가 틀렸을 경우 *!/
	 function func_check(loginError) {
		 if(loginError) {
			 alert('아이디 또는 비밀번호가 잘못되었습니다.');
			 redirectToIndex(); // 페이지 이동 함수 호출
		 }
	 }*/
	 function redirectToIndex() {
		 window.location.href = '/index';
	 }
	
	
	
} 