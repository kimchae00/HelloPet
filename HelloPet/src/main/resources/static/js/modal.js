$(document).ready(function(){
	    $('button[name=btnPhar]').click(function(){
	        $('.change').remove();
	        $(this).addClass('on');
	        $('button[name=btnHos]').removeClass('on');
	        $('.change').remove();
	        let tags = "<tr class='change'>";
	            tags += "<td>약국명</td>";
	            tags += "<td>";
	            tags += "<input type='text' name='medicalName' required='required' placeholder='정보 입력하기 전에 미리 찾아보세요.' style='margin-right:9px'>";
	            tags += "<input type='button' name='searchPhar' id='btn-modal-pharmacy' value='약국찾기'>";
	            tags += "</td>";
	            tags += "</tr>";
	            tags += "<tr class='change'>";
	            tags += "<td>대표 약사</td>";
	            tags += "<td>";
	            tags += "<input type='text' name='ceo' placeholder='대표약사 입력해주세요'>";
	            tags += "</td>";
	            tags += "</tr>";
	        $('#pass').after(tags);
	    });
	
	    $('button[name=btnHos]').click(function(){
	        $('.change').remove();
	        $(this).addClass('on');
	        $('button[name=btnPhar]').removeClass('on');
	        $('#change').remove();
	        let tags = "<tr class='change'>";
	            tags += "<td>병원명</td>";
	            tags += "<td>";
	            tags += "<input type='text' name='medicalName' required='required' placeholder='정보 입력하기 전에 미리 찾아보세요.' style='margin-right:9px'>";
	            tags += "<input type='button' name='searchHos' id='btn-modal-medical' value='병원찾기'>";
	            tags += "</td>";
	            tags += "</tr>";
	            tags += "<tr class='change'>";
	            tags += "<td>대표 수의사</td>";
	            tags += "<td>";
	            tags += "<input type='text' name='ceo' placeholder='대표수의사 입력해주세요'>";
	            tags += "</td>";
	            tags += "</tr>";
	        $('#pass').after(tags);
	    });
	});

	$(document).ready(function(){
	
	    // 기본 modal (병원찾기)
	    $('#btn-modal').click(function(){
	        $('#modal-medical').css('display','flex');
	        document.body.style.overflow = "hidden";
	    });
	
	    $('.close-area').click(function(){
	        $('#modal-medical').css('display','none');
	        document.body.style.overflow = "unset";
	    });
	
	    // 병원찾기
	    $(document).on('click','#btn-modal-medical',function(){
	        $('#modal-medical').css('display','flex');
	        document.body.style.overflow = "hidden";        
	    });
	
	    // 약국찾기
	    $(document).on('click','#btn-modal-pharmacy',function(){        
	        $('#modal-pharmacy').css('display','flex');
	        document.body.style.overflow = "hidden";
	    });
	
	    // 약국닫기
	    $('.close-area').click(function(){
	        $('#modal-pharmacy').css('display','none');
	        document.body.style.overflow = "unset";
	    });
	});