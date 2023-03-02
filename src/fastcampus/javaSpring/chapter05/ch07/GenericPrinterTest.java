package fastcampus.javaSpring.chapter05.ch07;

public class GenericPrinterTest {

	public static void main(String[] args) {
		
		Powder powder = new Powder();
		//printer 객체를 만들때 generic을 표시
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
		powderPrinter.setMaterial(powder);
		//따로 형변환을 하지 않아도 지정된 자료형으로 반환
		Powder po = powderPrinter.getMaterial();
		
		Plastic plastic = new Plastic();
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		plasticPrinter.setMaterial(plastic);
		Plastic pl = plasticPrinter.getMaterial();

		System.out.println(powderPrinter.toString());
		System.out.println(plasticPrinter.toString());

		//단, Type parameter를 지정하지 않으면 최상위 super인 Object를 반환하므로 다시 형변환해야한다. 
		GenericPrinter noneTypePrinter = new GenericPrinter<>();
		noneTypePrinter.setMaterial(plastic);
		pl=(Plastic)noneTypePrinter.getMaterial();
		
		//제한을 두지 않으면 막아야할 data type이 들어온다. 필요에 따라 사용
		//GenericPrinter<Water> printer = new GenericPrinter<Water>();
	}

}
