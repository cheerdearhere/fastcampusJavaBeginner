package fastcampus.javaSpring.chapter06.ch14ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamOffsetTest {

	public static void main(String[] args) {
		//java.io.FileOutputStream.FileOutputStream(String name, boolean append) throws FileNotFoundException
		try(FileOutputStream fos = new FileOutputStream("output3.txt", true)){
			byte[] bs = new byte[26];
			byte init = 65;
			for(int i = 0;i<bs.length;i++) {
				bs[i]=init;
				init++;
			}
			fos.write(bs, 2, 10);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

}
