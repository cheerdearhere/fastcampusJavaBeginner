package codewars;

public class ThirdAngleTest {

	public static void main(String[] args) {
		SolutionTest.assertEquals(123, otherAngle(45,12));
		SolutionTest.assertEquals(70, otherAngle(50,60));
	}
	private static int otherAngle(int angle1, int angle2) {
		if(angle1<0||angle2<0)return 0;
		else if(angle1+angle2>=180) return 0;
		return (180-angle1-angle2);
	}
//다른 사람 풀이
	//상수를 선언
	public static final int TRIANGLE_TOTAL_ANGLES_DEGREES = 180;
	public static int otherAngle1(int angle1, int angle2) {
		return TRIANGLE_TOTAL_ANGLES_DEGREES - angle1 - angle2;
	}
	//3항 연산자
	public static int otherAngle2(int angle1, int angle2) {
		int positiveAngle1 = angle1 > 0 ? angle1 : -angle1;
		int positiveAngle2 = angle2 > 0 ? angle2 : -angle2;
		return 180 - positiveAngle1 - positiveAngle2;
    }
}
