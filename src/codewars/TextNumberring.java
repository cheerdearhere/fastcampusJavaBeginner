package codewars;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Write a function which takes a list of strings 
 * and returns each line prepended by the correct number.
 * The numbering starts at 1. The format is n: string. 
 * Notice the colon and space in between.
 * 	Examples: (Input --> Output)
 * 		[] --> []
 * 		["a", "b", "c"] --> ["1: a", "2: b", "3: c"]
*/
public class TextNumberring {
	public static void main(String[] args) {
		SolutionTest.assertIterableEquals(Arrays.asList(), lineNumbering(Arrays.asList()));
		SolutionTest.assertIterableEquals(Arrays.asList("1: a", "2: b", "3: c"), lineNumbering(Arrays.asList("a", "b", "c")));
		SolutionTest.assertIterableEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "), lineNumbering(Arrays.asList("", "", "", "", "")));
	}
	private static List<String> lineNumbering(List<String> lines) {
		if(lines==null||lines.size()==0)return lines;
		AtomicInteger index = new AtomicInteger(1);
  		return lines.stream().map(str->{
			return str=index.getAndIncrement()+": "+str;
		}).peek(System.out::println).collect(Collectors.toList());
	}
//다른 사람 풀이
	//for문
	static List<String> number1(List<String> lines) {
        ArrayList<String> result = new ArrayList();
        int i = 0;
        for (String s : lines) {
            result.add(++i + ": " + s);
        }
        return result;
    }
	//IntStream을 사용해 index처리
	static List<String> number2(List<String> lines) {
	    if (lines.size() == 0) return lines;
	    return IntStream.range(0, lines.size())
	            .mapToObj(n -> String.format("%d: %s", n+1, lines.get(n)))
	            .collect(Collectors.toList());
	}
	//String.format()으로 입력
	static List<String> number3(List<String> lines) {
        List<String> result = new ArrayList<>(lines.size());
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int lineNumber = i + 1;
            String lineWithLineNumbers = String.format("%d: %s", lineNumber, line);
            result.add(lineWithLineNumbers);
        }
        return result;
    }
}
