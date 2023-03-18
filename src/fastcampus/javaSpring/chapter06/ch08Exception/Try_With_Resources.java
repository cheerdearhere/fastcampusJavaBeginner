package fastcampus.javaSpring.chapter06.ch08Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Try_With_Resources {

	public static void main(String[] args) {
	//try문에 인자로 예외 발생 가능한 객체의 생성식을 넣으면 컴파일러에서 그에대한 예외 구문을 제공함
		try(FileInputStream fis = new FileInputStream("a.txt")){
			System.out.println("read");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("try 이후");
	}
}
