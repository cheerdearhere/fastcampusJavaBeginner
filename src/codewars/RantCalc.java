package codewars;
/*
Every day you rent the car costs $40. 
If you rent the car for 7 or more days, you get $50 off your total. 
Alternatively, if you rent the car for 3 or more days, you get $20 off your total.

Write a code that gives out the total amount for different days(d).
*/
public class RantCalc {
	public static void main(String[] args) {
		SolutionTest.assertEquals(40, rentalCarCost(1));
		SolutionTest.assertEquals(80, rentalCarCost(2));
		SolutionTest.assertEquals(100, rentalCarCost(3));
		SolutionTest.assertEquals(140, rentalCarCost(4));
		SolutionTest.assertEquals(180, rentalCarCost(5));
		SolutionTest.assertEquals(220, rentalCarCost(6));
		SolutionTest.assertEquals(230, rentalCarCost(7));
		SolutionTest.assertEquals(270, rentalCarCost(8));
		SolutionTest.assertEquals(310, rentalCarCost(9));
		SolutionTest.assertEquals(350, rentalCarCost(10));
	}
	public static int rentalCarCost(int d) {
		int cost=0;
		if(d<=0)
			cost=0;
		cost=d*40;
		if(d>=3&&d<7) 
			cost-=20;
		else if(d>=7) 
			cost-=50;
		return cost; 
	}
//다른사람 풀이
	//상수로 선언하고 if문(음수에 대한 대비x)
	private static final int COST_PER_DAY = 40;
	public static int rentalCarCost1(int d) {
	  if (d < 3)       return d * COST_PER_DAY;
	  else if (d >= 7) return d * COST_PER_DAY - 50;
	  else             return d * COST_PER_DAY - 20;
	}
	//삼항연산자(?)를 연속으로 사용
	public static int rentalCarCost2(int d) {
	    return d < 7 ? d < 3 ? 40 * d : 40 * d - 20 : 40 * d - 50;
	    // return (d * 40) - (d >= 7 ? 50 : (d >= 3 ? 20 : 0));
	  }
	//switch-case문
	 public static int rentalCarCost3(int d) {
		    int x = 40;
		   
		    switch (d) {
		    
		      case 0: case 1: case 2:
		      return d * x;
		    
		      case 3: case 4: case 5: case 6:
		      return (x * d) - 20;    
		  
		      default: return (x * d) - 50;
		    }
		  }
	//discount를 따로 설정해서 조건문으로 지정
	 static final int PRICE_PER_DAY = 40;
	public static int rentalCarCost4(int d) {
	    
	    int totalPrice = PRICE_PER_DAY * d;
	    
	    int discount = 0;
	    if (d >=7) discount = 50;
	    else if (d>=3) discount = 20;
	    
	    return totalPrice - discount;
	}
}