package fastcampus.javaSpring.chapter06.ch08Exception;
public class Try_Catch {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		//배열의 크기를 벗어난 경우: ArrayIndexOutOfBoundsException(예외처리를 하지 않으면 시스템 정지)
		try {
			for(int i = 0; i<=5;i++) {
				System.out.print(arr[i]+" ");
			}			
		}
		catch(ArrayIndexOutOfBoundsException e ) {
			System.out.println(e.getMessage());
			System.out.println("=====================");
			System.out.println(e.toString());
			System.out.println("=====================");
			e.printStackTrace();
		}
		//에러가 발생해도 비정상 종료는 일어나지 않는다. 
		System.out.println("after try-catch");
	}
}