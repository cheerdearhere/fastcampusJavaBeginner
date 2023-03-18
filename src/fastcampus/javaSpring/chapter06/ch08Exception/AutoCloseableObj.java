package fastcampus.javaSpring.chapter06.ch08Exception;

public class AutoCloseableObj implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("close......ing");
	}

}
