package fastcampus.javaSpring.chapter05.ch13Set_TreeSet;

import java.util.Comparator;
import java.util.TreeSet;
class MyCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2)*-1;//node의 방향을 역전시킴
	}
	
}
public class ComparatorComparableTest {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>(new MyCompare());
		set.add("Park");
		set.add("Kim");
		set.add("Lee");
		set.add("Cho");
		//before overriding : [Cho, Kim, Lee, Park]
		//after overriding : [Park, Lee, Kim, Cho]
		System.out.println(set);
	}
}
