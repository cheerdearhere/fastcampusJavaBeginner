package fastcampus.javaSpring.chapter06.ch10CustomException;

public class PasswordTest {
	private String password;
	public String getPassword() {
		return password;
	}
	//method에서 예외처리해도 됨
	public void setPassword(String password) throws PasswordException {
		if(password==null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.");
		}
		else if(password.length()<5) {
			throw new PasswordException("비밀번호는 5글자 이상입니다.");
		}
		else if(password.matches("[a-zA-Z]+")) {
			throw new PasswordException("숫자나 특수문자를 포함해야합니다.");
		}
		this.password = password;
	}
	
	public static void main(String[] args) {
		PasswordTest test = new PasswordTest();
		String password=null;
		try {
			test.setPassword(password);
			System.out.println("오류없음1");
		} catch (PasswordException e) {
			e.printStackTrace();
		}
		password="abcd";
		try {
			test.setPassword(password);
			System.out.println("오류없음2");
		} catch (PasswordException e) {
			e.printStackTrace();
		}
		password="abcde";
		try {
			test.setPassword(password);
			System.out.println("오류없음3");
		} catch (PasswordException e) {
			e.printStackTrace();
		}
		password="*abc1";
		try {
			test.setPassword(password);
			System.out.println("오류없음4");
		} catch (PasswordException e) {
			e.printStackTrace();
		}
	}
}
