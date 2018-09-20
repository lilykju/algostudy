package search;

import java.util.Scanner;

public class N10714_cake {
	
	static int n;
	static int[] piece;
	static long[][] d;
	
	static long eat(int num, int left, int right) {
		if(left==-1) left=n-1;
		if(right==n) right=0;
		if(num==n) return (num%2==1)?piece[left]:0;
		if(d[left][right]!=0) return d[left][right];
		long ret=0;
		if(num%2==1) ret=Math.max(eat(num+1,left-1,right)+piece[left], eat(num+1,left,right+1)+piece[right]);
		else if(piece[left]>piece[right]) ret=eat(num+1,left-1,right);
		else return ret=eat(num+1,left,right+1);
		return d[left][right]=ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		piece=new int[n];
		for(int i=0;i<n;i++)
			piece[i]=in.nextInt();
		in.close();
		d=new long[n][n];
		
		long answer=0;
		for(int i=0;i<n;i++) {
			answer = Math.max(answer, eat(2,i-1,i+1)+piece[i]);
		}
		
		System.out.println(answer);
		
	}
}
