package codewars;

import java.util.stream.Collectors;

/*
Given a string of digits, you should replace any digit below 5 with '0' 
and any digit 5 and above with '1'. 
Return the resulting string.

Note: input will never be an empty string
*/
public class FakeBinary {

	public static void main(String[] args) {
		SolutionTest.assertEquals("01011110001100111", fakeBin("45385593107843568"));
		SolutionTest.assertEquals("101000111101101", fakeBin("509321967506747")); 
		SolutionTest.assertEquals("011011110000101010000011011", fakeBin("366058562030849490134388085"));
	}
	private static String fakeBin(String numberString) {
		if(numberString==null) return "";
		String[] numberList = numberString.split("");
		/*Stream 실패
		return Arrays.stream(numberList)
				.mapToInt(Integer::parseInt)
				.map(i->i<5 ? 0 : 1).map(i->i+"")
				.reduce("",(a,b)->{
					return a+b;
				});*/
		StringBuilder sb = new StringBuilder();
		for(String n: numberList) {
			int i = Integer.parseInt(n);
			i= (i<5) ? 0 : 1;
			sb.append(i);
		}
		return sb.toString();
	}
//다른 사람 풀이
	//replaceAll();
	public static String fakeBin1(String numberString) {
        return numberString.replaceAll("[0-4]", "0").replaceAll("[5-9]", "1");
    }
	//toCharArray()
	public static String fakeBin2(String numberString) {
        final char c[] = numberString.toCharArray();
        for (int i = 0; i < c.length; i++)
          c[i] = c[i] < '5' ? '0' : '1';
        return new String(c);
    }
	//mapToObj().collect()
	public static String fakeBin3(String str) {
        return str.chars().mapToObj(c -> c < '5' ? "0" : "1").collect(Collectors.joining());
    }
}