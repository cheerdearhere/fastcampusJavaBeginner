package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.
 * Examples
 * "This is an example!" ==> "sihT si na !elpmaxe"
 * "double  spaces"      ==> "elbuod  secaps"
*/
public class ReverseWord {

	public static void main(String[] args) {
		SolutionTest.assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", reverseWords("The quick brown fox jumps over the lazy dog."));
		SolutionTest.assertEquals("elppa", reverseWords("apple"));
		SolutionTest.assertEquals("a b c d", reverseWords("a b c d"));
		SolutionTest.assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
	}
	public static String reverseWords(final String original) {
		if(original.trim()=="")
			return original;
		
		StringBuilder sb = new StringBuilder();
		String[] words = original.split(" ");
		String[] res = new String[words.length];
		int i=0;
		for(String word:words) {
			sb=sb.append(word).reverse();
			res[i]=sb.toString();
			i++;
			sb=new StringBuilder("");
		}
		return String.join(" ", res);
	}
//다른 사람 풀이
	public static String reverseWords1(final String original) { 
		String[] array = original.split(" ");
	
		if(array.length == 0) 
			return original;
	
		int i = 0;
		for(String string : array){
			array[i] = new StringBuilder(string).reverse().toString();
			i++;
		}
		return String.join(" ",array);
	}
	//Arrays.stream+정규식
	public static String reverseWords2(final String original) {
		return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)"))
				.map(str -> new StringBuilder(str).reverse().toString())
				.collect(Collectors.joining());
	}
	//Arrays.stream+3항연산자
	public static String reverseWords3(final String original) {
		return original.trim()
				.isEmpty() ? original : Stream.of(original.split(" "))
				.map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));
	}
}
