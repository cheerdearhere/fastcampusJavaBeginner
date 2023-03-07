package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
 * There is a queue for the self-checkout tills at the supermarket. 
 * Your task is write a function to calculate the total time required for all the customers to check out!

 * input
 * customers: an array of positive integers representing the queue. 
 * Each integer represents a customer, and its value is the amount of time they require to check out.
 * n: a positive integer, the number of checkout tills.
 * output
 * The function should return an integer, the total time required.

 * Important
 * Please look at the examples and clarifications below, to ensure you understand the task correctly :)

 * Examples
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times

 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the 
 * // queue finish before the 1st person has finished.

 * queueTime([2,3,10], 2)
 * // should return 12
 * Clarifications
 * There is only ONE queue serving many tills, and
 * The order of the queue NEVER changes, and
 * The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
 * N.B. You should assume that all the test input will be valid, as specified above.
*/
public class SupermarketQueue {

	public static void main(String[] args) {
		SolutionTest.assertEquals(0, solveSuperMarketQueue(new int[] {}, 1));
		SolutionTest.assertEquals(12, solveSuperMarketQueue(new int[] {5,3,4}, 1));
		SolutionTest.assertEquals(10, solveSuperMarketQueue(new int[] {10,2,3,4}, 2));
		SolutionTest.assertEquals(12, solveSuperMarketQueue(new int[] {2,3,10}, 2));
		SolutionTest.assertEquals(15, solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
	}
	public static int solveSuperMarketQueue(int[] customers, int till) {
		int[] regi = new int[till];
		for(int i:customers)
			regi[smallestIndex(regi)]+=i;
		return regi[biggestIndex(regi)];
	}
	private static int smallestIndex(int[] arr) {
		int index=0;
		for(int i=0;i<arr.length;i++)
			if(arr[index]>arr[i])
				index=i;
		return index;
	}
	private static int biggestIndex(int[] arr) {
		int index=0;
		for(int i=0;i<arr.length;i++)
			if(arr[index]<arr[i])
				index=i;
		return index;
	}
//다른 사람 풀이
	//Arrays.sort
	public static int solveSuperMarketQueue1(int[] customers, int n) {
	      int[] result = new int[n];
			  for(int i = 0; i < customers.length; i++){
		    	result[0] += customers[i];
		    	Arrays.sort(result);
		    }
			  return result[n-1];
	    }
	//PriorityQueue
	public static int solveSuperMarketQueue2(int[] customers, int n) {
	    PriorityQueue<Integer> q = new PriorityQueue<>();
	    for (int i = 0; i < n; i++)
	      q.add(0);//창구 수만큼 q적용
	    for (int t : customers)
	      q.add(q.remove() + t);//처리 시간 
	    return Collections.max(q);//
	  }
	//다수의 메서드로 사용
	public static int solveSuperMarketQueue3(int[] customers, int n) {
        initialize(customers, n);
        while(anyCustomersLeft()) {
            assignCustomersToAllFreeTills();
            progressTime();
        }
        while(anyTillHasCustomer()){
            progressTime();
        }
        return time;
    }
	private static List<Integer> tills;
    private static int time;
    private static List<Integer> queue;
    private static void initialize(int[] customers, int n){
        tills = new ArrayList<>(Collections.nCopies(n, 0));
        queue = new ArrayList<>();
        IntStream.range(0, customers.length).forEach(i -> queue.add(customers[i]));
        time = 0;
    }
    
    private static void assignCustomersToAllFreeTills(){
        OptionalInt freeTill = findFreeTill();
        while(anyCustomersLeft() && freeTill.isPresent()){
            assignNextCustomerToTill(freeTill.getAsInt());
            freeTill = findFreeTill();
        }
    }

    private static boolean anyCustomersLeft(){
        return !queue.isEmpty();
    }

    private static OptionalInt findFreeTill(){
        return IntStream.range(0, tills.size()).filter(i -> tills.get(i) == 0).findFirst();
    }

    private static void assignNextCustomerToTill(int tillNumber){
        tills.set(tillNumber, queue.get(0));
        queue.remove(0);
    }

    private static void progressTime(){
        IntStream.range(0, tills.size()).filter(till -> isTillNotEmpty(till)).forEach(till -> decreaseTillTime(till));
        time++;
    }

    private static boolean isTillNotEmpty(int tillNumber){
        return tills.get(tillNumber) != 0;
    }

    private static void decreaseTillTime(int tillNumber){
        tills.set(tillNumber, tills.get(tillNumber) - 1);
    }

    private static boolean anyTillHasCustomer(){
        return tills.stream().anyMatch(i -> i!=0);
    }
    //PriorityQueue, EnhacedFor
    public static int solveSuperMarketQueue4(int[] customers, int n) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.nCopies(n, 0));
        for (int customer : customers) queue.add(queue.poll() + customer);
        return Collections.max(queue);
    }
}