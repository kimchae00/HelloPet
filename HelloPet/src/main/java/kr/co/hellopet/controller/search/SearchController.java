package kr.co.hellopet.controller.search;
/*
 * 날짜 : 2023/03/11 ~
 * 내용 : searchController 작성
 * 이름 : 장인화
 * */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.hellopet.service.SearchService;
import kr.co.hellopet.vo.SearchVO;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	
	@GetMapping(value = {"search/", "search/index"})
	public String index() {
		return "search/index";
	}
	
	@GetMapping("search/reserve")
	public String reserve() {
		return "search/reserve";
	}
	
	@GetMapping("search/complete")
	public String complete() {
		return "search/complete";
	}
	
	@GetMapping("search/view")
	public String view(Model model, String hosNo) {
		SearchVO a = service.selectView(hosNo);
		model.addAttribute("a",a);
		
		return "search/view";
	}
	
	@GetMapping("search/SearchHs")
	public String SearchHs(Model model, HttpSession sess, String search) {
		
		return "search/SearchHs";
	}
	
	@ResponseBody
	@PostMapping("search/SearchHs")
	public Map<String, Object> SearchHs(@RequestParam("search") String search, 
										@RequestParam("searchType") String searchType, 
										String pg,
										HttpSession sess) throws IOException {
		
		int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);
		
		Map<String, Object> map = new HashMap<>();
		
		 List<SearchVO> hss = null; // hss 변수 선언

	    if ("name".equals(searchType)) {
	        hss = service.SearchHsName(search, start);
	        map.put("hss", hss);
	    } else if ("addr".equals(searchType)) {
	        hss = service.SearchHsAddr(search);
	        map.put("hss", hss);
	    } else {
	        hss = service.SearchHs(search);
	        map.put("hss", hss);
	        
	        
	    }

	    if (hss != null && !hss.isEmpty()) { // hss 변수가 존재할 경우에 세션에 추가
	        sess.setAttribute("hss", hss);
	    }

	    int result = service.selectSearchHsTotal(search);

	    //model.addAttribute("search", search);
	    //model.addAttribute("hss", hss);
	    //model.addAttribute("result", result);
		
		// 페이징 처리

        int total = result;
        int lastPageNum = service.getLastPageNum(total);
        int pageStartNum = service.getpageStartNum(total, start);
        int[] groups = service.getPageGroup(currentPage, lastPageNum);

        map.put("groups", groups);
        map.put("currentPage", currentPage);
        map.put("start", start);
        map.put("total", total);
        map.put("lastPageNum", lastPageNum);
        
		return map;
	}
	
	
	@GetMapping("search/SearchPm")
	public String SearchPm() {
		return "search/SearchPm";
	}
	
	
	
}
