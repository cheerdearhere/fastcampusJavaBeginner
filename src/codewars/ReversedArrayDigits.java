package codewars;


/* Given a random non-negative number, 
 * you have to return the digits of this number within an array 
 * in reverse order.
 * 
 * example 
 * 	35231 => [1,3,2,5,3]
 * 	0 => [0]
 */
public class ReversedArrayDigits {

	public static void main(String[] args) {
		SolutionTest.assertEquals(new int[] {1, 3, 2, 5, 3}, digitize(35231));
		SolutionTest.assertEquals(new int[] {0}, digitize(0));
		SolutionTest.assertEquals(new int[] {0,7,6,5,4,3,2,1}, digitize(12345670));
	}
	public static int[] digitize(long n) {
		if(n<0)
			return new int[] {(int)n};
		String numS = n+"";
		int size=numS.length();
		int[] res =new int[size];
		for(int i=0;i<size;i++) {	
			if(i==0) res[i]=Integer.parseInt(numS.charAt(size-1)+"");
			res[i]=(int) (numS.charAt(size - i - 1)) - 48;
		}
		return res;
	}
//다른 사람 풀이
	//StringBuilder.reverse+Arrays.chars...
	public static int[] digitize1(long n) {
		return new StringBuilder().append(n)
								.reverse()
								.chars()
								.map(Character::getNumericValue)
								.toArray();
	}
	//String을 만들어 for문으로 int[]
	public static int[] digitize2(long n) {
		String s = String.valueOf(n);
		int length = s.length();
		int[] array = new int[length];
		for ( int i = 0; i < length; i++)
			array[i] = (int) (s.charAt(length - i - 1)) - 48;
		return array;
	}
}
