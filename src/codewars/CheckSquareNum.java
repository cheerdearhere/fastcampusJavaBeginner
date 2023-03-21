package codewars;
/*
Given an integral number, determine if it's a square number:

In mathematics, a square number or perfect square is an integer that is the square of an integer; 
in other words, it is the product of some integer with itself.
The tests will always use some integral number, 
so don't worry about that in dynamic typed languages.

Examples
-1  =>  false
 0  =>  true
 3  =>  false
 4  =>  true
25  =>  true
26  =>  false
*/
public class CheckSquareNum {

	public static void main(String[] args) {
		SolutionTest.assertEquals(false,isSquare(-1));
		SolutionTest.assertEquals(true,isSquare(0));
		SolutionTest.assertEquals(false,isSquare(3));
		SolutionTest.assertEquals(true,isSquare(4));
		SolutionTest.assertEquals(true,isSquare(25));
		SolutionTest.assertEquals(false,isSquare(26));
	}
	private static boolean isSquare(int n) {
		return Math.sqrt(n)%1==0.0 ? true: false;
	}
//다른사람 풀이
	//제곱근을 구해 다시 원래 값인지 확인(근사치는 원형을 낼수 없음)
	public static boolean isSquare1(int n) {
        long s = Math.round(Math.sqrt(n));
        return s * s == n;
    }
	//굳이 ? :를 쓰지 않아도 그 자체가 조건문임. 아하!
	public static boolean isSquare2(int n) {        
    	return Math.sqrt(n)%1 == 0;
    }
}
