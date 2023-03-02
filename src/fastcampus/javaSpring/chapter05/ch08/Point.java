package fastcampus.javaSpring.chapter05.ch08;

public class Point<T,E> {
	//어떤 타입으로든 소스를 받을 수 있기때문에 Type parameter를 사용
	T x;
	E y;
	
	//생성자에서 data를 입력받음. 
	Point(T x, E y){//접근제어자를 따로 표시하지 않으면 default
		this.x = x;
		this.y = y;
	}
	
	public T getX() {
		return x;
	}
	public E getY() {
		return y;
	}
}
