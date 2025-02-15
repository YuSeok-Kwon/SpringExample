package com.kepg.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.ex.mybatis.domain.Review;
import com.kepg.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	// 클라이언트에서 전달 받은 id와 일치하는 리뷰정보를 json으로 response에 담는다.
	
	@ResponseBody
	@RequestMapping("/mybatis/review")
	public Review review(@RequestParam("id") int id) {
		// @RequestParmam("id")
		// ==
		// int id = Integer.parseInt(request.getParameter("id");
		
		// 전달한 id와 일치하는 리뷰정보 얻어오기 
		Review review = reviewService.getreview(id);
		return review;
	}
}
