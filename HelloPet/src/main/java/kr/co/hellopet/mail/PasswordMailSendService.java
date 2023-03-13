package kr.co.hellopet.mail;

import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PasswordMailSendService {
	
	@Autowired
	private JavaMailSender mailSender;
	private int authNumber;
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(88888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	public String joinEmail(String email) {
		makeRandomNumber();
		String setFrom = "HelloPet@gmail.com";
		String toMail = email;
		String title = "임시 비밀번호입니다.";
		String content = 
						"HelloPet Password." + 	//html 형식으로 작성 ! 
		                "<br>" + 
					    "인증 번호는 " + authNumber + "입니다." + 
					    "<br>" + 
					    "임시 비밀번호로 로그인 후 비밀번호 변경 부탁드립니다.."; //이메일 내용 삽입
		
		
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
	
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) { 
		MimeMessage message = mailSender.createMimeMessage();
		// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
			helper.setText(content,true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
