package fastcampus.javaSpring.chapter06.ch01InnerClass;

class OutClass{
	private int num=10;
	private static int sNum = 20;
	//내부 클래스를 사용하기위해 클래스 객체를 인스턴스화하여 사용하고 생성자에도 삽입한다.
	private InnerClass innerClass;
	public OutClass() {
		innerClass=new InnerClass();
	}

	class InnerClass{//class에 access를 private로 하면 외부에서 생성할수없다. 
		int iNum=100;
		//static int sInnerNum=500;
		/*내부 클래스에서 정적(static) 변수를 생성하려하면 에러가 발생한다.
		 *static 변수는 외부 클래스 생성을 시작하기 전에 스택으로 쌓이는데 
		 *내부클래스는 외부 클래스가 생성된 뒤에 쌓이기 때문이다. 
		*/
		void innerTest() {
			System.out.println("OutClass num= "+num+"(outer class instance variable)");
			System.out.println("OutClass sNum= "+sNum+"(outer class static variable)");
			System.out.println("InnerClass iNum= "+iNum+"(inner class instance variable)");
			
	//		static void sTest() {} 인스턴스 취급 받는 내부 클래스에 정적 메서드를 선언할 수 없다.
		}
	}
	//내부클래스의 method
	public void usingClass() {
		innerClass.innerTest();
	}
	static class InStaticClass{
		int isNum=110;
		static int sInNum=200;
		void innerTest() {
			//static class가 생성될때 instance 변수는 생성되지 않았기때문에 에러가 발생한다.
		//	System.out.println("OutClass num= "+num+"(outer class instance variable)");
			System.out.println("OutClass sNum= "+sNum+"(outer class static variable)");
			//정적 내부 클래스의 지역변수는 생성되어있어 사용가능
			System.out.println("InnerClass isNum= "+isNum+"(inner static class instance variable)");
			System.out.println("InnerClass sInNum= "+sInNum+"(inner static class static instance variable)");
		}
		
		static void sTest() {
			//정적 내부 클래스의 메서드에서도 마찬가지로 외부 클래스의 인스턴스 변수는 사용할 수 없다.
	//		System.out.println("OutClass num= "+num+"(outer class instance variable)");
			System.out.println("OutClass sNum= "+sNum+"(outer class static variable)");
			//정적 내부 클래스의 지역변수도 메서드가 우선생성되기때문에 사용할 수 없다.
	//		System.out.println("InnerClass isNum= "+isNum+"(inner static class instance variable)");
			System.out.println("InnerClass sInNum= "+sInNum+"(inner static class static instance variable)");

		}

	}
}
public class InnerTest {

	public static void main(String[] args) {
		//정석 사용법
		System.out.println("##정석 사용방법");
		OutClass outClass = new OutClass();
		outClass.usingClass();
		
		System.out.println("\n ##inner class를 private로 선언하지 않는 경우");
		//inner class의 접근제어를 private로 하지 않으면 client(외부)에서도 접근이 가능하다.
		OutClass.InnerClass innerClass = outClass.new InnerClass();
		innerClass.innerTest();
		//privated으로 access를 지정하면  에러
		
		System.out.println("\n ##static inner class 사용");
		OutClass.InStaticClass sInnerClass = new OutClass.InStaticClass();
		sInnerClass.innerTest();
		System.out.println("\n #static inner class - static method");
		sInnerClass.sTest();
	}

}
