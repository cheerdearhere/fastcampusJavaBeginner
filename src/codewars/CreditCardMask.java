package codewars;

import java.util.Collections;

public class CreditCardMask {
/*Usually when you buy something, you're asked whether your credit card number, 
 * phone number or answer to your most secret question is still correct. 
 * However, since someone could look over your shoulder, 
 * you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, 
which changes all but the last four characters into '#'.

"4556364607935616" --> "############5616"
     "64607935616" -->      "#######5616"
               "1" -->                "1"
                "" -->                 ""
 */
	public static void main(String[] args) {
		SolutionTest.assertEquals("############5616", maskify("4556364607935616"));
		SolutionTest.assertEquals("#######5616",      maskify(     "64607935616"));
		SolutionTest.assertEquals("1",                maskify(               "1"));
		SolutionTest.assertEquals("",                 maskify(                ""));
		// "What was the name of your first pet?"
		SolutionTest.assertEquals("##ippy",                                    maskify("Skippy")                                  );
		SolutionTest.assertEquals("####################################man!",  maskify("Nananananananananananananananana Batman!"));
	}
	public static String maskify(String str) {
        if(str==null)return null;
        int len = str.length();        
        
        StringBuilder sb = new StringBuilder(str);
    	StringBuilder m = new StringBuilder("");
        if(len<=4)return str;
        else {
        	for(int i =0;i<len-4;i++) {
        		m.append("#");
        	}
        	String temp=sb.substring(len-4);
        	m.append(temp);
        }
        System.out.println(m);
        return m.toString();
    }
//다른 사람 풀이
	//String 사용
    public static String maskify1(String str) {
    	//방식은 비슷
        if (str.length() <= 4) return str;
        String result = "";
        for (int i = 0; i < str.length()-4; i++) {
            result += "#";
        }
        return result + str.substring(str.length()-4);
    }
    //정규식 사용
    public static String maskify2(String str) {
    	//속도는 느리지만 코드를 줄일 수 있어 
    	//사용자 유효성 검증, 패턴에 기반한 감지, 민감정보 암호화를 위해 자주 사용된다. 
        return str.replaceAll(".(?=.{4})", "#");
        //마지막 네글자는 남기고 나머지 #으로 치환
    }
    //Char[]
    public static String maskify3(String str) {
        char[] strChars = str.toCharArray();
        for( int i = 0; i < strChars.length - 4; i++ ) {
          strChars[i] = '#';
        }
        return new String(strChars);
      }
    //String.join과 Collections.nCopies(반복수,반복문자)
    private static final String MASK_CHAR = "#";
    private static final int UNMASK_COUNT = 4;
    public static String maskify4(String str) {
      int len = str.length();
      if (len <= UNMASK_COUNT) {
        return str;
      }
      int maskCount = len - UNMASK_COUNT;
      return String.join("", Collections.nCopies(maskCount, MASK_CHAR))
          + str.substring(maskCount);
    }
    //삼항연산자,정규식
    public static String maskify5(String str) {
    	//?연산자로 4글자 이하 문자열을 구분하고
    	return str.length()<=4 ? str 
    							//4글자 이상은 0~(length-4)까지의 문자를
    							: str.substring(0,str.length()-4)
    									//모두 #으로(정규식)+마지막 4문자
    									.replaceAll(".","#") + str.substring(str.length()-4);
    }
    //이건 뭐지...
    public static String maskify6(String x) {
    	String str="";
    	//x.length()가 4보다 클때인듯?
    	if(x.length()*~0<-(~ -(~ -2|4)&0xcafe)){
    		//for(int i=0;i<x.length();i++)..
    		for(int i= ~ -(3&~-6&~ 0xcafeface+~-1&3);~-(i-~0)<x.length()*-~(2&4&8&0x0a)+~-~2;i-=~-0)
    			str+=(char)(0x23&(~0xc0ff33|0xffffff));
    		for(int i=~-(~-(7&-~13)|-~0);-~(-i+~(2&~-5))<~-(3&-~4);i=~((i+1)*~0)+~0){
    			str+=x.charAt(~-2*x.length()+~(i+~0));}
    		return str;
    	}
    	else return x;
    }
}
