package fastcampus.javaSpring.chapter05.ch05;

import fastcampus.javaSpring.chapter05.ch03.MyLinkedList;
import fastcampus.javaSpring.chapter05.ch03.MyListNode;

interface Queue{
	public void enQue(String data);
	public String deQueue();
	public void printQueue();
}
public class MyLinkedQueue extends MyLinkedList implements Queue{
	//node 
	MyListNode front;
	MyListNode rear;
	
	@Override
	public void enQue(String data) {
		MyListNode newNode;
		//myLinkedList의 isEmpty()
		if(isEmpty()) {
			newNode=addElement(data);
			front=newNode;//제일 앞.
			rear = newNode;
		}
		else {
			newNode=addElement(data);
			rear=newNode;
		}
		System.out.println(newNode.getData()+" added.");
		
	}

	@Override
	public String deQueue() {
		if(isEmpty()) {
			System.out.println("Error: Queue is empty");
			return null;
		}
		//data의 출력이 head node(front)에서만 실행
		String data = front.getData();
		front=front.next;
		if(front==null) {
			rear=null;
		}
		return data;
	}

	@Override
	public void printQueue() {
		printAll();
	}

}
