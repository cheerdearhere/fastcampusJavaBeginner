package fastcampus.javaSpring.chapter05.ch04;

import fastcampus.javaSpring.chapter05.ch02.MyArray;
//ch02에서 만든 배열로 스택만들기
public class MyArrayStack {
	MyArray arrayStack;
	int top;
//constructor
	//default
	public MyArrayStack() {
		top=0;
		arrayStack = new MyArray();
	}
	//with size
	public MyArrayStack(int size) {
		top=0;
		arrayStack=new MyArray(size);
	}
	//push: 넣을때 가득 찼는지 확인(크기가 정해진 Array이기 때문
	public void push(int data) {
		if(isFull()) {
			System.out.println("Error: stack is full!");
			return;
		}
		arrayStack.addElement(data);
		top++;
	}
//꺼낼때는 비었는지를 체크해야함. 라이브러리에서 체크하는지 확인
	//pop: 꺼내고 삭제
	public int pop() {
		if(isEmpty()) {
			System.out.println("Error: stack is empty!");
			return arrayStack.ERROR_NUM;
		}
		return arrayStack.removeElement(--top);
	}
	//peek: 꺼내고 삭제안함
	public int peek() {
		if(isEmpty()) {
			System.out.println("Error: stack is empty!");
			return arrayStack.ERROR_NUM;
		}
		return arrayStack.getElement(--top);
	}
	//isFull: Array를 사용할 경우 배열의 크기를 확인해야한다.
	public boolean isFull() {
		if(top==arrayStack.ARRAY_SIZE) return true;
		else return false;
	}
	//isEmpty: Null로 인한 에러를 막기위해 체크
	public boolean isEmpty() {
		if(top==0)return true;
		else return false;
	}
	//print
	public void printAll() {
		arrayStack.printAll();
	}
	
}
