package com.kepg.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.ex.jpa.repository.StudentRepository;
import com.kepg.spring.ex.jpa.student.Student;
import com.kepg.spring.ex.jpa.studentService.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	// JPA(Java Persistance API)
	// 데이터 저장, 조회, 수정, 삭제를 위한 인터페이스
	// 메소드를 통한 간단한 사용
	// 객체를 다루는 개념(Objective Relational Mapping)
	
	@Autowired
	private StudentService service;
	
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 권보보, 010-1234-5678, kBoBo@gmail.com, 백수
		
		Student student = service.addStudent("권보보", "01012345678", "kBoBo@gmail.com", "백수");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 학생의 장래희망을 고양이로 변경
		
		Student student = service.updateStudent(3, "고양이");
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 학생정보 삭제
		service.deleteStudent(3);
		
		return "삭제 성공!";
	}
	
	@Autowired
	private StudentRepository repository;
	// 절대 Controller에서 Repository를 직접 연결하면 안됌.
	// 지금은 예제 진행을 위해서 연결하는 것임
	
	@ResponseBody
	@GetMapping("/find")
	public List<Student>findStudent() {
		
		List<Student> studentList = null;
		
		// 모든 행 조회
//		studentList = repository.findAll();
//		return studentList;
		
//		studentList = repository.findAllByOrderByIdDesc();
		
//		studentList = repository.findTop2ByOrderByIdDesc();
		
//		studentList = repository.findByName("권보보");
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("권유석");
//		nameList.add("유재석");
//		studentList = repository.findByNameIn(nameList);
		
//		studentList = repository.findByEmailContaining("gmail");
		
//		studentList = repository.findByIdBetweenOrderByIdDesc(1, 3);
		
		studentList = repository.selectByDreamJob("백수");
		
		return studentList;
		
	
	}
	
	@ResponseBody
	@GetMapping("/jpa/lombok/1")
	public Student lombokTest1() {
		
		// 멤버변수들의 값을 저장해서 값을 관리하는 클래스 객체를 생성할 때 주로 사용(ex. entity Class)
		Student student1 = new Student(4, "김성은", "010-8012-8065", "kyus0919@gmail.com", "프로그래머", null, null);
		student1.setPhoneNumber("010-5228-7948");
		
		return student1;
	}
	
	@ResponseBody
	@GetMapping("/jpa/lombok/2")
	public Student lombokTest2() {
		// builder 패턴
		Student student2 = Student.builder()
				.name("권무무")
				.phoneNumber("010-1111-2222")
				.dreamJob("개껌 기공사")
				.build();
		
		return student2;
	}
}
