package fastcampus.javaSpring.chapter05.ch13Set_TreeSet;

public class MemberTreeSetTest {

	public static void main(String[] args) {

		MemberTreeSet memberTreeSet = new MemberTreeSet();
		Member memberHong = new Member(1004, "홍길동");
		Member memberLee = new Member(1001, "이순신");
		Member memberKim = new Member(1002, "김유신");
		Member memberKang = new Member(1003, "강감찬");
		memberTreeSet.addMember(memberHong);
		memberTreeSet.addMember(memberLee);
		memberTreeSet.addMember(memberKim);
		memberTreeSet.addMember(memberKang);

		//hashSet과 달리 treeSet을 사용하면 입력 순서와 관계없이 오름차순으로 정렬된다. 
		memberTreeSet.showAllMember();

		/*
		memberTreeSet.removeMember(memberKim.getMemberId());
		memberTreeSet.showAllMember();

		Member memberJang = new Member(1004, "장길산");
		memberTreeSet.addMember(memberJang);
		memberTreeSet.showAllMember();
		*/
		
	}

}
