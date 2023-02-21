package fastcampusJAVA.chapter04.ch02;

public class Student implements Cloneable {
	private int studentNum;
	private String studentName;
	
	public Student(int studentNum, String studentName) {
		this.studentNum=studentNum;
		this.studentName=studentName;
	}
	public String toString() {
		return studentNum+","+studentName;
	}
	
	//equals() method를 논리적으로 같다로 재정의하기
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			//주소값으로 비교하던 원형과 달리 studentNum을 Primary key로 사용
			if(this.studentNum==std.studentNum) 
				return true;
			else return false;
		}
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		return studentNum;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}

}
