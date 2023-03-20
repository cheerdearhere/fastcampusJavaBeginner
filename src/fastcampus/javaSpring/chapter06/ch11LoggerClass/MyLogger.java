package fastcampus.javaSpring.chapter06.ch11LoggerClass;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	//java.util.logging.Logger.getLogger(String name): 
	//name(식별자)을 통해 getLogger를 하면 항상 같은 인스턴스가 호출됨
	Logger logger = Logger.getLogger("mylogger");
	//싱글톤패턴과 유사하나 식별자가 여러개임
	private static MyLogger instance =  new MyLogger();
	
	//log처리를 위한 3개 파일(level별 파일)
	public static final String ERRORLOG = "log.txt";
	public static final String WARNINGLOG = "warning.txt";
	public static final String FINELOG = "fine.txt";
	
	//FileHandler
	private FileHandler logFile = null;
	private FileHandler warningFile = null;
	private FileHandler fineFile = null;
	
	private MyLogger() {
		try {
			//FileHandler(String pattern, boolean append) throws IOException, SecurityException
			//parttern: 파일명, append: override가 아닌 append(이어쓰기)
			logFile = new FileHandler(ERRORLOG, true);
			warningFile = new FileHandler(WARNINGLOG, true);
			fineFile = new FileHandler(FINELOG, true);
		} catch(SecurityException | IOException e) {
			e.printStackTrace();
		} 
		
		//log를 표시할 format은 간단한 SimpleFormatter
		logFile.setFormatter(new SimpleFormatter());
		warningFile.setFormatter(new SimpleFormatter());
		fineFile.setFormatter(new SimpleFormatter());
		
		//log level 세팅
		//default(ALL은 finest부터 모든 수준의 로그를 찍는다.)
		logger.setLevel(Level.ALL);
		//지정한 수준 이상
		fineFile.setLevel(Level.FINE);
		warningFile.setLevel(Level.WARNING);
		
		//handler 처리
		logger.addHandler(logFile);
		logger.addHandler(warningFile);
		logger.addHandler(fineFile);
	}
	
	//싱글톤 방식으로 instance 제외
	public static MyLogger getLogger() {
		return instance;
	}
	
	//지정 수준 이상에 메세지 남김
	//서버를 열때는 모든 로그를 찍다가 어느정도 안정이 되면 로그를 분류함.
	//보통은 만들어진 framework를 사용
	public void log(String msg) {
		logger.finest(msg);
		logger.finer(msg);
		logger.fine(msg);
		logger.config(msg);
		logger.info(msg);
		logger.warning(msg);
		logger.severe(msg);
	}
	public void fine(String msg) {
		logger.fine(msg);
	}
	public void warning(String msg) {
		logger.warning(msg);
	}
}
