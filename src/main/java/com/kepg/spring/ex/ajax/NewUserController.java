package com.kepg.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	
	@Autowired
	private UserService service;
	
	
	// 사용자 추가 AP
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			){
		int count = service.addUser(name, birthday, email, introduce);
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 : {"result" : "success"}
		// 실패 : {"result" : "fail"}
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String newUser() {
		return "/ajax/NewUser";
	}
}
