package kr.co.hellopet.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("admin/info")
	public String info() {
		return "admin/info";
	}
	@GetMapping("admin/confirm/list")
	public String confirmList() {
		return "admin/confirm/list";
	}
}
