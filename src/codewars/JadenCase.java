package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/* Your task is to convert strings to how they would be written by Jaden Smith. 
 * The strings are actual quotes from Jaden Smith, 
 * but they are not capitalized in the same way he originally typed them.
 * 
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
*/
public class JadenCase {
	public static void main(String[] args) {
		SolutionTest.assertEquals("Most Trees Are Blue", JadenCase.toJadenCase("most trees are blue"));
		SolutionTest.assertEquals("M[ost Trees Are B]lue", JadenCase.toJadenCase("m[ost trees are b]lue"));
		SolutionTest.assertNull("Must return null when the arg is null", JadenCase.toJadenCase(null));
		SolutionTest.assertNull("Must return null when the arg is empty string", JadenCase.toJadenCase(""));
	}
	public static String toJadenCase(String phrase) {
		if(phrase==null||phrase.equals("")) {
			return null;
		}
		String[] words = phrase.split(" ");
		StringBuilder m = new StringBuilder();
		for(int i=0;i<words.length;i++) {
			String a=words[i].charAt(0)+"";
			String A=a.toUpperCase();
			StringBuilder sb = new StringBuilder(words[i]);
			sb.replace(0, 1, A);
			System.out.println(sb.toString());
			m.append(sb);
			if(i<(words.length-1)) {
				m.append(" ");
			}
		}
		return m.toString();
	}
	//다른사람 풀이
	public String toJadenCase1(String phrase) {
		//null, "" check
	    if(phrase == null || phrase.equals("")) return null;
	    //char
	    char[] array = phrase.toCharArray();
	    for(int x = 0; x < array.length; x++) {
	    	//단어들의 제일 앞 char(0, ' '다음 문자)
	    	if(x == 0 || array[x-1] == ' ') {
	    		array[x] = Character.toUpperCase(array[x]);
	    	}
		}
			return new String(array);
	}
	public String toJadenCase2(String phrase) {
		if (null == phrase || phrase.length() == 0) {
			return null;
		}
		//" "로 쪼개기
		return Arrays.stream(phrase.split(" "))
				//각 단어마다 제일 앞단어를 대문자로 바꾸고 나머지 문자열 붙이기
				.map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
				//단어마다 띄어쓰기를 넣어서 합치기
				.collect(Collectors.joining(" "));
	}
/*	public String toJadenCase3(String phrase) {
		if(phrase == ""){
      return null;
    }
    else{
		  return WordUtils.capitalize(phrase);
    }
  }
  import org.apache.commons.lang3.text.WordUtils;
		//capitalize(""): 문자열에서 각 단어의 첫 글자를 대문자로 치환함. 
		//initials(""): 문자열의 앞글자를 모아 이니셜을 만듬.
		//wrap("",int 자리수): 단어를 기준으로 한 줄의 자리수에 들어가지 않으면 자동으로 아래로 내림
 maven은 dependency로 적용
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.11</version>
</dependency>

*/
}
