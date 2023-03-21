package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamSinglyTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("input.txt");
			//read()의 return: the next byte of data, or -1 if the end of the file is reached.
			int i=fis.read();//세번 사용
			System.out.println((char)i+":"+i);
			i=fis.read();
			System.out.println((char)i+":"+i);
			i=fis.read();
			System.out.println((char)i+":"+i);
		} catch (IOException e) {
			//FileNotFoundException은 IOException을 상속받으므로 적지않는다.
			e.printStackTrace();
		} finally {
		//close()는 try(FileInputStream fis = new FileInputStream("a.txt")) 방식으로도 가능
		//그 전에는 finally로 InputStream을 닫음
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		//error가 발생해도 시스템이 비정상 종료되지 않음
		System.out.println("end");
	}
}
