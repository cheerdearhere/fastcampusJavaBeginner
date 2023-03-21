package fastcampus.javaSpring.chapter06.ch13StandardStream;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {

	public static void main(String[] args) {
		//셋 중 하나만 사용
		
		System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요.");
		int i;
		//여러개를 써도 제일 처음 문자 하나만 처
		try {
			//int java.io.InputStream.read() throws IOException: 입력된 문자의 int를 반환
			i=System.in.read();
			System.out.println(i);//int
			System.out.println((char)i);//형변환
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("알파벳 여러개를 쓰고 [Enter]를 누르세요.");
		int j;
		try {
			//입력값이 줄을 바꾸기 전까지
			while((j=System.in.read())!='\n') {
				System.out.print(j+" : "+(char)j+", ");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("한글을 쓰고 [Enter]를 누르세요.");
		int k;
		try {
			/*java.io.InputStreamReader.InputStreamReader(InputStream in)
			byte를 문자로 바꿔주는 class. InputStream은 byte단위로 묶는 class들의 최상위 class
			*/
			//입력할 inputStream 지정
			InputStreamReader irs = new InputStreamReader(System.in);
			//InputStreamReader(보조스트림)으로 키보드 입력을 받음
			while((k=irs.read())!='\n') {
				System.out.println((char)k+":"+k);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
