package stack;

import java.util.Scanner;
import java.util.Stack;

public class N2879_CodingPret {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] line=new int[n];
		Stack<Integer> st=new Stack<>();
		Stack<Integer> ts=new Stack<>();
		for(int i=0;i<n;i++) {
			line[i]=in.nextInt();
		}

		int temp=0;
		for(int i=0;i<n;i++) {
			line[i]=in.nextInt()-line[i];
			if((line[i]>0&&temp<0)||(line[i]<0&&temp>0)) {
				st.push(0);
			}
			temp=line[i];
			st.push(Math.abs(line[i]));
		}
		
		int count=0;
		while(!st.isEmpty()) {
			while(!st.isEmpty()&&st.peek()==0) {
				st.pop();
			}
			if(st.isEmpty()) break;
			while(!st.isEmpty()&&st.peek()!=0) {
				ts.push(st.pop()-1);
			}
			count +=1;
			while(!ts.isEmpty()) {
				st.push(ts.pop());
			}
		}
		
		System.out.println(count);
		in.close();
	}
	
	
	/*
	 * int res = 0;
		for (int i = 1; i <= N + 1; i++) {
			if (arr[i] - arr[i - 1] > 0) {
				res = res + arr[i] - arr[i - 1];
			}
		}
	 * 
	 * */
}
