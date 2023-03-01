package fastcampus.javaSpring.chapter05.ch05;

public class MyLinkedQueueTest {

	public static void main(String[] args) {
		MyLinkedQueue queue = new MyLinkedQueue();
		queue.enQue("A");
		queue.enQue("B");
		queue.enQue("C");
		
		queue.printQueue();
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		queue.printQueue();
	}

}
