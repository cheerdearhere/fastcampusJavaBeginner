package codewars;

import java.util.stream.Stream;

public class ShortestWord {
	/*
	*Simple, given a string of words, return the length of the shortest word(s).
	*String will never be empty and you do not need to account for different data types. 
	*/
	public static void main(String[] args) {
		int a= findShort("bitcoin take over the world maybe who knows perhaps");//3
        System.out.println(a);
		a=findShort("turns out random test cases are easier than writing out basic ones");//3
        System.out.println(a);
		a=findShort("Let's travel abroad shall we");//2
		System.out.println(a);
	}
	private static int findShort(String s) {
		int min=10; 
		int len=0;
		String[] words = s.split(" ");
		for(String word : words) {
			len=word.length();
			if(min>len) {
				min=len;
			}
		}
		return min;
	}
	private static int findShort2(String s) {
		return Stream.of(s.split(" "))//String을 배열로 받아 Arrays.stream으로
				.mapToInt(String::length)//String.length()를 각각 변환
				.min()//그중 최소값
				.getAsInt();//int로 반환
	}
	
}
