package fastcampus.javaSpring.chapter05.ch03;

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
		//first element는 head에 바로 연결
		if(head==null) {
			newNode = new MyListNode(data);
			head=newNode;
		}
		//first가 아닌 경우 last node를 찾아 data입력
		else {
			//data는 그대로 입력
			newNode = new MyListNode(data);
			//previous node search
			MyListNode temp = head;
			//next==null: last node
			while(temp.next !=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
		count++;
		return newNode;
	}
	//insert
	public MyListNode insertElement(int index, String data) {
		int i;
		//first, previous, new
		MyListNode tempNode=head;
		MyListNode preNode=null;
		MyListNode newNode = new MyListNode(data);
		//index error check
		if(index<0 || index>count) {
			return null;
		}
		//first element는 head에 바로 연결
		if(index==0) {
			newNode.next=head;
			head=newNode;
		}
		//first element가 아니면 대상 위치의 previous node의 연결을 끊고 
		//그 연결을 받아 next node로 연결
		else {
			for(i=0;i<index;i++) {
				//index-1의 노드 = previous node
				preNode=tempNode;
				//previous node의 next: 대상 위치의 node
				tempNode=tempNode.next;
			}
			//원하는 위치의 node에서 previous node의 연결 코드를 받아 next와 연결
			newNode.next = preNode.next;
			//previous node의 next address를 new node로 연결
			preNode.next = newNode;
		}
		count++;
		return newNode;
	}
	//삭제: previous node와의 연결을 끊고 previous node와 next node를 연결 
	public MyListNode removeElement(int index) {
		int i;
		
		MyListNode tempNode = head;
		MyListNode preNode = null;
		if(index<0||index>count) {
			return null;
		}
		//first element는 head만 변경
		if(index==0) {
			head = tempNode.next;
			
		}
		//그외 element
		else {
			for(i=0;i<index;i++) {
				//preNode==previous node
				preNode=tempNode;
				//tempNode==target node
				tempNode=preNode.next;
			}
			//previous node와 next node connecting
			preNode.next = tempNode.next;
			/*C언어에서는 데이터도 삭제해 메모리를 지워야하지만 Java는 garbage collector가 자동 삭제*/
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
