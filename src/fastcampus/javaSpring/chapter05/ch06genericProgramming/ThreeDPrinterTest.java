package fastcampus.javaSpring.chapter05.ch06genericProgramming;

public class ThreeDPrinterTest {

	public static void main(String[] args) {
		//generic을 사용하기 전에는 Object로 만들었다.
		Powder powder = new Powder();
		ThreeDPrinter3 printer = new ThreeDPrinter3();
		//setter method의 사용에는 큰 문제가 없지만. 
		printer.setMaterial(powder);
		
		//getter method를 사용할때는 매번 형변환이 필요해 번거롭다. 
		Powder p = (Powder) printer.getMaterial();
	}

}
