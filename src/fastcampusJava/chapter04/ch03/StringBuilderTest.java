package fastcampusJava.chapter04.ch03;

public class StringBuilderTest {

	public static void main(String[] args) {
		String java = new String("java");
		String android = new String("android");
		
		StringBuilder builder = new StringBuilder(java);
		System.out.println(System.identityHashCode(builder));//1304836502
		builder.append(android);
		System.out.println(System.identityHashCode(builder));//1304836502
		//String은 값을 변경하면 메모리 주소가 달라지는 반면 buffer나 builder는 유지된다.
		String test = builder.toString();
		System.out.println(test);

	}
}
