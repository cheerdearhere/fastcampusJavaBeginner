package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamSingly {
	public static void main(String[] args) {
		try(FileOutputStream fos = new FileOutputStream("output.txt")){
			//ASCII 기준 문자로 변환되어 입력
			fos.write(65);//A
			fos.write(66);//B
			fos.write(67);//C
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
