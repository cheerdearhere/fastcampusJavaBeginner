package fastcampus.javaSpring.spring.ch01IoC_DI;

public class Main {
    public static void main(String[] args){
    	String url="www.naver.com/books/it?page=10&size=20&name=spring-boot";
    /*	
    	//일반적인 java program: object 생성 > method 활용 
    	//Base 64 encoding
    	Encoder encoder = new Encoder();
    	String result = encoder.encode(url);
    	System.out.println(result);    	
    	//url encoding
    	UrlEncoder urlEncoder = new UrlEncoder();
    	result = urlEncoder.encode(url);
    	System.out.println(result);
    	//...같은 기능을 하지만 다른 대상을 하는 경우 매번 새로 코드를 짜야한다. 
    */	
    	//IEncoder를 만들고 UrlEncoder와 Base644Encoder class에 구현
    	Encoder encoder = new Encoder(new Base64Encoder());
    	String result = encoder.encode(url);
    	System.out.println(result);    	
    	//Encoder class를 직접 건들지 않아도 주입되는 외부 객체의 종류에 따라 처리가 달라진다.
    	encoder = new Encoder(new UrlEncoder());
    	result = encoder.encode(url);
    	System.out.println(result);    	
    	//기초적인 DI의 개념
    	
    }
}
