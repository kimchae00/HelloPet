package kr.co.hellopet.controller.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hellopet.service.CommunityService;
import kr.co.hellopet.vo.CommunityVO;

/*
 * 날짜 : 2023/03/09
 * 이름 : 김경준
 * 설명 : HelloPet 커뮤니티 페이지 기능구현
 */

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	// tip 목록
	@GetMapping("community/tip/list")
	public String tipList() {
		return "community/tip/list";
	}
	
	// tip 글보기
	@GetMapping("community/tip/view")
	public String tipView() {
		return "community/tip/view";
	}
	
	// tip 글쓰기
	@GetMapping("community/tip/write")
	public String tipWrite() {
		
		
		return "community/tip/write";
	}
	
	// tip 글쓰기 폼
	@PostMapping("community/tip/write")
	public String tipWrite(CommunityVO vo, Model model, HttpServletRequest req) {
		
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertTipArticle(vo);
		
		return "redirect:/community/tip/list";
	}
	
	// tip 글수정
	@GetMapping("community/tip/modify")
	public String tipModify() {
		return "community/tip/modify";
	}
	
	// talktalk 목록
	@GetMapping("community/talktalk/list")
	public String talkList() {
		return "community/talktalk/list";
	}
	
	// talktalk 글쓰기
	@GetMapping("community/talktalk/write")
	public String talkWrite() {
		return "community/talktalk/write";
	}
	
	// talktalk 글수정
	@GetMapping("community/talktalk/modify")
	public String talkModify() {
		return "community/talktalk/modify";
	}
}
