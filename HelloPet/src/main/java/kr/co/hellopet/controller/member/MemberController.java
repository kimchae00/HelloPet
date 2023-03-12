package kr.co.hellopet.controller.member;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hellopet.service.MailSendService;
import kr.co.hellopet.service.MemberService;
import kr.co.hellopet.vo.Api_HospitalVO;
import kr.co.hellopet.vo.Api_PharmacyVO;
import kr.co.hellopet.vo.MedicalVO;
import kr.co.hellopet.vo.MemberVO;

/* 
 *  HelloPet Project 
 *  날짜 : 2023/03/08
 *  담당 : 이민혁
 *  설명 : HelloPet Member 페이지 기능구현
 * 
 */

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MailSendService mailService;
	
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
	public String terms(@RequestParam(value="type") String type, Model model) {
		
		model.addAttribute("type",type);
		
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
		return "redirect:/member/login";
	}
	
	// 가입 (병원 약국)
	@GetMapping("member/registerMedical")
	public String registerMedical() {
		return "member/registerMedical";
	}
	
	@PostMapping("member/registerMedical")
	public String registerMedical(MedicalVO vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertMedical(vo);
		return "redirect:/member/login";
	}
	
	@ResponseBody
	@GetMapping("member/SearchHospital")
	public Map<String, List<Api_HospitalVO>> searchHospital(@RequestParam("trial") String trial, @RequestParam("county") String county, @RequestParam("name") String name) {
		
		/*System.out.println("trial : " + trial);
		System.out.println("county : " + county);
		System.out.println("name : " + name);*/
		
		List<Api_HospitalVO> vo = service.selectMedical(trial, county, name);
		
		Map<String, List<Api_HospitalVO>> map = new HashMap<>();
		
		map.put("result", vo);
		System.out.println("size : " + vo.size());
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("member/SearchPharmacy")
	public Map<String, List<Api_PharmacyVO>> searchPharmacy(@RequestParam("trial") String trial, @RequestParam("county") String county, @RequestParam("name") String name) {
		
		/*System.out.println("trial : " + trial);
		System.out.println("county : " + county);
		System.out.println("name : " + name);*/
		
		List<Api_PharmacyVO> vo = service.selectPharmacy(trial, county, name);
		
		Map<String, List<Api_PharmacyVO>> map = new HashMap<>();
		
		map.put("result", vo);
		System.out.println("size : " + vo.size());
		
		return map;
	}
	
	// 아이디 비밀번호 찾기
	@GetMapping("member/find")
	public String find() {
		return "member/find";
	}
	
	@ResponseBody
	@GetMapping("member/findId")
	public Map<String, MemberVO> findId(@RequestParam("name") String name, @RequestParam("hp") String hp) {
		
		MemberVO vo = service.selectFindId(name, hp);
		Map<String, MemberVO> map = new HashMap<>();
		map.put("result", vo);
		
		//System.out.println("map : " + map );
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("member/password")
	public Map<String, MemberVO> password(@RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("hp") String hp) {
		
		MemberVO vo = service.selectChangePass(email, name, hp);
		Map<String, MemberVO> map = new HashMap<>();
		map.put("result", vo);
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("member/changePass")
	public Map<String, Integer> changePass(@RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("hp") String hp, MemberVO vo) {
		
		int code = service.makeRandomPass();
		System.out.println(code);
		service.updatePetOwnerPasswordByCodeAndInfo(code, email, name, hp);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", code);
		
		return map;
	}

	// uid 중복체크
	@ResponseBody
	@GetMapping("member/countUid")
	public Map<String, Integer> countUid(@RequestParam("uid") String uid) {
		int result = service.countUid(uid);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	// hp 중복체크
	@ResponseBody
	@GetMapping("member/countHp")
	public Map<String, Integer> countHp(@RequestParam("hp") String hp) {
		int result = service.countHp(hp);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	// email 중복체크
	@ResponseBody
	@GetMapping("member/countEmail")
	public Map<String, Integer> countEmail(@RequestParam("email") String email) {
		int result = service.countEmail(email);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	// nick 중복체크
	@ResponseBody
	@GetMapping("member/countNick")
	public Map<String, Integer> countNick(@RequestParam("nick") String nick) {
		int result = service.countNick(nick);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("member/emailTest")
	public String test() {
		return null;
	}
	
	//회원가입 이메일 인증
	@ResponseBody
	@GetMapping("member/registerAuth")
	public String test(@RequestParam("email") String email) {
		
		System.out.println("이메일 들어오기 확인!!");
		System.err.println("이메일 확인하기 : " + email);
		
		return mailService.joinEmail(email);
	}
	
	//회원가입 이메일 인증
}
