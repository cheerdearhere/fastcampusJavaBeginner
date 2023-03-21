package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamArrayTest {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("inputAlp.txt")){
			byte[] byteArr = new byte[10];
			int i;
			while((i=fis.read(byteArr))!=-1) {
				for(byte b:byteArr)
					System.out.print((char)b+":"+b+"/");
				System.out.println();
				//buffer에 남은 데이터가 남음
				//Enhanced for문으로 하기보다 데이터의 개수만큼만 사용할때는 일반 for문이 좋다.
				for(int j=0;j<i;j++) 
					System.out.print((char)byteArr[j]);
				System.out.println(": "+i+"byte 읽음");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
