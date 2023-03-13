let regUid    = /^[a-z]+[a-z0-9]{4,19}$/g;
let regName   = /^[가-힣]{2,4}$/;
let regNick   = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
let regEmail  = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let regHp	  = /^\d{3}-\d{3,4}-\d{4}$/;
let regTel 	  = /^\d{2,3}-\d{3,4}-\d{3,4}$/;
let regCeoHP  = /^\d{3}-\d{3,4}-\d{4}$/;
let regPass   = /^.*(?=^.{5,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
let isUidOk   = false;
let isPassOk  = false;
let isNameOk  = false;
let isNickOk  = false;
let isEmailOk = false;
let isHpOk    = false;	
let isTelOk   = false;
let isCeoHpOk   = false;

$(document).ready(function(){
	
	$('input[name=btnUidCheck]').click(function(){
		
		let uid = $('input[name=uid]').val();
				
		if(uid.match(regUid)){
			
			let jsonData = {'uid' : uid};
			
			$.ajax({
				url : '/HelloPet/member/countUid',
				method : 'GET',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					if(data.result < 1){
						isUidOk = true;
						alert('사용가능한 아이디입니다.');
					}else{
						isUidOk = false;
						alert('사용중인 아이이디입니다.');
					}
				}
			});
		}else{
			isUidOk = false;
			alert('아이디는 영어 또는  영어,숫자 포함 4글자 이상 부탁드립니다.');
		}
	});
	
	
	$('input[name=btnHpCheck]').click(function(){
		
		let hp = $('input[name=hp]').val();
		
		if(hp.match(regHp)){
			
			let jsonData = {'hp' : hp};
						
			$.ajax({
				url : '/HelloPet/member/countHp',
				method : 'GET',
				data : jsonData,
				dataType : 'json',
				success : function(data){
					if(data.result < 1){
						isHpOk = true;
						alert('사용 가능');
						
					}else{
						isHpOk = false;
						alert('이미 가입된 전화번호입니다.');
					}
				}
			});
		}else{
			isHpOk = false;
			alert('- 포함 13자리 입력부탁드립니다.');
		}
	});
	
	$('input[name=name]').change(function(){
    		
		let name = $(this).val();
		
		if(name.match(regName)) {
			isNameOk = true;
		}else{
			isNameOk = false;
			alert('사용불가');
		}
	});
	
	$('input[name=pass2]').keyup(function(){
		
		let pass1 = $('input[name=pass1]').val();
		let pass2 = $('input[name=pass2]').val();
		
		if(pass1 == pass2){
			if(pass2.match(regPass)){
				//비밀번호 유효성 검사
				isPassOk = true;
				$('.passwordMsg').css('color','green').text('사용 가능한 패스워드입니다.');
			}else{
				isPassOk = false;
				$('.passwordMsg').css('color','red').text('유효하지 않은 패스워드입니다.');
			}
		}else{
			// 비밀번호 일치 여부
			isPassOk = false;
			$('.passwordMsg').css('color','red').text('비밀번호가 일치하지 않습니다.');
		}
	});
	
	$('input[name=tel]').focusout(function(){
		let tel = $(this).val();
		
		if(tel.match(regTel)){
			isTelOk = true;				
		}else{
			isTelOk = false;
			alert('- 포함 전화번호 입력해주세요.');
		}
	});
	
	$('input[name=ceoHp]').focusout(function(){
		let ceoHp = $(this).val();
	
		if(ceoHp.match(regCeoHP)){
			isCeoHpOk = true;				
		}else{
			isCeoHpOk = false;
			$(this).val('');
			alert('- 포함 전화번호 입력해주세요.');
		}
	});
	
	$('input[name=register_submit]').click(function(){
		
		// 아이디 검증
		if(!isUidOk){
			alert('아이디를 확인 하십시오');
			return false;
		}
	
	    // 휴대폰 검증
		if(!isHpOk){
			alert('휴대폰을 확인 하십시요.');
			return false;
		}
	
	    // 이름 검증
		if(!isNameOk){
			alert('이름을 확인 하십시요.');
			return false;
		}
		
		// 이메일 검증
		if(!isEmailOk){
			alert('이메일을 확인 하십시요.');
			return false;
		}
	
		// 비밀번호 검증
		if(!isPassOk){
			alert('비밀번호를 확인 하십시요.');
			return false;
		}
		
		// 연락처 검증
		if(!isTelOk){
			alert('연락처를 확인 하십시오');
			return false;
		}
		
		// 대표 연락처 검증
		if(!isCeoHpOk){
			alert('대표 연락처를 확인 하십시오');
			return false;
		}
	
	// 최종 전송
	return true;
    });

});