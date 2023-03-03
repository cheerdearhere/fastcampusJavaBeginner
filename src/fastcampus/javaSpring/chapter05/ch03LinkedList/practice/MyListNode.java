package fastcampus.javaSpring.chapter05.ch03LinkedList.practice;
//class Role: LinkedList의 head
public class MyListNode {
	private String data;//자료는 보안을 위해 private
	public MyListNode next;//다음 노드의 address(링크)
	
//constructor
	//default
	public MyListNode() {
		data=null;
		next=null;
	}
	//data 
	public MyListNode(String data) {
		this.data=data;
		next=null;
	}
	//link and data
	public MyListNode(String data, MyListNode next) {
		this.data=data;
		this.next=next;
	}
//get data
	public String getData() {
		return data;
	}
}
