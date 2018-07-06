package b;

import java.util.Scanner;

public class R492_WorldCup {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] p=new int[n];
		for(int i=0;i<n;i++)
			p[i]=in.nextInt();
		int answer=0;
		int time=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int tmp;
			if(p[i]>i) tmp=((p[i]-i)/n+((p[i]-i)%n==0?0:1))*n+i;
			else tmp=i;
			if(tmp<time) {
				time=tmp;
				answer=i;		
			}
		}
		System.out.println(answer+1);
		in.close();
	}
}
