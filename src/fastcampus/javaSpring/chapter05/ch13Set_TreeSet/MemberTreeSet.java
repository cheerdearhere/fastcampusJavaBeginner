package fastcampus.javaSpring.chapter05.ch13Set_TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(new Member());
	}
	public void addMember(Member member) {
		treeSet.add(member);
	}
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = treeSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(tempId==memberId) {
				//for는 list의 index로 처리했지만 iterator는 객체(object)로 삭제
				treeSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId+"가 존재하지 않습니다.");
		return false;
	}
	public void showAllMember() {
		System.out.println("--------회원목록---------");
		for(Member member:treeSet) {
			System.out.println(member);
		}
		System.out.println("-------------------------");
	}
}
