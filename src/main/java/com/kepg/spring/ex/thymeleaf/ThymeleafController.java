package com.kepg.spring.ex.thymeleaf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
	
	@GetMapping("/ex01")
	public String ex01() {
		
		return "thymeleaf/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		List<String> fruitsList = new ArrayList<>();
		fruitsList.add("사과");
		fruitsList.add("바나나");
		fruitsList.add("딸기");
		
		model.addAttribute("fruitsList", fruitsList);
		
		// 사용자 정보 관리 리스트
		List<Map<String,Object>> userList = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("name", "권유석");
		userMap.put("age", 28);
		userMap.put("hobby", "독서");
		userList.add(userMap);
		
		userMap = new HashMap<>();
		userMap.put("name", "김성은");
		userMap.put("age", 22);
		userMap.put("hobby", "애니보기");
		userList.add(userMap);
		
		model.addAttribute("userList", userList);
		
		return "thymeleaf/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date date = new Date();
		
		LocalDate localDate = LocalDate.now();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("date", date);
		model.addAttribute("localDate", localDate);
		model.addAttribute("localDateTime", localDateTime);
		
		return "thymeleaf/ex03";
	}
}
