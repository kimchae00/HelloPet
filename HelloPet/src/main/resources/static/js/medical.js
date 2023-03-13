
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
		

	
	// 최종 전송
	return true;
    });

});