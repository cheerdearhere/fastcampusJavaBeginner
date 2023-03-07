package fastcampus.javaSpring.chapter05.ch14Map_HashMap;

public class Member {
	private int memberId;
	private String memberName;
	
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
		return memberName+" 회원님의 아이디는 "+memberId+"입니다.";
	}
}
