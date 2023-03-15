package fastcampus.javaSpring.chapter06.ch07StreamExample;

import java.util.Comparator;

public class TravelCustomer implements Comparator<TravelCustomer>{
	private String name;
	private int age; 
	private int price;

	public TravelCustomer(String name, int age, int price) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[고객명=" + name + ", 연령= 만 " + age + ", 비용=" + price + "만원]";
	}

	@Override
	public int compare(TravelCustomer customer1, TravelCustomer customer2) {
		String name1=customer1.getName();
		String name2=customer2.getName();
		return name1.compareTo(name2);
	}
}
