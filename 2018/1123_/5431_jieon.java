package study;

import java.util.Scanner;

public class N5431_HwCheck {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int TC=in.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int n=in.nextInt();
			int m=in.nextInt();
			boolean[] submit=new boolean[n+1];
			for(int i=0;i<m;i++) {
				submit[in.nextInt()]=true;
			}
			
			System.out.print("#"+tc);
			for(int i=1;i<=n;i++) {
				if(!submit[i])
					System.out.print(" "+i);
			}
			System.out.println();
		}
		in.close();
	}

}
