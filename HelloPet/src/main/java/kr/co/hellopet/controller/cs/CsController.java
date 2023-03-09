package kr.co.hellopet.controller.cs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hellopet.service.CsService;
import kr.co.hellopet.vo.CsVO;

/* 
 *  날짜 : 2023/03/09
 *  이름 : 김채영
 *  설명 : HelloPet CS 페이지 기능구현
 */
@Controller
public class CsController {
	
	@Autowired
	private CsService service;

	/* notice */
	@GetMapping("cs/notice/list")
	public String noticeList(Model model, String pg) {
		
		int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);

        int total = service.selectCountTotalNotice();
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getpageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

		
		List<CsVO> articles = service.selectNotices(start);
		model.addAttribute("articles", articles);
		model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageStartNum", pageStartNum);
        model.addAttribute("groups", groups);
		
		return "cs/notice/list";
	}

	@GetMapping("cs/notice/write")
	public String noticeWrite() {
		return "cs/notice/write";
	}
	
	@PostMapping("cs/notice/write")
	public String noticeWrite(CsVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
        vo.setRegip(regip);
        
        service.insertNotice(vo);
		
        return "redirect:/cs/notice/list";
	}
	
	@GetMapping("cs/notice/view")
	public String noticeView() {
		return "cs/notice/view";
	}
	
	@GetMapping("cs/notice/modify")
	public String noticeModify() {
		return "cs/notice/modify";
	}

	/* faq */
	@GetMapping("cs/faq/list")
	public String faqList() {
		return "cs/faq/list";
	}
	@GetMapping("cs/faq/write")
	public String faqWrite() {
		return "cs/faq/write";
	}
	@GetMapping("cs/faq/modify")
	public String faqModify() {
		return "cs/faq/modify";
	}
	
	/* qna */
	@GetMapping("cs/qna/list")
	public String qnaList() {
		return "cs/qna/list";
	}
	@GetMapping("cs/qna/write")
	public String qnaWrite() {
		return "cs/qna/write";
	}
	@GetMapping("cs/qna/view")
	public String faqView() {
		return "cs/qna/view";
	}

}
