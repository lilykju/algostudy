package a;

import java.util.Scanner;

public class Ed48_DeathNote {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int r=0;
		int a;
		int[] ans=new int[n];
		for(int i=0;i<n;i++) {
			a=in.nextInt();
			if(r!=0) {
				if(r<=a) {
					ans[i]=1;
					a-=r;
					r=0;
				}else {
					r-=a;
					a=0;
					continue;
				}
			}
			ans[i]+=a/m;
			r=m-a%m;
			if(r==m) r=0;
		}
		
		for(int i=0;i<n;i++)
			System.out.print(ans[i]+" ");

		in.close();
	}
}
