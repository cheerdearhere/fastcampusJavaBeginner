package fastcampus.javaSpring.chapter06.ch05Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Tomas");
		list.add("Edward");
		list.add("Jack");
		
		Stream<String> stream= list.stream();
		stream.forEach(str->System.out.print(str+" "));
		System.out.println();
		
		//stream에서 정렬을 바꿔도 원래 데이터는 바뀌지 않는다.
		list.stream().sorted().forEach(str->System.out.print(str+"/"));
		System.out.println();
		
		//객체가 가진 method를 각 요소에 사용할때는 map()이 유용하다.
		list.stream().map(str->str.length()).forEach(n->System.out.print(n+"\t"));
		System.out.println();
		
		//조건으로 데이터를 걸러낼때는 filter()를 사용한다.
		list.stream().filter(str->str.length() >= 5).forEach(str->System.out.print(str+" "));
	}
}
