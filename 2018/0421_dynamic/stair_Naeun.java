package dynamic;

import java.util.Scanner;

public class stair {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] s=new int[n+1];
		int[] d=new int[n+1];
		for(int i=1;i<=n;i++) {
			s[i]=in.nextInt();
		}
		d[1]=s[1];
		d[2]=s[1]+s[2];
		for(int i=3;i<=n;i++) {
			d[i]=Math.max(d[i-2]+s[i], d[i-3]+s[i-1]+s[i]);
		}
		
		System.out.println(d[n]);	
		in.close();
	}
}
