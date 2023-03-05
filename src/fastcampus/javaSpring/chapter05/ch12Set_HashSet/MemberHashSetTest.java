package fastcampus.javaSpring.chapter05.ch12Set_HashSet;

import java.util.HashSet;

public class MemberHashSetTest {

	public static void main(String[] args) {
		//넣고 확인
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add(new String("김유신"));
		hashSet.add(new String("이순신"));
		hashSet.add(new String("홍연의"));
		hashSet.add(new String("강감찬"));
		hashSet.add(new String("강감찬"));		
		System.out.println(hashSet);

		MemberHashSet memberHashSet = new MemberHashSet();
		Member memberLee = new Member(1001, "이순신");
		Member memberKim = new Member(1002, "김유신");
		Member memberKang = new Member(1003, "강감찬");
		Member memberHong = new Member(1004, "홍길동");
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberKang);
		memberHashSet.addMember(memberHong);
		//list와 달리 들어간 순서나 id 정렬은 안되고있음. 
		memberHashSet.showAllMember();
		memberHashSet.removeMember(memberKim.getMemberId());
		memberHashSet.showAllMember();
		//같은 id가들어갔음에도 이상이 없는이유: 
		//중복값에 대한 처리(equals, hashCode override)가 되어있지 않기 때문.
		//override는 데이터 class인 Member에서 구현하며 이 두 method를 구현해놓으면
		//constructor 작동시 같은 id로는 가입이 불가하게됨. 
		//override하지 않으면 그대로 virtual memory address를 사용하기때문에
		//중복데이터를 막지않는다. 
		Member memberJang = new Member(1004, "장길산");
		memberHashSet.addMember(memberJang);
		memberHashSet.showAllMember();
		
		
	}

}
