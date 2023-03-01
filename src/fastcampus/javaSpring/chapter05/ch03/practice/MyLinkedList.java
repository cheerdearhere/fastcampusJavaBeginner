package fastcampus.javaSpring.chapter05.ch03.practice;

public class MyLinkedList {
	private MyListNode head;//head node
	int count;//list size
	String m=new String("");
	
	//default constructor
	public MyLinkedList() {
		head=null;
		count=0;
	}
	//add
	public MyListNode addElement(String data) {
		MyListNode newNode;
		if(head==null) {
			newNode=new MyListNode(data);
			head=newNode;
		}
		else {
			newNode = new MyListNode(data);
			MyListNode tempNode = head;
			while(tempNode.next!=null) {
				tempNode=tempNode.next;
			}
			tempNode.next=newNode;
		}
		count++;
		return newNode;
	}
	//insert
	public MyListNode insertElement(int position,String data) {
		int i;
		MyListNode tempNode=head;
		MyListNode preNode=null;
		MyListNode newNode=new MyListNode(data);
		if(position<0||position>count) {
			System.out.println("Error: index number");
			return null;
		}
		if(position==0) {
			newNode.next=head;
			head=newNode;
		}
		else {
			for(i=0;i<position;i++) {
				preNode=tempNode;
				tempNode=tempNode.next;
			}
			newNode.next=preNode.next;
			preNode.next=newNode;
		}
		count++;
		return newNode;
	}
	//삭제: previous node와의 연결을 끊고 previous node와 next node를 연결 
	public MyListNode removeElement(int position) {
		int i;
		MyListNode preNode =null;
		MyListNode tempNode=head;
		if(position<0||position>count) {
			System.out.println("Error: index number");
			return null;
		}
		if(position==0) {
			head=tempNode.next;
		}
		else {
			for(i=0;i<position;i++) {
				preNode=tempNode;
				tempNode=preNode.next;
			}
			preNode.next=tempNode.next;
		}
		count--;
		return tempNode;
	}
	//get data
	public String getElement(int index) {
		int i;
		MyListNode tempNode = head;
		if(index<0||index>=count) {
			System.out.println("ERROR: 검색위치를 확인해주세요. 현재 리스트의 개수는 "+count+"개 입니다. \n input: "+index);
			return new String("error");
		}
		if(index==0) {
			return head.getData();
		}
		//search target node
		for(i=0;i<index;i++) {
			tempNode=tempNode.next;
		}
		return tempNode.getData();
	}
	//getNode
	public MyListNode getNode(int index) {
		int i;
		MyListNode tempNode=head;
		if(index<0||index>=count) {
			System.out.println("ERROR: 검색위치를 확인해주세요. 현재 리스트의 개수는 "+count+"개 입니다. \n input: "+index);
			return null;
		}
		if(index==0) {
			return head;
		}
		for(i=0;i<index;i++) {
			tempNode=tempNode.next;
		}
		return tempNode;
	}
	//remove list
	public void removeAll() {
		head=null;
		count=0;
	}
	//get size
	public int getSize() {
		return count;
	}
	//print list
	public void printAll() {
		if(count==0) {
			System.out.println("출력할 내용이 없습니다.");
			return;
		}
		
		MyListNode tempNode = head;
		StringBuilder msb = new StringBuilder(m);
		msb.append("print linked list("+count+"): ");
		while(tempNode!=null) {
			msb.append("("+tempNode.getData()+"/next: "+System.identityHashCode(tempNode.next)+")");
			tempNode=tempNode.next;
			if(tempNode!=null) {
				msb.append("=>");
			}
		}
		System.out.println(msb.toString());
	}
	//empty 
	public boolean isEmpty() {
		if(head==null)return true;
		else return false;
	}
}
