package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SmallestIntegerFinder {

	public static void main(String[] args) {
		int expected = 11;
		int actual = SmallestIntegerFinder.findSmallestInt(new int[]{78,56,232,12,11,43});
		SolutionTest.assertEquals(expected, actual);	
		expected = -33;
		actual = SmallestIntegerFinder.findSmallestInt(new int[]{78,56,-2,12,8,-33});
		SolutionTest.assertEquals(expected, actual);
		expected = Integer.MIN_VALUE;
		actual = SmallestIntegerFinder.findSmallestInt(new int[]{0,Integer.MIN_VALUE,Integer.MAX_VALUE});
		SolutionTest.assertEquals(expected, actual);
	}
	public static int findSmallestInt(int[] args) {
		if(args==null||args.length==0)return 0;
		int min = args[0];
		for(int i:args) {
			if(min>i)min=i;
		}
		return min;
	}
//다른사람 풀이
	//stream.IntStream
	public static int findSmallestInt1(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }
	//오름차순 정렬 후 첫 요소
	public static int findSmallestInt2(int[] args) {
        Arrays.sort(args);
        return args[0];
    }
	//삼항연산자와 Enhanced for
	public static int findSmallestInt3(int[] args) {
        int smallest = Integer.MAX_VALUE;
        for (int i : args)
          smallest = (smallest>i) ? i : smallest;
        return smallest;
    }
}
