package tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N11286_AbsHeap {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if(Math.abs(a)!=Math.abs(b)) return Integer.compare(Math.abs(a), Math.abs(b));
				return Integer.compare(a, b);
			}
		});
		
		//(a,b)->{return Math.abs(a)==Math.abs(b)?(a-b):(Math.abs(a)-Math.abs(b));}
		int answer=0;
		while(n-->0) {
			int query=in.nextInt();
			if(query!=0) {
				pq.add(query);
			}
			else {
				if(pq.isEmpty()) answer=0;
				else answer=pq.poll();
				
				System.out.println(answer);
			}
		}
		in.close();
	}
}
