package fastcampus.javaSpring.chapter05.ch13Set_TreeSet;

import java.util.Comparator;

public class Member implements Comparator<Member>, Comparable<Member>{
	private int memberId;
	private String memberName;
	//Comparator사용을 위한 default constructor
	public Member() {
	}
	public Member(int memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	//중복값 확인을 위한 override: 가상메모리 주소가 아닌 class의 데이터를 기준으로
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(this.memberId==member.memberId)
				return true;
			else return false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return memberId;
	}
	//toString
	@Override
	public String toString() {
		return memberName+" 회원님의 이이디는 "+memberId+"입니다.";
	}

	//Comparable interface 구현하는 경우
	//generic을 설정하면 자동으로 parameterType이 설정됨.
	// JDK Library에서 호출하는 method
	@Override
	public int compareTo(Member member) {
		//비교대상과 tree의 값을 비교해 비교대상이 더 크면 양수, 작으면 음수, 같으면 0을 반환해 오름차순으로 정렬한다
		if(this.memberId>member.memberId) {
			System.out.println("bigger");
			return 1;			
		}
		else if(this.memberId<member.memberId) {
			System.out.println("smaller");
			return -1;
		}
		else {
			System.out.println("same");
			return 0;//중복값으로 입력 x
		}
		//내림차순을 하려면 if문의 조건을 반대로하면 된다
		//3항연산자
//		return (this.memberId-member.memberId >0 ? 1 : (this.memberId-member.memberId==0 ? 0 : -1));
		//수는 상관없고 부호가 중요하기 때문에 아래도 가능
//		return (this.memberId-member.memberId);
	}

	//Comparator interface를 구현하는 경우
	@Override
	public int compare(Member member1, Member member2) {
		return (member1.memberId - member2.memberId);
	}

}
