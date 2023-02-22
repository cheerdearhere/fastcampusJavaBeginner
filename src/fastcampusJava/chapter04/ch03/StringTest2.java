package fastcampusJava.chapter04.ch03;

public class StringTest2 {

	public static void main(String[] args) {
		//새 String instance 생성
		String java = new String("java");
		String android = new String("android");
		//String java의 해시코드 
		System.out.println(System.identityHashCode(java));//1304836502
		//두 문자열을 연결
		java=java.concat(android);
		System.out.println(java);//javaandroid
		//기존 주소의 데이터가 변경되는 것이 아닌 새로운 주소
		System.out.println(System.identityHashCode(java));//225534817
		/*
		 * 기존 메모리의 데이터가 사라지지 않고 남아있어(garbage data) 메모리 낭비가 심하다.
		 * 이러한 낭비를 줄이기 위해 StringBuffer, StringBuilder가 사용되고
		 * 최근에는 text block을 이용한다.
		*/
	}

}
