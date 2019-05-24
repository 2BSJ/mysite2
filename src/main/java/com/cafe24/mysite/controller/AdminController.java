package com.cafe24.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Auth(role=Auth.Role.ADMIN) //인증을 받아야하는데 admin이 있어야 admincontrooler에 들어오는군아 구현구현구현구현구현 ㅇㅅㅇ
@RequestMapping("/admin")
@Controller
public class AdminController {

	
	@RequestMapping({"","/main"})
	public String main() {
		return "admin/main";
	}

	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}
	
	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	

	
}
