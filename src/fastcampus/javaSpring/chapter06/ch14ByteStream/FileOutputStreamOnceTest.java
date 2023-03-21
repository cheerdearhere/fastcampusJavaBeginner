package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamOnceTest {

	public static void main(String[] args) throws IOException {//입출력은 예외처리 필요
		//java.io.FileOutputStream.FileOutputStream(String name, Boolean append) throws FileNotFoundException
		//기존파일에 덮어쓰지 않고 이어쓰는 경우:true, default는 Override(false)
		FileOutputStream fos = new FileOutputStream("output2.txt");//
		try(fos){//java9부터 사용 가능
			//배열에 ASCII 알파벳 code 입력
			byte[] aALP = new byte[26];
			byte init = 65;
			for(int i=0 ; i<aALP.length ; i++) {
				aALP[i]=init;
				init++;
			}
		
			//입력된 자료 배열을 한꺼번에 출력
			fos.write(aALP);
			//.write(byte[] array, int off, int len): 배열중 일부
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
