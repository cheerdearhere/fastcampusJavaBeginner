package fastcampus.javaSpring.chapter05.ch08;

public class AreaCalcTest {
	public static void main(String[] args) {
		//실제 사용 예시
		//두 점을 선언
		Point<Integer,Double> p1 = new Point<Integer,Double>(0,0.0);
		Point<Integer,Double> p2 = new Point<>(10, 10.0);//앞에서 type을 지정했다면 뒤에서는 안적어도 됨.
		//static method를 사용, <T, E>로 표시했지만 실제 사용에서는 해당 type을 적음
		double size = GenericMethod.<Integer,Double>makeRectangle(p1, p2);
		System.out.println("두 점 으로 만들어진 사각형의 넓이는 "+ size+"입니다.");
	}
}
