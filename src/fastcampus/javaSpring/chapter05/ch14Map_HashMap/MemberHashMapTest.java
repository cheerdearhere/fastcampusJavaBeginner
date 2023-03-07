package fastcampus.javaSpring.chapter05.ch14Map_HashMap;

public class MemberHashMapTest {
	public static void main(String[] args) {
		MemberHashMap memberHashMap = new MemberHashMap();
		
		Member memberHong = new Member(1004,"홍길동");
		Member memberLee = new Member(1002,"이순신");
		Member memberKim = new Member(1001,"김유신");
		Member memberKang = new Member(1003,"강감찬");
		
		memberHashMap.addMember(memberKang);
		memberHashMap.addMember(memberHong);
		memberHashMap.addMember(memberKim);
		memberHashMap.addMember(memberLee);
		
		memberHashMap.showAllMember();
		System.out.println("hashMap을 바로 println하면");
		memberHashMap.showHashMap();
	}
}
