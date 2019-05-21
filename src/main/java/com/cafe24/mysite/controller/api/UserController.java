package com.cafe24.mysite.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.UserService;



@RequestMapping("/user/api")
@Controller("userAPIController") //유저컨트롤러로 두개의 클래스가 만들어져 컨테이너안에서 id값이 중복되기떄문에
//이건 다른이름으로 지정해주기
public class UserController {
	
	@Autowired
	private UserService userService;

//	@ResponseBody
//	@RequestMapping("/checkemail")
//	public Map<String,Object> checkEmail(String email) {
//		Boolean exist = userService.existEmail(email);
//		Map<String, Object> map = new HashMap<String,Object>();
//		map.put("result",  "success");
//		map.put("data", exist);
//		//map.put("message",".........");
//		return map;
//		
//	}
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkEmail1(@RequestParam(value="email",required=true) String email) {
		Boolean exist = userService.existEmail(email);
		return JSONResult.success(exist);
		
		
		
	}
}
