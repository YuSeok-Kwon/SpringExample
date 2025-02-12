package com.kepg.spring.ex.lifecycle;

public class Person {

	private String name;
	private int age;
	
//	생성자는 객체가 생성될 떄 같이 만들어 지는게 당연한 것
//	메소드는 나중에 추가 수정 될 수 있는 것으로 고려
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override  //모든 클래스의 부모 클래스인 object클래스에 toString 메소드가 존재한다
	public String toString() {
		return "이름 : " + name + "나이 : " + age; 
		// return 할 수 있으면 하는게 사용성이 좋아짐
	} 
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
