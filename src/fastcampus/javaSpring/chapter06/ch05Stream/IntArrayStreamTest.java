package fastcampus.javaSpring.chapter06.ch05Stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntArrayStreamTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		//배열에서 하나씩 사용
		for(int num:arr) {
			System.out.println(num);
		}
		
		//Stream interface 사용
		Arrays.stream(arr).forEach(n->System.out.println(n));
		
		//유용한 method가 많음
		IntStream is = Arrays.stream(arr);
		IntSummaryStatistics summary = is.summaryStatistics();
		System.out.println(summary);
		//IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
		
		//is.forEach(n->System.out.print(n));
		//한번 사용하고난 Stream은 소진되고 재사용시 오류가 발생한다.
		//Exception in thread "main" java.lang.IllegalStateException: 
		//stream has already been operated upon or closed
		
		//재사용을 위해서는 스트림을 다시 생성해야한다. 
		Arrays.stream(arr).forEach(s->System.out.print(s));
		
		
	}
}
