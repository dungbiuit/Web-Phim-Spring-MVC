package doan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import do_an.entity.User;



@Controller

public class DoAnController {
										// Ở trang chính
	@RequestMapping("/main/index")
	public String index(){
		return "main/index";
	}
	@RequestMapping("/main/phim_le")
	public String phim_le(){
		return "main/phim_le";
	}
	
													
	
	
}
