package fastcampus.javaSpring.chapter05.ch03.practice;

public class MyLinkedListTest {
	//복습용 Class
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.addElement("A");
		list.addElement("B");
		list.addElement("C");
		list.printAll();
		
		list.insertElement(3, "D");
		list.printAll();
		list.removeElement(0);
		list.printAll();
		list.removeElement(1);
		list.printAll();
		
		list.insertElement(0, "A-1");
		list.printAll();
		System.out.println(list.getSize());
		
		list.removeElement(0);
		list.printAll();
		System.out.println(list.getSize());
		
		list.removeAll();
		list.printAll();
		System.out.println("Is empty? "+list.isEmpty());
		list.addElement("A");
		list.printAll();
		System.out.println(list.getElement(0));
		list.removeElement(0);
	}

}