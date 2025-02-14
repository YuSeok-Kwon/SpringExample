package com.kepg.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 비슷한 역할을 하는, 목적을 가진 메소드들을 한 클래스에 묶어놓음
// 즉 RequestMapping에 공통 요소가 많이 생길 수 있음
@RequestMapping("/lifecycle/ex01")
//공통 요소들을 묶어 놓고 다른 점만 메소드에 개별적으로 부여

@RestController 
// @Controller + @ResponseBody
// 즉 해당 클래스의 모든 메소드는 @ResponseBody가 적용된다.
public class Ex01RestController {

	// 직접 만든클래스의 객체를 response에 담는다
	@RequestMapping("/3")
	public Person objectResponse(){
		
		Person me = new Person("권유석", 26);
		
		return me;
		
	}
	// 이 상태라면 406에러 발생
	// @ResponseBody가 멤버 변수에 접근하지 못하기 떄문(private설정이 되어있고, getter가 없어서)

	// status code 직접 설정
	// status code : 404NOT FOUND 처럼 요청 응답처리 결과를 코드로 알려주는 것
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse(){
		Person me = new Person("권유석", 26);
		
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR); 
		
		return entity;
	}

	

}
