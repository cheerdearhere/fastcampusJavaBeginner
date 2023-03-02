package fastcampus.javaSpring.chapter05.ch08;

public class GenericMethod {
	//main에서 바로 사용하기 위해 static method로 선언
	//두 점의 x,y좌표를 받아 계산
	public static <T,E> double makeRectangle(Point<T,E> p1,Point<T,E> p2) {
		//사용할 매개변수의 타입을 표시
		double left = ((Number)p1.getX()).doubleValue();//double로 변경
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right-left;
		double height = bottom-top;
		
		return width*height;
	}
}
