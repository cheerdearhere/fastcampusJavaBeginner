package fastcampus.javaSpring.chapter05.ch14Map_HashMap;
//List, set은 Collection에 속하기때문에 method가 유사했으나 Map은 다르다.
import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	//K = Integer, V = Member
	private HashMap<Integer, Member> hashMap;
	//int의 wrapper class: Integer
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	public void addMember(Member member) {
		//collection에서는 add
		hashMap.put(member.getMemberId(),member);
	}
	public boolean removeMember(int memberId) {
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return true;
		}
		System.out.println("no element");
		return false;
	}
	public void showAllMember() {
		//map의 key와 value 중 하나를 택해서 Iterator를 사용
		Iterator<Integer> ir = hashMap.keySet().iterator();
		//iterator를 안쓰고 바로 toString을 해도됨.
		while(ir.hasNext()) {
			int key = ir.next();
			Member member = hashMap.get(key);
			System.out.println(key+" : "+member);
		}
	}
	public void showHashMap() {
		System.out.println(hashMap);
	}
}
