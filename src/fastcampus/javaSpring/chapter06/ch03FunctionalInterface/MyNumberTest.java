package fastcampus.javaSpring.chapter06.ch03FunctionalInterface;

public class MyNumberTest {
	public static void main(String[] args) {
		//functional interface, 삼항연산자로 최대한 간단히 구현
		MyNumber myNumber = (x,y)->(x>y)?x:y;
		System.out.println(myNumber.getMax(10, 20));
	}
}
