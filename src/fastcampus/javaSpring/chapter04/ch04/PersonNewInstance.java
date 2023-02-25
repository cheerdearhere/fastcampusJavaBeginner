package fastcampus.javaSpring.chapter04.ch04;

public class PersonNewInstance {
	private String name;
	private int age;
	
	public PersonNewInstance() {
		
	}
	public PersonNewInstance(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public PersonNewInstance(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
