package fastcampus.javaSpring.chapter05.ch12Set_HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
	//set 객체를 보관
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	public MemberHashSet(int size) {
		hashSet = new HashSet<Member>(size);
	}
	public void addMember(Member member) {
		hashSet.add(member);
	}
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = hashSet.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(tempId==memberId) {
				//for는 list의 index로 처리했지만 iterator는 객체(object)로 삭제
				hashSet.remove(member);
				return true;
			}
		}
		System.out.println(memberId+"가 존재하지 않습니다.");
		return false;
	}
	public void showAllMember() {
		System.out.println("--------회원목록---------");
		for(Member member:hashSet) {
			System.out.println(member);
		}
		System.out.println("-------------------------");
	}
}
