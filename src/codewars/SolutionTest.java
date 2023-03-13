package codewars;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		if(res.length!=test.length) {
			System.out.println("size dosen't equals.");
			return;
		}
		for(int i=0;i<test.length;i++) {
			check=res[i]==test[i];
			if(check) 
				System.out.println(i+" true");
			else 
				System.out.println(i+" false: "+res[i]+"/"+test[i]);
		}
		System.out.println("-----");
	}
	public static void assertIterableEquals(List<String> l1,List<String> l2) {
		if(l1==null) {
			System.out.println("list is null");
			return;
		}
		if(l1.size()!=l2.size()) {
			System.out.println("list size isn't same.");
			return;
		}
		for(int i = 0;i<l1.size();i++) {
			String s1 = l1.get(i);
			if(s1.equals(l2.get(i))) 
				System.out.println(i+" true");
			else 
				System.out.println(i+" false");
		}
	}
//specially
	public static void assertNull(String messege,Object re) {
		if(re==null)System.out.println("return null ok");
		else System.out.println(messege);
	}
}
