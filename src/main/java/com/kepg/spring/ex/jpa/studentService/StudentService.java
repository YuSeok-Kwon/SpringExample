package com.kepg.spring.ex.jpa.studentService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.ex.jpa.repository.StudentRepository;
import com.kepg.spring.ex.jpa.student.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student addStudent(
			String name
			, String phoneNumber
			, String email
			, String dreamJob) {
		
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		 
		// 여기서 return해주는 Student객체에는 완전한 한 행의 정보가 담겨있다.(id, updatedAt, createdAt 등등)
		Student result = repo.save(student); 
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// 수정 대상 행을 조회 한다
		// 조회 결과를 객체로 얻어온다
		// 해당 객체에 수정사항을 적용한다
		// 수정된 객체를 저장한다.
		
		// Optional
		// Null일 수도 있는 객체를 Null을 처리하는 기능으로 감싸놓은 객체
		// Null을 다룰 때 발생하는 NullPointerException 위험을 줄여주기 위한 용도
		// Null일 수도 있는 return의 값에 return 타입으로 주로 사용
		Optional<Student>  optionalStudent = repo.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder()
				.dreamJob(dreamJob)
				.build();
		
		// save메소드 
		// 전달된 entity Class 객체에 primary key가 있으면 update 쿼리 수행
		// primary key가 없으면 insert 쿼리 수행
		Student result = repo.save(student);
		
		return result;
	}
	
	public void deleteStudent(int id) {
		// 삭제대상을 조회한다
		// 조회된 행의 정보를 삭제한다
		
		Optional<Student> optionalStudent = repo.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		repo.delete(student);
	}
}
