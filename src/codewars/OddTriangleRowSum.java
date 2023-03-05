package codewars;
/*Given the triangle of consecutive odd numbers:
 *       		   1
 *        		3     5
 *     	   	 7     9    11
 *  	  13    15    17    19
 *     21    23    25    27    29
...
 * Calculate the sum of the numbers in the nth row of this triangle (starting at index 
 * 1) e.g.: (Input --> Output)
 * 1 -->  1
 * 2 --> 3 + 5 = 8
*/
public class OddTriangleRowSum {
	public static void main(String[] args) {
		SolutionTest.assertEquals(1, rowSumOddNumbers(1));
		SolutionTest.assertEquals(74088, rowSumOddNumbers(42));
	}
	public static int rowSumOddNumbers(int n) {
		/*규칙찾기 문제
			1	1
				2^3 
			2	8
				3^3
			3	27
				4^3
			4	64
				5^3
			5	125
		 */
		if(n<=0)return 0;
		else return (int)(Math.pow(n, 3));
	}
//다른사람 풀이(return (int)(Math.pow(n, 3))==return n*n*n)
	public static int rowSumOddNumbers1(int n) {
		int start = n*n-(n-1);
		int sum = 0;
		for (int i = start; i < start + n * 2; i = i + 2) {
		    sum = sum + i;
		}
		return sum;
	}
}
