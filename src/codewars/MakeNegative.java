package codewars;
/*In this simple assignment you are given a number and have to make it negative. 
 * But maybe the number is already negative?
 * 
 * The number can be negative already, in which case no change is required.
 * Zero (0) is not checked for any specific sign.
 *  Negative zeros make no mathematical sense.
*/

public class MakeNegative {

	public static void main(String[] args) {
		SolutionTest.assertEquals(-42, makeNegative(42));
		SolutionTest.assertEquals(-1, makeNegative(1));
		SolutionTest.assertEquals(0, makeNegative(0));
		SolutionTest.assertEquals(-5, makeNegative(-5));
	}

	private static int makeNegative(int i) {
		if(i<=0)return i;
		else return i*(-1);
	}
//다른 사람 풀이
	//Math의 절대값 method를 사용해서 무조건 음수를 반환하도록함.
	public static int makeNegative1(final int x) {
		return -Math.abs(x);
	}
	//삼항연산자를 사용해서 if문의 길이를 줄임.
	public static int makeNegative2(final int x) {
		return (x < 0) ? x : -x; //return x > 0 ? -x : x;
	}
}
