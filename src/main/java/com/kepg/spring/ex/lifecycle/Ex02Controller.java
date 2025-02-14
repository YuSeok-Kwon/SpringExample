package com.kepg.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02") // 클라이언트가 요청하기 위한 url지정하는 것
	public String ThymeleafResponse() {
		
		// src/main/resources/templates ~
		return "lifecycle/ex02"; // templates까지는 고정된 경로, html파일도 고정된 값이므로 생략가능
		// response에 담을 html 경로를 return해 주는것
	}
}
