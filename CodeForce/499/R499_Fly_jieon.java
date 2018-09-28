package c;

import java.util.Scanner;

public class R499_Fly {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		double answer=m;
		for(int i=0;i<2*n;i++) {
			int a=in.nextInt();
			if(a==1) {
				System.out.println(-1);
				in.close();
				return;
			}
			answer*=a;
			answer/=(a-1);
		}
		
		answer-=m;
		System.out.println(answer);
		in.close();
	}

}
