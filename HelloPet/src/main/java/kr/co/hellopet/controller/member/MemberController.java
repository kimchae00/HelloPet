package kr.co.hellopet.controller.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hellopet.service.MemberService;
import kr.co.hellopet.vo.MemberVO;

@Controller
public class MemberController {
	
	/* 
	 *  HelloPet Project 
	 *  날짜 : 2023/03/08
	 *  담당 : 이민혁
	 *  설명 : HelloPet Member 페이지 기능구현
	 * 
	 */ 
	
	@Autowired
	private MemberService service;
	
	// 로그인
	@GetMapping("member/login")
	public String login() {
		return "member/login";
	}
	
	// 조인 (회원가입 구분)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	// 약관
	@GetMapping("member/terms")
	public String terms() {
		return "member/terms";
	}
	
	// 가입 (일반회원)
	@GetMapping("member/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("member/register")
	public String register(MemberVO vo, HttpServletRequest req) {
		
		// ip 설정
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertMember(vo);
		return "redirect:member/lgoin";
	}
	
	// 가입 (병원 약국)
	@GetMapping("member/registerMedical")
	public String registerMedical() {
		return "member/registerMedical";
	}
	
	// 아이디 비밀번호 찾기
	@GetMapping("member/find")
	public String find() {
		return "member/find";
	}

}
