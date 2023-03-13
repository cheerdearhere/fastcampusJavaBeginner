package fastcampus.javaSpring.chapter06.ch02LamdaExpression;

public class AddTest {

	public static void main(String[] args) {
		//interface의 method를 바로 구현해 사용
		Add addL = (x,y) -> {return x+y;};
		System.out.println(addL.add(2, 3));
		
		//수행문이 한줄이고 return을 생략하면 {}도 생략가능
		addL = (x,y) -> 2*x+y;
		System.out.println(addL.add(2, 3));
	
	}

}
