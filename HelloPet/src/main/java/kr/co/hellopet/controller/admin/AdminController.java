package kr.co.hellopet.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.hellopet.service.AdminService;
import kr.co.hellopet.vo.MedicalVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("admin/info")
	public String info(Model model) {
		MedicalVO vo = service.selectAdmin();
		
		model.addAttribute("vo",vo);
		return "admin/info";
	}
	@GetMapping("admin/confirm/list")
	public String confirmList() {
		return "admin/confirm/list";
	}
	
	@GetMapping("admin/infoModify")
	public String infoModify(Model model) {
		MedicalVO vo = service.selectAdmin();
		
		model.addAttribute("vo",vo);
		return "admin/infoModify";
	}
	
	@PostMapping("admin/infoModify")
	public String infoModify(MedicalVO vo) {
		service.updateAdmin(vo);
		return "redirect:/admin/info";
	}
}
