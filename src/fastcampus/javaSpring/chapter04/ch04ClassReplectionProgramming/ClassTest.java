package fastcampus.javaSpring.chapter04.ch04ClassReplectionProgramming;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class c1 = Class.forName("fastcampusJava.chapter04.ch04.PersonNewInstance");
		PersonNewInstance person = (PersonNewInstance)c1.newInstance();//곧 사라질 method
		
		person.setName("Lee");
		System.out.println(person);//toString()
		
		//default constructor
		Class c2 = person.getClass();
		PersonNewInstance p = (PersonNewInstance)c2.newInstance();
		System.out.println(p);
		
		/*local에 없는 class를 호출하는 경우(remote에서 통합된 환경용)*/
		Class[] parameterTypes = {String.class};
		//parameterType을 따로 지정하지 않고 받아서 사용.
		Constructor cons = c2.getConstructor(parameterTypes);
		Object[] initargs = {"Kim"};
		PersonNewInstance kimPerson = (PersonNewInstance)cons.newInstance(initargs);
		System.out.println(kimPerson);
		/*같은 machine안에서도 메모리를따로 사용하는 경우 
		 * 가상메모리 주소가 달라지기때문에 remote와 같이 처리한다. 
		*/
		
		//local에 있는 경우에는 일반 생성자 사용
		PersonNewInstance personKim = new PersonNewInstance("kim");
	}

}
