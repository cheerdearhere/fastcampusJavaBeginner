package playground;

import java.util.Arrays;
import java.util.stream.Stream;

/*Our football team has finished the championship.

Our team's match results are recorded in a collection of strings.
Each match is represented by a string in the format "x:y", 
where x is our team's score and y is our opponents score.

For example: ["3:1", "2:2", "0:1", ...]

Points are awarded for each match as follows:

if x > y: 3 points (win)
if x < y: 0 points (loss)
if x = y: 1 point (tie)
We need to write a function that takes this collection 
and returns the number of points our team (x) got in the championship
 by the rules given above.

Notes:
our team always plays 10 matches in the championship
0 <= x <= 4
0 <= y <= 4
*/
public class TotalSoccerPoint {

	public static void main(String[] args) {	
		SolutionTest.assertEquals(30, points(new String[]
                 {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));
             
		SolutionTest.assertEquals(10, points(new String[]
                 {"1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"}));
             
		SolutionTest.assertEquals(0, points(new String[]
                 {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));

		SolutionTest.assertEquals(15, points(new String[]
                 {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));
             
		SolutionTest.assertEquals(12, points(new String[]
                 {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));
	}
	public static int points(String[] games) {
		int sum=0;
		int x=0;
		int y=0;
		for(String score:games) {
			String[] scores = score.split(":");
			x=Integer.parseInt(scores[0]);
			y=Integer.parseInt(scores[1]);
			if(x<0||x>5||y<0||y>5) System.out.println("error");
			
			if(x>y)sum+=3;
			else if(x<y)sum+=0;
			else sum+=1;
		}
		return sum;
	}
	//다른 사람 풀이
    public static int points1(String[] games) {
        int sum = 0;
       //Enhanced for
        for (String s : games) {
          char x = s.charAt(0),//index로 바로 호출
               y = s.charAt(2);
          //삼항연산자
          sum += x > y ? 3 : x == y ? 1 : 0;
        }
        
        return sum;
    }
    public static int points2(String[] games) {
        return Arrays.stream(games)//arrays변환
                      .mapToInt(score -> score.charAt(0) - score.charAt(2))//자리수로 찾아서 int로 변환, 점수계산.
                      .map(match -> match > 0 ? 3 : match == 0 ? 1 : 0)//삼항 연산자로 포인트
                      .sum();//합
     }
    public static int points3(String[] games) {//자체 method를 호출
        return Stream.of(games)
                  .mapToInt(TotalSoccerPoint::scoreMatchResult)
                  .sum();
      }

      private static int scoreMatchResult(String score) {
          String[] split = score.split(":");
          //분할 후 비교, 결과값으로 분기 조정
          int comparison = split[0].compareTo(split[1]);
          if (comparison > 0)
              return 3;
          else if (comparison == 0)
              return 1;
          else
              return 0;
      }
}
