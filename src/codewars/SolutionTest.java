package codewars;

public class SolutionTest {
	public static void assertEquals(String res, String test) {
		if(res.equals(test)) System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(boolean res, boolean test) {
		if(res==test) System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(int res, int test) {
		if(res==test)System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(double res, double test) {
		if(res==test)System.out.println("return true");
		else System.out.println("return false");
	}
	public static void assertEquals(int[] res, int[] test) {
		boolean check;
		for(int i=0;i<test.length;i++) {
			check=res[i]==test[i];
			if(check) 
				System.out.println(i+" true");
			else 
				System.out.println(i+" false: "+res[i]+"/"+test[i]);
		}
		System.out.println("-----");
	}
//specially
	public static void assertNull(String messege,Object re) {
		if(re==null)System.out.println("return null ok");
		else System.out.println(messege);
	}
}
