package kr.co.hellopet.controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {
	
	@GetMapping("community/tip/list")
	public String tipList() {
		return "community/tip/list";
	}
	
	@GetMapping("community/tip/view")
	public String tipView() {
		return "community/tip/view";
	}
	
	@GetMapping("community/tip/write")
	public String tipWrite() {
		return "community/tip/write";
	}
	
	@GetMapping("community/tip/modify")
	public String tipModify() {
		return "community/tip/modify";
	}
	
	@GetMapping("community/talktalk/list")
	public String talkList() {
		return "community/talktalk/list";
	}
	
	@GetMapping("community/talktalk/write")
	public String talkWrite() {
		return "community/talktalk/write";
	}
	
	@GetMapping("community/talktalk/modify")
	public String talkModify() {
		return "community/talktalk/modify";
	}
}
