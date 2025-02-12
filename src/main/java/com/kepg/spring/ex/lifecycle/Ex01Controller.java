package com.kepg.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lifecycle/ex01")

@Controller // 요청과 응답을 처리할 때 사용하는 annotation
public class Ex01Controller {

	// 간단한 html 태그를 response에 담는 페이지
	@ResponseBody  
	// 해당하는 객체를 그대로 responsebody에 담고 싶을 때 사용
	// 알아서 타입(html, json 등)을 response에 담아서 문자열로 돌려줌
	@RequestMapping("/1")
	public String htmlResponse() {
		return "<h2>예제 1번</h2>";
	}
	
	// 맵 객체를 response에 담는 페이지
	@ResponseBody
	@RequestMapping("/2")
	public Map<String,Integer> mapResponse(){
		// 과이 이름 : 가격
		Map<String,Integer> fruitMap = new HashMap<>();
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 4000);
		fruitMap.put("orange", 1300);
		
		return fruitMap;
	}
	
	
	
	
	
}
