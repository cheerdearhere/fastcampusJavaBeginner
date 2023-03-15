package fastcampus.javaSpring.chapter06.ch06Reduce;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{
	@Override
	public String apply(String t, String u) {
		return t.getBytes().length>=u.getBytes().length ? t : u;
	}
}
public class ReduceTest {
	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~~","hello","Goood morning","반갑습니다^^"};
		
	//Lambda 표현식을 사용해 가장 큰 용량을 차지하는 문자열 반환하기
		System.out.println(
				Arrays.stream(greetings)
				.reduce("",(s1,s2)->{
					if(s1.getBytes().length >= s2.getBytes().length) return s1;
					else return s2;}
				)
		);
		//한글은 한글자당 2byte를 차지하므로 영어보다 크게 계산된다.
		
	//BinaryOperator interface구현해 사용하기
		//.Stream.reduce(BinaryOperator<String> accumulator)
		System.out.println(
				Arrays.stream(greetings)
				.reduce(new CompareString())
				.get()
		);
	}
}
