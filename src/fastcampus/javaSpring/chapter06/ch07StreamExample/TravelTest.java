package fastcampus.javaSpring.chapter06.ch07StreamExample;

import java.util.ArrayList;

public class TravelTest {

	public static void main(String[] args) {
		TravelCustomer customerLee = new TravelCustomer("이순신", 40, 100);
		TravelCustomer customerKim = new TravelCustomer("김유신", 20, 100);
		TravelCustomer customerHong = new TravelCustomer("홍길동", 13, 50);
		
		ArrayList<TravelCustomer> customerList = new ArrayList<TravelCustomer>();
		customerList.add(customerKim);
		customerList.add(customerLee);
		customerList.add(customerHong);
		
		//reduce로 꺼내고 출력을 따로 했지만 .forEach(System.out.println())을 써도 됨.
		System.out.println("1. 고객의 총명단");
		String name=customerList.stream()
					.map(customer->customer.toString())
					.sorted()
					.reduce("",(a,b)->a+b+"\n");
		System.out.println(name);
		
		System.out.println("2. 여행의 총비용");
		int cost = customerList.stream()
					.mapToInt(customer->customer.getPrice())
					.sum(); 
		System.out.println(cost+"만원");
		System.out.println();
		
		System.out.println("3. 고객 중 20세 이상의 이름을 정렬");
		String adultList = customerList.stream()
				.filter(customer->customer.getAge()>=20)
				.map(customer->customer.getName())
				.sorted()
		//String은 Comparator가 있지만 TravelCustomer는 없기때문에 객체를 정렬시키면 Error가 발생한다.
		//객체를 비교할때는 구현해야함.
				.reduce("",(a,b)->a+b+"\n");
		System.out.println(adultList);
	}
}
