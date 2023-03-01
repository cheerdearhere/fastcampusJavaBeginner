package codewars;

import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * remove the spaces from the string, then return the resultant string. 
*/
public class RemoveStringSpace {
	 
	public static void main(String[] args) {
		SolutionTest.assertEquals("8j8mBliB8gimjB8B8jlB", noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
		SolutionTest.assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
		SolutionTest.assertEquals("8aaaaaddddr", noSpace("8aaaaa dddd r     "));
		SolutionTest.assertEquals("jfBmgklf8hg88lbe8", noSpace("jfBm  gk lf8hg  88lbe8 "));
		SolutionTest.assertEquals("8jaam", noSpace("8j aam"));
	}
	public static String noSpace(final String x) {
		return Stream.of(x.split(" "))
				.map(s->s)
				.collect(Collectors.joining());
	}
	
}
