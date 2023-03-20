package fastcampus.javaSpring.chapter06.ch10CustomException;

public class PasswordException  extends Exception{
	//IllegalArgumentException을 사용하나 try-catch를 강제하기 위해 Exception을 사용
	public PasswordException(String message) {
		super(message);
	}
}
