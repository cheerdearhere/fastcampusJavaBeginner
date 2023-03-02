package codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*A pangram is a sentence that contains every single letter of the alphabet at least once. 
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, 
 * because it uses the letters A-Z at least once (case is irrelevant).
 * 
 * Given a string, detect whether or not it is a pangram. 
 * Return True if it is, False if not. 
 * Ignore numbers and punctuation.*/
public class PangramChecker {

	public static void main(String[] args) {
		String pangram1 = "The quick brown fox jumps over the lazy dog.";
		String pangram2 = "You shall not pass!";
		
		PangramChecker pc = new PangramChecker();
		SolutionTest.assertEquals(true, pc.check(pangram1));
		SolutionTest.assertEquals(false, pc.check(pangram2));
	}
	public boolean check(String sentence) {
		if(sentence==null) return false;
		String alp = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		sentence = sentence.toLowerCase();
		
		String[] alps = alp.split(" ");
		for(String al:alps) {
			int i=sentence.indexOf(al);
			if(i==-1) return false;
		}
		
		return true;
	}
//다른 사람 풀이
	//char로 for문 사용
	public boolean check1(String sentence){
        for (char c = 'a'; c<='z'; c++)
        	//문장이 해당 문자(a~z)를 가지고 있지 않으면 false
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;
	}
	//stream
	public boolean check2(String sentence){
	  			//문자의 배열
		return sentence.chars()
	  			//각 char를 모두 소문자로
	  			.map(Character::toLowerCase)
	  			//그중 알파벳만(isLetter()도 가능)
	  			.filter(Character::isAlphabetic)
	  			//중복 제거
	  			.distinct()
	  			//알파벳 소문자의 개수.
	  			.count() == 26;
	  }
	//HashSet을 사용해 중복제거
	 public boolean check3(String s) {
		 //HashSet, generic programming
		 return new HashSet<>(Arrays.asList(s.toUpperCase()
				 		//정규식으로 UpperCase 알파벳 찾기
				 		.replaceAll("[^A-Z]","").split("")))
				 //자료의 갯수로 확인
				 	.size() == 26;
	 }
	 //Arrays.containsAll()
	 public boolean check4(String sentence){
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		List<String> sentence_chars = Arrays.asList( sentence.toLowerCase().split("") );
		List<String> alphabet_chars = Arrays.asList( alphabet.split("") );
		//Char array로 비교
		return sentence_chars.containsAll( alphabet_chars ); 
	 }
}
