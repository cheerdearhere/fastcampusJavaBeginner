package fastcampus.javaSpring.chapter06.ch04OOPvsLambda;

public class StringConcatTest {
	
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "world";
		
		//Object Oriented Programming
		StringConcat strImpl = new StringConcatImpl();
		strImpl.makeString(s1,s2);
		
		//Lambda expression
		StringConcat strCon = (str1,str2)->{
			System.out.println(str1+", "+str2);
		};
		strCon.makeString(s1, s2);
		
		//람다식 표기로 바꾸기 전 익명내부클래스
		StringConcat strAnony = new StringConcat() {
			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1+", "+s2);
			}
		};
		strAnony.makeString(s1, s2);
	}
}
