package Tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Runningmedian {
	
	static int a,b;
	static int[] num;
	
	static int next(int i) {
		if(i==0) return 1983;
		long x=num[i-1];
		return (int) ((x*a+b)%20090711);
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n=in.nextInt();
			a=in.nextInt();
			b=in.nextInt();
			num=new int[n];
			PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer x,Integer y) {
					return Integer.compare(y, x);
				}
			});
			PriorityQueue<Integer> minHeap=new PriorityQueue<>();
			
			long answer=0;
			for(int i=0;i<n;i++) {
				num[i]=next(i);
				if(i%2==0) {
					if(maxHeap.isEmpty()||minHeap.peek()>=num[i]) {
						maxHeap.offer(num[i]);
					}else {
						maxHeap.offer(minHeap.poll());
						minHeap.offer(num[i]);
					}
				}else {
					if(maxHeap.peek()<=num[i]) {
						minHeap.offer(num[i]);
					}else{
						minHeap.offer(maxHeap.poll());
						maxHeap.offer(num[i]);
					}
				}
				answer= (answer+maxHeap.peek())%20090711;
			}
			
			System.out.println(answer);
		}
		in.close();
	}
}
