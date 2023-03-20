package fastcampus.javaSpring.chapter06.ch11LoggerClass;

public class LoggerTest {
	public static void main(String[] args) {
		//instance load
		MyLogger logger = MyLogger.getLogger();
		//log
		logger.log("log test");
	}
}
