package fastcampus.javaSpring.chapter06.ch11LoggerClass;

public class StudentTest {
	public static void main(String[] args) {
		MyLogger myLogger = MyLogger.getLogger();
		
		String name=null;
		try {
			Student student = new Student(name);
		}catch(StudentNameFormatException e) {
			//오류관련 정보를 로그에 기록
			myLogger.warning(e.getMessage());
		}
		//너무 긴 이름
		try {
			Student student = new Student("Edward Jone Kim Test");
		}catch(StudentNameFormatException e) {
			myLogger.warning(e.getMessage());
		}
		//정상실행
		try {
			Student student = new Student("Kim Yoo Sin");
			//정상 처리 후 get method
			String myName = student.getStudentName();
		}catch(StudentNameFormatException e) {
			myLogger.warning(e.getMessage());
		}
	}
}
