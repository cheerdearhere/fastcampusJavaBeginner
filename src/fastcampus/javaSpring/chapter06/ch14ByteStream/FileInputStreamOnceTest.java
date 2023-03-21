package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamOnceTest {

	public static void main(String[] args) {
		//Closeable interface 사용. while을 사용해 한번에 처리
		try(FileInputStream fis = new FileInputStream("input.txt")){
			int i;
			//더 읽을 data가 없으면 -1 return
			while((i=fis.read())!=-1) {
				System.out.print((char)i+":"+i+"/");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
