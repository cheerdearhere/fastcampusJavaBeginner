package fastcampus.javaSpring.chapter06.ch08Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {
	//사용할 method에서 처리미루기
	public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		Class c;
			c=Class.forName(className);
		return c;
	}
	public static void main(String[] args) {
		ThrowsException test = new ThrowsException();
		try {
			test.loadClass("a.txt", "abc");
		} 
		//두개의 Exception을 처리할 경우 
		catch (ClassNotFoundException | FileNotFoundException e) {
			System.out.println(e);
		}//method
		//예상할 수 없는 Exception을 모두 처리하고 싶을 경우 최상위 Exception처리
		//이를 default 처리한다고 함. 
		//단, default를 제일 위로 올리면 그보다 작은 나머지 예외처리는 쓸데없는 코드가 된다. 
		catch(Exception e) {
			System.out.println("default exception: "+e);
		}
		System.out.println("비정상 종료가 아님.");
	}

}
