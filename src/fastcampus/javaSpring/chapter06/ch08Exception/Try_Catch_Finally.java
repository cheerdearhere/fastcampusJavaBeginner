package fastcampus.javaSpring.chapter06.ch08Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Try_Catch_Finally {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("a.text");
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error: 프로젝트 폴더 내에 파일이 없습니다.");
			e.printStackTrace();
		}
		finally {
			if(fis!=null) {
				try {
					fis.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("finally is run");
		}
		System.out.println("main method is run");
	}
}
