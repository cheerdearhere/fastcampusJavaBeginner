package fastcampus.javaSpring.spring.ch01IoC_DI;

public class Encoder {
	//내부에 인터페이스 객체를 얻고 생성자에서 인스턴스를 관리
	private IEncoder iEncoder;
	
	public Encoder(IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	
	public String encode(String message) {
		return iEncoder.encode(message);
		//return Base64.getEncoder().encodeToString(message.getBytes());
	}
}
