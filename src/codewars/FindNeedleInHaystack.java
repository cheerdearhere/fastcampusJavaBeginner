package codewars;

import java.util.Arrays;

/*
Write a function findNeedle() that takes an array full of junk 
but containing one "needle"
After your function finds the needle it should return a message (as a string) 
that says:
	"found the needle at position " plus the index it found the needle, so:
	
	Example(Input --> Output)	
		["hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"] 
		--> "found the needle at position 5" 
*/
public class FindNeedleInHaystack {
	public static void main(String[] args) {
		Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
		Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
		Object[] haystack3 = {1,2,3,4,5,6,7,8,8,7,5,4,3,4,5,6,67,5,5,3,3,4,2,34,234,23,4,234,324,324,"needle",1,2,3,4,5,5,6,5,4,32,3,45,54};
		
		SolutionTest.assertEquals("found the needle at position 3", findNeedle(haystack1));
		SolutionTest.assertEquals("found the needle at position 5", findNeedle(haystack2));
		SolutionTest.assertEquals("found the needle at position 30", findNeedle(haystack3));
	}
	
	private static String findNeedle(Object[] haystack) {
		int index=Arrays.asList(haystack).indexOf("needle");
		return "found the needle at position "+index;
	}
//다른 사람 풀이
	//format을 사용해 직접 Arrays class사용
	public static String findNeedle1(Object[] haystack) {
		return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
	}
	//for문의 index
	public static String findNeedle2(Object[] haystack) {
		for (int i = 0; i < haystack.length; i++) 
			if (haystack[i] == "needle") 
				return "found the needle at position " + i;
		return "needle be lost, yo";
	}
	//나머진 while문 정도의 차이뿐 거의 비슷
}
