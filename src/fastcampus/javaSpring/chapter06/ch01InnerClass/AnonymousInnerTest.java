package fastcampus.javaSpring.chapter06.ch01InnerClass;
class Outer2{
	int outNum = 100;
	static int sNum = 200;
	//A - method로 호출하기
	Runnable getRunnable(int i) {
		int num = 10;
		//1. 내부 클래스의 이름을 없애고 리턴을 위로 올린다.
		//class MyRunnable implements Runnable{
		return new Runnable() {
			int localNum = 1000;
			@Override
			public void run() {
				System.out.println("i = "+ i);
				System.out.println("num = "+ num);
				System.out.println("localNum = "+ localNum);
				//역시 method의 변수를 변경할 수 없다.
				System.out.println("outNum = "+ outNum);
				System.out.println("Outer.sNum = "+ Outer2.sNum);
			}
		};//2. 이 implementation의 끝이 여기임을 표시
//		return new MyRunnable();
	}

//B - 변수로 호출하기
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			System.out.println("Runnable class");
		}
	};
}
public class AnonymousInnerTest {
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		//method로 호출
		Runnable runner = out.getRunnable(300);
		runner.run();
		
		//변수로 호출
		out.runnable.run();
	}
}
/* 익명 내부 클래스로 만들기 전
 class Outer2{
	//변수의 선언은 생성자에서 하는 것이 좋으나 예제를 위해 직접 선언
	int outNum = 100;
	static int sNum = 200;
	//Runnable: class를 Thread화 할때 사용하는 인터페이스
	Runnable getRunnable(int i) {
		int num = 10;
		//내부 class에서 구현
		class MyRunnable implements Runnable{
			int localNum = 1000;
			@Override
			public void run() {
			//stack memory에 생성해 사용은 가능
				//parameter
				System.out.println("i = "+ i);
				//method local variable
				System.out.println("num = "+ num);
				//inner class local variable
				System.out.println("localNum = "+ localNum);
			//다만 변경하려 하면 이미 method의 생성주기가 종료되어 
			//method의 인스턴스가 final로 고정된다. stack메모리가 아닌 final 영역에 남는 것이다.
			//이는 method의 재호출을 위해 컴파일러에서 변경된다.
//				i = 10;
//				num=20;
				
				System.out.println("outNum = "+ outNum);
				System.out.println("Outer.sNum = "+ Outer2.sNum);
			}
			
		}
		return new MyRunnable();
	}
}
public class AnonymousInnerTest {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		Runnable runner = out.getRunnable(300);
		//외부에서도 역시 사용이 가능하다.
		runner.run();
	}

}

 */
