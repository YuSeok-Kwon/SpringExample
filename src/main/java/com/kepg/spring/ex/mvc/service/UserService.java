package com.kepg.spring.ex.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.ex.mvc.domain.User;
import com.kepg.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	// 사용자 정보를 전달 받고, 저장하는 기능
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce){
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	public User getUserInfo(){
		// 가장 최근에 추가된 사용자의 정보를 얻어오기
		User user = userRepository.selectUser();
		
		return user;
	}
	
	// email을 전달 받고, 중복 여부를 확인하는 기능
	public boolean isDuplicateEmail(String email) {
		int count = userRepository.selectCountByEmail(email);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
