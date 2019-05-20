package com.cafe24.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping("/list")
	public String guestBook(HttpSession session) {
		session.setAttribute("list",guestbookService.getList());
		return "/guestbook/list";
	}
	@RequestMapping(value ="/gomodify", method=RequestMethod.GET)
	public String goModify(@RequestParam("no") Long no,HttpSession session) {
		
		session.setAttribute("vo", guestbookService.getList(no));
		
		return "/guestbook/modify";
	}
	
	@RequestMapping(value ="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute GuestbookVo vo,HttpSession session) {
		
		guestbookService.modify(vo);
		return "redirect:/guestbook/list";
	}
	
	
	@RequestMapping(value ="/deleteform")
	public String deleteForm(@ModelAttribute GuestbookVo vo,HttpSession session) {
		
		session.setAttribute("no", vo.getNo());
		return "/guestbook/deleteform";
	}
	
	@RequestMapping(value ="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("no") Long no,@RequestParam("password") String password) {
		
		System.out.println(no);
		System.out.println(password);
		guestbookService.delete(no,password);
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping(value ="/add", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestbookVo vo) {
		guestbookService.add(vo);
		return "redirect:/guestbook/list";
	}


}
