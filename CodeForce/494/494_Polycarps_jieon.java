package a;

import java.util.Scanner;

public class R494_Polycarps {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] a=new int[101];
		int n=in.nextInt();
		int ans=0;
		for(int i=0;i<n;i++) {
			int k=in.nextInt();
			a[k]++;
			ans=Math.max(ans, a[k]);
		}
		System.out.println(ans);
		in.close();
	}
}
