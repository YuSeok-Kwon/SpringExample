package com.kepg.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.ex.mvc.domain.User;
import com.kepg.spring.ex.mvc.service.UserService;

@RequestMapping("/mvc/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	// 사용자 정보를 전달 받고 저장하는 기능
//	@RequestMapping(path="/mvc/user/create", method=RequestMethod.POST)
	@PostMapping("/create")
	@ResponseBody
	public int createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce) {
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		return count;
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "mvc/userInput";
	}
	
	@GetMapping("/info")
	public String infoUser(Model model) {
		// 가장 최근에 등록된 사용자 정보 얻어오기
		User user = userService.getUserInfo();
		
		model.addAttribute("userrrr", user);
		return "mvc/userInfo";
	}
}
