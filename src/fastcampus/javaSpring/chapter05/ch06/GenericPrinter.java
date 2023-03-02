package fastcampus.javaSpring.chapter05.ch06;
//generic type을 적용하기 1.class명 옆에 type을 표시한다.
public class GenericPrinter<T> {
	private T meterial;//2. 사용할 인스턴스의 자료형도 T사용

	//3.getter,setter method도 T로 표시.
	//4. 사용할때 type을 지정해 사용하면 컴파일러가 검증.
	public T getMeterial() {
		return meterial;
	}
	public void setMeterial(T meterial) {
		this.meterial = meterial;
	}
	//toString method
	public String toString() {
		return meterial.toString();
	}
}
