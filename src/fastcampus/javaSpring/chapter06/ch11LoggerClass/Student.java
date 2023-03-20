package fastcampus.javaSpring.chapter06.ch11LoggerClass;

public class Student {
	private String studentName;
	MyLogger myLogger = MyLogger.getLogger();
	//생성자에서 굳이 throws를 하지 않을때는 IllegalArgumentException을 사용
	public Student(String studentName) {
		if(studentName == null)
			throw new StudentNameFormatException("name must not be null");
		if(studentName.split(" ").length > 3)
			throw new StudentNameFormatException("name is too long to use");
		this.studentName =studentName;
	}
	public String getStudentName() {
		myLogger.fine("begin getStudentName");
		return studentName;
	}
}
