package codewars;
/*
This function takes two parameters: name and owner.

Use conditionals to return the proper message:

case	return
name equals owner	'Hello boss'
otherwise	'Hello guest'
*/
public class PersonalizedMessage {

	public static void main(String[] args) {
		SolutionTest.assertEquals("Hello boss", greetMachine("Daniel","Daniel"));
		SolutionTest.assertEquals("Hello guest", greetMachine("Greg","Daniel"));
	}
	public static String greetMachine(String name,String owner) {
		if(name==null||owner==null) return "";
		return name.equals(owner) ? "Hello boss" : "Hello guest";
	}
//다른 사람 풀이
	//순서
	static String greet1(String name, String owner) {
        return "Hello " + (name.equals(owner) ? "boss":"guest");
    }
	//String.format()
	static String greet2(String name, String owner) {
		return String.format("Hello %s", name.equals(owner) ? "boss" : "guest");
	}
	//toUpperCase()
	static String greet3(String name, String owner) {
		if (name.toUpperCase().equals(owner.toUpperCase())) return "Hello boss";
		else return "Hello guest";
	}
}
