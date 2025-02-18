package com.kepg.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// id가 5인 행 조회
	public Review selectReview(@Param("id") int id);
	
	//int id -> JAVA문법의 파라미터, 메소드를 호출 할 때 인자로 전달
	// @Param("id") -> int id의 값을 xml에서 사용 할 수 있도록 int id의 값을 키워드("id")로 xml에 전달
	
	//내용을 전달 받고 new_review 테이블에 저장
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	public int insertReviewByObject(Review review);
}
	
	