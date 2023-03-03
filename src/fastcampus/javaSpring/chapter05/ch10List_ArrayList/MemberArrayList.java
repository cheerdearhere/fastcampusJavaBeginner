package fastcampus.javaSpring.chapter05.ch10List_ArrayList;

import java.util.ArrayList;

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
		for(int i=0;i<arrayList.size();i++) {
			Member member = arrayList.get(i);
			int tempId = member.getMemberId();
			if(tempId==memberId) {
				arrayList.remove(i);
				System.out.println("memberNo."+memberId+" data removed");
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
