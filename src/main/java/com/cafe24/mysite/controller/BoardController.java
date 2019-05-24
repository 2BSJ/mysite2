package com.cafe24.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.security.Auth;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Auth
	@RequestMapping("/list")
	public String list(HttpSession session) {
		
		
		session.setAttribute("list",boardService.getList());
		
		return "board/list"; //리스트 get 구현
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@Auth
	@RequestMapping("/gowrite")
	public String gowrite(@RequestParam(value = "groupNo",required=true, defaultValue="0")int groupNo,
						  @RequestParam(value ="orderNo" ,required=true, defaultValue="0")int orderNo,
						  @RequestParam(value = "depth",required=true, defaultValue="0")int depth,
						  @RequestParam(value = "userNo",required=true, defaultValue="0")long userNo,
						  Model model) {

		
		System.out.println(groupNo);
		System.out.println(orderNo);
		System.out.println(depth);
		if(depth!=0&&orderNo!=0) {
		BoardVo vo = new BoardVo();
		vo.setGroupNo(groupNo);
		vo.setOrderNo(orderNo);
		vo.setDepth(depth);
		vo.setUserNo(userNo);
		model.addAttribute("vo",vo);
		}
		
		
		return "board/write"; 
	}
	
	@PostMapping(value="/writeboard")
	public String writeBoard(@ModelAttribute BoardVo vo) {
		

		System.out.println(vo.getContents());
		System.out.println("depth : " + vo.getDepth());
		System.out.println("order no : " + vo.getOrderNo());
			boardService.insert(vo);

		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/view")
	public String viewBoard(@RequestParam("no") Long no,Model model) {
		
		model.addAttribute("vo",boardService.getContents(no));
		return "board/view";
	}
	
	@RequestMapping("/gomodify")
	public String goModify() {
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute BoardVo vo,HttpSession session) {
		
		
		System.out.println(vo.getNo()+","+vo.getTitle()+","+vo.getContents());
		boardService.modify(vo);
		return "redirect:/board/list";
	}
	

	@RequestMapping("/delete")
	public String delete(@RequestParam("no")Long no) {
		
		boardService.delete(no);
		return "redirect:/board/list";
	}

}
