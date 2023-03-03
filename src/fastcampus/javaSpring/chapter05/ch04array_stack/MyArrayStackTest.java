package fastcampus.javaSpring.chapter05.ch04array_stack;

public class MyArrayStackTest {

	public static void main(String[] args) {
		MyArrayStack stack=new MyArrayStack(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);//size를 3으로 만들었기때문에 full error
		stack.printAll();
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.printAll();
	}

}
