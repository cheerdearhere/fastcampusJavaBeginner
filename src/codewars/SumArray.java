package codewars;

import java.util.Arrays;

/*Write a function that takes an array of numbers and returns the sum of the numbers. 
 * The numbers can be negative or non-integer. 
 * If the array does not contain any numbers then you should return 0.
 * 
 * You can assume that you are only given numbers.
 * You cannot assume the size of the array.
 * You can assume that you do get an array and if the array is empty, return 0
 * 
 * Examples: 
 * 	Input: [1, 5.2, 4, 0, -1]
 * 	Output: 9.2
 * 	Input: []
 * 	Output: 0
 * 	Input: [-2.398]
 * 	Output: -2.398
 */
public class SumArray {

	public static void main(String[] args) {
		SolutionTest.assertEquals(0.0,sum(new double[] { }));
		SolutionTest.assertEquals(-2.398,sum(new double[] {-2.398}));
		SolutionTest.assertEquals(6,sum(new double[] {1, 2, 3}));
		SolutionTest.assertEquals(6.6,sum(new double[] {1.1, 2.2, 3.3}));
		SolutionTest.assertEquals(9.2,sum(new double[] {1, 5.2, 4, 0, -1}));
		SolutionTest.assertEquals(320,sum(new double[] {30, 89, 100, 101}));

	}
	public static double sum(double[] numbers) {
		if(numbers==null||numbers.length==0)return 0.0;
		double sum = 0.0;
		for(double d:numbers)
			sum+=d;
		return sum;
	}
//다른 사람 풀이
	//Arrays.stream.sum();
	public static double sum1(double[] numbers) {
		return Arrays.stream(numbers).sum();
	}
	
}
