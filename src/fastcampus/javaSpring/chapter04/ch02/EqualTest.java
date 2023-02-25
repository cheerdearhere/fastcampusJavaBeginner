package fastcampus.javaSpring.chapter04.ch02;

public class EqualTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student std1 = new Student(100,"Lee");
		Student std2 = new Student(100,"Lee");
		Student std3 = std1;
		/* override 이전: equals() method == '=='
		System.out.println(std1==std2);//false
		System.out.println(std1.equals(std2));//false
		System.out.println(std1==std3);//true
		System.out.println(std1.equals(std3));//true
		*/
		System.out.println("##overridden equals(): using studentNum as PK.");
		System.out.println(std1==std2);//false
		System.out.println(std1.equals(std2));//true
		System.out.println(std1==std3);//true
		System.out.println(std1.equals(std3));//true
		
		/*기본적인 사용
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1.equals(str2));//true
		System.out.println(str1.hashCode());//96354
		System.out.println(str2.hashCode());//96354
		Integer i= 100;
		System.out.println(i.hashCode());//100(기본형은 바로 출력)
		
		System.out.println("before overriding hashCode ");
		System.out.println(std1==std2);//false
		System.out.println(std1.equals(std2));//true
		System.out.println(std1.hashCode());//225534817
		System.out.println(std2.hashCode());//1878246837
		*/
		System.out.println("##overridden hashCode()");
		System.out.println(std1.hashCode());//100
		System.out.println(std2.hashCode());//100
		
		System.out.println("##memory address");
		System.out.println(System.identityHashCode(std1));//225534817
		System.out.println(System.identityHashCode(std2));//1878246837
		
		Student copyStudent = (Student)std1.clone();
		System.out.println(copyStudent);//100,Lee
		std1.setStudentName("Kim");//clone() 대상의 인스턴스 변경
		System.out.println(copyStudent);//100,Lee: 이전에 복사한 것은 그대로
		Student copyStudent2 = (Student)std1.clone();//다시 복사
		System.out.println(copyStudent2);//100,Kim: 다시복사한 것은 복사한 내용으로
	}
}
