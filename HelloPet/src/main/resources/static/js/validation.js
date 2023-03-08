let regUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
let regName  = /^[가-힣]{2,4}$/;
let regNick  = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;
let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let regHp	 = /^\d{3}-\d{3,4}-\d{4}$/;
let regPass  = /^.*(?=^.{5,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
let isUidOk   = false;
let isPassOk  = false;
let isNameOk  = false;
let isNickOk  = false;
let isEmailOk = false;
let isHpOk    = false;	

    $(document).ready(function(){
        $('input[name=btnHpCheck]').click(function(){

            let hp = $('input[name=registerHp]').val();

            if(!hp.match(regHp)){
                isHpOk = false;
                alert('유효성 확인!');
            }else{
                isHpOk = true;
            }
        });

        $('input[name=registerName]').focusout(function(){

            let name = $(this).val();

            if(!name.match(regName)){
                isNameOk = false;
                alert('유효성 확인!');
            }else{
                isNameOk = true;
            }
        });

        $('input[name=btnEmailCheck]').click(function(){

            let email = $('input[name=registerEmail]').val();

            if(!email.match(regEmail)){
                isEmailOk = false;
                alert('유효성 확인!');
            }else{
                isEmailOk = true;
            }
        });

        $('input[name=pass2]').focusout(function(){
            let pass1 = $('input[name=pass1]').val();
            let pass2 = $(this).val();

            if(pass1 == pass2){
                if(pass2.match(regPass)){
                    isPassOk = true;
                }else{
                    isPassOk = false;
                    alert('유효하지 않습니다.');
                }
            }else{
                alert('일치안함');
            }
        });

        $('input[name=btnNickCheck]').click(function(){

            let nick = $('input[name=registerNick]').val();

            if(!nick.match(regNick)){
                isNickOk =false;
                alert('dd');
            }else{
                isNickOk = true;
                alert('true');
            }
        });

        $('input[name=register_submit]').click(function(){

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

		// 비밀번호 검증
		if(!isPassOk){
			alert('비밀번호를 확인 하십시요.');
			return false;
		}
		
		// 별명 검증
		if(!isNickOk){
			alert('별명을 확인 하십시요.');
			return false;
		}
		// 이메일 검증
		if(!isEmailOk){
			alert('이메일을 확인 하십시요.');
			return false;
		}
		
		
		// 최종 전송
		return true;
        });

    });