package codewars;
/*
 * Create a function that takes an integer as an argument 
 * and returns "Even" for even numbers or "Odd" for odd numbers.
*/
public class EvenOrOdd {
	public static void main(String[] args) {
		SolutionTest.assertEquals("Even",even_or_odd(6));
		SolutionTest.assertEquals("Odd",even_or_odd(7));   
		SolutionTest.assertEquals("Even",even_or_odd(0));
		SolutionTest.assertEquals("Odd",even_or_odd(-1)); 
	}
	private static String even_or_odd(int number) {
		return (number%2)==0 ? "Even" : "Odd";
	}
}
