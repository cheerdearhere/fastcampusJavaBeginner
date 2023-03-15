package codewars;

import java.util.stream.Stream;

/*
 * ATM machines allow 4 or 6 digit PIN codes 
 * and PIN codes cannot contain anything 
 * but exactly 4 digits or exactly 6 digits.
 * If the function is passed a valid PIN string, return true, else return false.

	Examples (Input --> Output)
		"1234"   -->  true
		"12345"  -->  false
		"a234"   -->  false
*/
public class RegexValidatePINCode {

	public static void main(String[] args) {
		SolutionTest.assertEquals(true, validatePin("1234"));
		SolutionTest.assertEquals(true, validatePin("0000"));
		SolutionTest.assertEquals(true, validatePin("1111"));
		SolutionTest.assertEquals(true, validatePin("123456"));
		SolutionTest.assertEquals(true, validatePin("098765"));
		SolutionTest.assertEquals(true, validatePin("000000"));
		SolutionTest.assertEquals(true, validatePin("090909"));
		SolutionTest.assertEquals(false, validatePin("a234"));
		SolutionTest.assertEquals(false, validatePin(".234"));
		SolutionTest.assertEquals(false, validatePin("1"));
		SolutionTest.assertEquals(false, validatePin("12"));
		SolutionTest.assertEquals(false, validatePin("123"));
		SolutionTest.assertEquals(false, validatePin("12345"));
		SolutionTest.assertEquals(false, validatePin("1234567"));
		SolutionTest.assertEquals(false, validatePin("-1234"));
		SolutionTest.assertEquals(false, validatePin("1.234"));
		SolutionTest.assertEquals(false, validatePin("00000000"));
		SolutionTest.assertEquals(false, validatePin("+001"));
	}
	public static final String ERROR_MESSAGE= "The PIN number can only be a 4-digit or 6-digit positive integer.";
	private static boolean validatePin(String pin) {
		int pinNum=0;
		//number Check
		try {
			pinNum=Integer.parseInt(pin);
		}catch(NumberFormatException e) {
			System.out.println(ERROR_MESSAGE);
			return false;
		}
		//only number
		char[] list =pin.toCharArray();
		for(char a: list) {
			if(!Character.isDigit(a)) {
				System.out.println(ERROR_MESSAGE);
				return false;
			}
		}
		//0 or positive
		if(pinNum<0) {
			System.out.println(ERROR_MESSAGE);
			return false;
		}
		//validate
		if(pin.length()==4||pin.length()==6)
			return true;
		//else
		System.out.println(ERROR_MESSAGE);
		return false;
	}
//다른 사람 풀이
	//String.matches(정규식)
	public static boolean validatePin1(String pin) {
		return pin.matches("\\d{4}|\\d{6}");
		//"[0-9]{4}|[0-9]{6}"
		//"^\\d{4}(\\d\\d)?$"
	}
	//Stream.allMatch()
	public static boolean validatePin2(String pin) {
		if (pin.length() == 4 || pin.length() == 6) 
			return pin.chars().allMatch(Character::isDigit);
		return false;
	}
	//replaceAll로 해당하는 것 체크
	public static boolean validatePin3(String pin) {
		return (pin.length() == 4 || pin.length() == 6) && pin.replaceAll("[0-9]","").length() == 0;
	}
	//switch-case문
	public static boolean validatePin4(String pin) {
		boolean b = true;
		if ((pin.length() == 4) | (pin.length() == 6)) 
			for (int i = 0; i < pin.length(); i++) 
				switch (pin.charAt(i)) {
					case '0': break;
					case '1': break;
					case '2': break;
					case '3': break;
					case '4': break;
					case '5': break;
					case '6': break;
					case '7': break;
					case '8': break;
					case '9': break;
					default : {
						b = false;
						break;
					}
				}
		else b = false;
		return b;
	}
}
