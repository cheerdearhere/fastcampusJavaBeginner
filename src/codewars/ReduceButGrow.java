package codewars;

import java.util.stream.IntStream;
/*Given a non-empty array of integers, 
 * return the result of multiplying the values together in order. 
 * Example: [1, 2, 3, 4] => 1 * 2 * 3 * 4 = 24
*/
public class ReduceButGrow {

	public static void main(String[] args) {
		SolutionTest.assertEquals(6, grow(new int[]{1,2,3}));
		SolutionTest.assertEquals(16, grow(new int[]{4,1,1,1,4}));
		SolutionTest.assertEquals(64, grow(new int[]{2,2,2,2,2,2}));
	}
	public static int grow(int[] x) {
		int res=1;
		if(x==null||x.length==0)return 0;
		for(int i:x) {
			res*=i;
		}
		return res;
	}
	//다른 사람 풀이
	public static int grow1(int[] x){
		//stream중 IntStream으로 변환
		return IntStream.of(x)
				//1부터 순차적으로 곱함.
				.reduce(1, (a, b) -> a * b);
	}
	//나머지 풀이는 거의 비슷
}
