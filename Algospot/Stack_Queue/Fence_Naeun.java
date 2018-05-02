package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Fence {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] f=new int[n+2];
			Stack<Integer> stack=new Stack<>();
			f[0]=-1;
			for(int i=1;i<=n;i++) {
				f[i]= in.nextInt();
			}
			f[n+1]=0;
			stack.push(0);
			int max=0;
			for(int i=1;i<=n+1;i++) {
				while(f[stack.peek()]>=f[i]) {
					int temp=f[stack.pop()]*(i-stack.peek()-1);
					if(temp>max) max=temp;
				}
				stack.push(i);
			}
			System.out.println(max);
		}
		in.close();
	}
}
