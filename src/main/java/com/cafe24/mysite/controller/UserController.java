package com.cafe24.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.UserService;
import com.cafe24.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserVo userVo) {
		return "user/join";
	}
	
	
	//Valid를 이용한 
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join( //->Valid추가 UserVo()
			@ModelAttribute @Valid UserVo userVo,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for(ObjectError error : list) {
//				System.out.println(error);
//			}
			model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}

//	public String update(@AuthUser UserVo authUser,Model model) {
//		UserVo userVo = userService.getUser(authUser.getNo());
//		model
//	}
	
	
	
	
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(
//		@RequestParam(value="email", required=true, defaultValue="") String email,
//		@RequestParam(value="password", required=true, defaultValue="") String password,
//		HttpSession session,
//		Model model) {
//		
//		UserVo authUser = userService.getUser( new UserVo(email, password) );
//		if(authUser == null) {
//			model.addAttribute("result", "fail");
//			return "user/login";
//		}
//		
//		// session 처리
//		session.setAttribute("authUser", authUser);
//		
//		return "redirect:/";
//	}

//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("authUser");
//		session.invalidate();
//		
//		return "redirect:/";
//	}
	
//	@ExceptionHandler( UserDaoException.class)
//	public String handleUserDaoException() {
//		return "error/exception.jsp";
//	}
	
}