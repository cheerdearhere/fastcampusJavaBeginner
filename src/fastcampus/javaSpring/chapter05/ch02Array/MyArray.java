package fastcampus.javaSpring.chapter05.ch02Array;

public class MyArray {
	int[] intArr; //int array
	int count; //array.size
	String m="";//print array
	
	public int ARRAY_SIZE;
	public static final int ERROR_NUM = -999999999;
	
	public MyArray() {
		count=0;//자료가 입력된 index
		ARRAY_SIZE = 10;//최대 사이즈
		intArr = new int[ARRAY_SIZE];
		//배열을 호출할때 최대 사이즈를 준비하지만 모두 사용하지는 않음 
	}
	public MyArray(int size) {
		count=0;
		ARRAY_SIZE = size;
		intArr = new int[ARRAY_SIZE];
	}
	//배열의 마지막에 입력하기
	public void addElement(int num) {
		if(count>=ARRAY_SIZE) {
			System.out.println("not enough memory");
			return;
		}
		intArr[count++]=num;
	}
	//배열의 중간에 입력하기
	public void insertElement(int position, int num) {
		int i;
		//array is full
		if(count>=ARRAY_SIZE) {
			System.out.println("not enough memory");
			return;
		}
		//index error
		if(position<0||position>count) {
			System.out.println("insert Error");
			return;
		}
		//배열을 한칸씩 밀어 공간을 확보하고 데이터 입력
		for(i=count-1;i>=position;i--) {
			intArr[i+1]=intArr[i];
		}
		intArr[position]=num;
		count++;
	}
	//배열의 요소를 제거하기
	public int removeElement(int position) {
		int ret=ERROR_NUM;
		//null 처리
		if( isEmpty() ) {
			System.out.println("There is no element");
			return ret;
		}
		//index error
		if(position<0||position>=count) {
			System.out.println("remove error");
			return ret;
		}
		//오류일때는 ERROR_NUM, 정상작동일때는 삭제된 data 표시
		ret=intArr[position];
		for(int i = position;i<count-1;i++) {
			intArr[i]=intArr[i+1];
		}
		count--;
		return ret;
	}
	
	public int getSize() {
		return count;
	}
	public boolean isEmpty() {
		if(count==0) {
			return true;
		}
		else return false;
	}
	public int getElement(int position) {
		if(position<0||position<count-1) {
			System.out.println("검색 위치 오류: 현재 리스트의 개수는 "+count+"개 입니다.(입력값: "+position+")");
			return ERROR_NUM;
		}
		return intArr[position];
	}

	public void printAll() {
		if(count==0) {
			System.out.println("출력할 내용이 없습니다.");
			return;
		}
		m = "My array: ";
		for(int i=0;i<count;i++) {
			m+=intArr[i]+"/";
		}
		System.out.println(m);
	}
}