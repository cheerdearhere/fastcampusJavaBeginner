package fastcampus.javaSpring.chapter06.ch08Exception;
public class AutoCloseableObjTest {
	public static void main(String[] args) {
		AutoCloseableObj obj = new AutoCloseableObj();
		//try문 진행
		try(obj){
			//empty
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
		//catch문 진행
		try(obj){
			throw new Exception();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
