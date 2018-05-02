package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ites {
	
	static long signal(long A) {
		if(A==0) return 1983;
		return (A * 214013 + 2531011)& 4294967295L;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int k=in.nextInt();
			int n=in.nextInt();
			long A=0;
			Queue<Integer> q=new LinkedList<>();
			int sum=0;
			int answer=0;
			for(int i=0;i<n;i++) {
				A=signal(A);
				int temp= (int)(A%10000+1);
				q.add(temp);
				sum+=temp;
				while(!q.isEmpty()&&sum>k) {
					sum-=q.poll();
				}
				if(sum==k) answer++;
			}
			System.out.println(answer);
		}
		in.close();
	}
}
