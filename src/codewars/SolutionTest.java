package codewars;

public class SolutionTest {
	public static void assertEquals(String res, String test) {
		if(res.equals(test)) System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(int res, int test) {
		if(res==test)System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(boolean res, boolean test) {
		if(res==test) System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertNull(String messege,Object re) {
		if(re==null)System.out.println("return null ok");
		else System.out.println(messege);
	}
}
