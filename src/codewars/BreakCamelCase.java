package codewars;

import java.util.stream.Collectors;

/*the function will break up camel casing, using a space between words.
 * Example
 * "camelCasing"  =>  "camel Casing"
 * "identifier"   =>  "identifier"
 * ""             =>  ""
*/
public class BreakCamelCase {
	public static void main(String[] args) {
		SolutionTest.assertEquals("camel Casing", camelCase("camelCasing"));
		SolutionTest.assertEquals("camelcasingtest", camelCase("camelcasingtest"));
		SolutionTest.assertEquals("camel Casing Ctest", camelCase("camelCasingCtest"));
		SolutionTest.assertEquals("camel Casing Test", camelCase("camelCasingTest"));
	}
	public static String camelCase(String input) {
		int upperNum = 0;
		String res="";
		//null check
		if(input==null)return "";
		//camel case check(contain upper case)
		char [] inputArray = input.toCharArray();
		for(char alp:inputArray) 
			if(alp>='A'&&alp<='Z') 
				upperNum++;
		//" "
		res=input;
		for(char c='A';c<='Z';c++) 
			res = res.replaceAll(c+"", " "+c);
		//return
		if(upperNum==0) return input;
		return res;
	}
//다른 사람 풀이
	//정규식 사용
	public static String camelCase1(String input) {
		return input.replaceAll("([A-Z])", " $1");
	}
	//isUpperCase, 삼항연산자
	public static String camelCase2(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
		output = Character.isUpperCase(input.charAt(i)) 
				? output + " " + input.charAt(i) 
				: output + input.charAt(i);
		}
		return output;
	}
	//isUppereCase, if
	static String camelCase3(String input) {
		var separated = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
				separated.append(' ');
			}
			separated.append(c);
		}
		return separated.toString();
	}
	//Arrays, collect, Collectors.joining()
	 public static String camelCase4(String input) {
		return input.chars()
		.mapToObj(ch 
				-> Character.isUpperCase(ch) 
					? " " + String.valueOf((char) ch) 
					: String.valueOf((char) ch)
		).collect(Collectors.joining());
	}
}
