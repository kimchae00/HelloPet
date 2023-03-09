package kr.co.hellopet.controller.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	
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
	public String view() {
		return "search/view";
	}
	
	@GetMapping("search/SearchHs")
	public String SearchHs() {
		return "search/SearchHs";
	}
	
	@GetMapping("search/SearchPm")
	public String SearchPm() {
		return "search/SearchPm";
	}
	
	
	
}
