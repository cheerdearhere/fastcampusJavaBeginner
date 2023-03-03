package fastcampus.javaSpring.chapter04.ch04ClassReplectionProgramming;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringTest {
	public static void main(String[] args) throws ClassNotFoundException {
		//호출한 class가 없는 경우 예외처리
		Class c = Class.forName("java.lang.String");
		
		//String의 constructor
		Constructor[] cons = c.getConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
		//method 리스트
		Method[] ms = c.getMethods();
		for(Method m:ms) {
			System.out.println(m);
		}
		/*
		 * reflection programming
		 * local에 없고 remote에 있는 
		 * 라이브러리를 사용하는 경우 Class.forName()을 사용한다.
		 */
	}
}
