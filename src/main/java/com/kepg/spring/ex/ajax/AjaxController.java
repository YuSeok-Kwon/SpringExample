package com.kepg.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	// API : 데이터(JSON)를 담은 response를 구성하는 페이지
	// API(JSON) <-> View(html) 다 똑같지만 response에 담기는 응답의 형태만 다름
	// 이름과 생년월일을 전달 받고,
	// 이름과 나이를 JSON으로 응답에 담는 페이지
	
	@ResponseBody
	@GetMapping("/ajax/person")
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birth") String birth) {
		
		int year = Integer.parseInt(birth.substring(0, 4));
		int age = 2025 - year;
		
		//{"name" : "권유석", "age" : "28"}
		
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
	}
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		
		return "/ajax/ex01";
	}
	
}
