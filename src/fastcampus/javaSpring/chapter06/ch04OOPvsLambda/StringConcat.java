package fastcampus.javaSpring.chapter06.ch04OOPvsLambda;
@FunctionalInterface
public interface StringConcat {
	//interface의 abstract method를 객체지향과 람다식 두가지 방법으로 구현해보자
	public void makeString(String s1, String s2);
}
