package b;

import java.util.Scanner;

public class R506_CreatingContest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] p=new int[n];
		for(int i=0;i<n;i++) 
			p[i]=in.nextInt();
		in.close();
		
		int answer=0;
		int temp=1;
		for(int i=1;i<n;i++) {
			if(p[i]<=p[i-1]*2) {
				temp++;
			}else {
				answer = Math.max(answer, temp);
				temp=1;
			}
		}
		answer = Math.max(answer, temp);
		System.out.println(answer);
	}

}
