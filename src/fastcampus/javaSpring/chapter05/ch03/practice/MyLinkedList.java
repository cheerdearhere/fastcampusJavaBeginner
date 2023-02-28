package fastcampus.javaSpring.chapter05.ch03.practice;

public class MyLinkedList {
	private MyListNode head;//head node
	int count;//list size
	String m=new String("");
	
	//default constructor
	//add
	//insert
	//삭제: previous node와의 연결을 끊고 previous node와 next node를 연결 

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
