package codewars;

import java.util.Arrays;
import java.util.stream.Stream;

/*
As the name may already reveal, 
it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers of the sequence to generate the next. 

So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), 
we have this sequence: [1, 1 ,1, 3, 5, 9, 17, 31, ...]

But what if we started with [0, 0, 1] as a signature? 
As starting with [0, 1] instead of [1, 1] basically shifts the common Fibonacci sequence by once place, you may be tempted to think that we would get the same sequence shifted by 2 places, 
but that is not the case and we would get: [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]

Well, you may have guessed it by now, but to be clear: you need to create a fibonacci function that given a signature array/list, 
returns the first n elements - signature included of the so seeded sequence.

Signature will always contain 3 numbers; 
n will always be a non-negative number; 
if n == 0, then return an empty array (except in C return NULL) 
and be ready for anything else which is not clearly specified ;)
*/
public class TribonacciSequence {
	public static void main(String[] args) {
		SolutionTest.assertEquals(new double []{1,1,1,3,5,9,17,31,57,105}, tribonacci(new double []{1,1,1},10));
		SolutionTest.assertEquals(new double []{0,0,1,1,2,4,7,13,24,44}, tribonacci(new double []{0,0,1},10));
		SolutionTest.assertEquals(new double []{0,1,1,2,4,7,13,24,44,81}, tribonacci(new double []{0,1,1},10));
		SolutionTest.assertEquals(new double [0], tribonacci(new double []{1,1,1},0));
		SolutionTest.assertEquals(new double [0], tribonacci(new double []{1,1},0));
	}
	private static double[] tribonacci(double[] s, int n) {
		double[] result=new double[n];
		double sum = 0;
		
		if(s==null||s.length!=3||n<=0) 
			return result;
		
		for(int i=0 ; i<n ; i++) {
			if(i<3) {
				result[i]=s[i];//index 0, 1, 2
			}
			else {//index 3~
				int t1=i-3;
				int t2=i-2;
				int t3=i-1;
				sum=result[t1]+result[t2]+result[t3];
				result[i]=sum;
			}
		}
		return result;
	}
//다른사람 풀이
	//Arrays.copyOf(double[] original, int newLength)
	public double[] tribonacci1(double[] s, int n) {
	    double[] tritab=Arrays.copyOf(s, n);
	    for(int i=3;i<n;i++){
	    	tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
	    }
	    return tritab;
	  }
	//삼항연산자, variable name의 일관성
	public double[] tribonacci2(double[] s, int n) {
	      double[] r = new double[n];
	      for(int i = 0; i < n; i++){
	        r[i] = (i<3)?s[i]:r[i-3]+r[i-2]+r[i-1];
	      }
	      return r;
	  }
	//Stream.iterate()
	   public double[] tribonacci3(double[] start, int n) {
	        return Stream.iterate(start, tuple -> applySequenceRule(tuple))
	            .mapToDouble(tuple -> tuple[0])
	            .limit(n)//최대 갯수 제한은 있는데 
	            .toArray();//3개 미만에 대한 리턴은 따로 처리안하고 빈 배열을 반환
	    }
	    private double[] applySequenceRule(double[] tuple) {
	        return new double[]{tuple[1], tuple[2], tuple[0]+tuple[1]+tuple[2]};
	    }
}
