package fastcampus.javaSpring.chapter05.ch11Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {
	//list 객체를 보관
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}
	public MemberArrayList(int size) {
		arrayList = new ArrayList<Member>(size);
	}
	public void addMember(Member member) {
		arrayList.add(member);
	}
	public boolean removeMember(int memberId) {
		/*for(int i=0;i<arrayList.size();i++) {
			Member member = arrayList.get(i);
			int tempId = member.getMemberId();
			if(tempId==memberId) {
				arrayList.remove(i);
				System.out.println("memberNo."+memberId+" data removed");
				return true;
			}
		}
		for문 대신 Iterator를 사용해보자.
		*/
		Iterator<Member> ir = arrayList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(tempId==memberId) {
				//for는 list의 index로 처리했지만 iterator는 객체(object)로 삭제
				arrayList.remove(member);
				return true;
			}
		}
		System.out.println(memberId+"가 존재하지 않습니다.");
		return false;
	}
	public void showAllMember() {
		System.out.println("--------회원목록---------");
		for(Member member:arrayList) {
			System.out.println(member);
		}
		System.out.println("-------------------------");
	}
}
