package fastcampus.javaSpring.chapter04.ch03StringBuilderTextBlock;

public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3="abc";
		String str4="abc";
		System.out.println(str1==str2);//false
		//생성자 new를 사용한 경우 값은 같아도 다른 힙 메모리에 생성된 instance임. 
		System.out.println(str3==str4);//true
		//생성자 없이 입력하면 상수풀의 주소값을 참조해 같은 instance를 가리킴
		System.out.println(str1==str3);//false
		//그렇기에 생성자로 만든 문자열과 상수풀을 지칭한 문자열은 다른 주소를 가짐.
	}
}
