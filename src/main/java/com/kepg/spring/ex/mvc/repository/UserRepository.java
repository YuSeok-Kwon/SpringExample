package com.kepg.spring.ex.mvc.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kepg.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {

	// 사용자 정보를 전달 받고 new_user 테이블 한 행 삽입
	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email
			, @Param("introduce") String introduce);
	
	public User selectUser();
	
	//전달 받은 email과 일치하는 행의 개수 조회
	public int selectCountByEmail(@Param("email") String email);
}
