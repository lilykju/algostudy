package c;

import java.util.Scanner;

public class R481_Letters {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		
		long[] dorm=new long[n+1];
		long[] sum=new long[n+1];
		long[] room=new long[m];
		long[][] ans=new long[m][2];
		for(int i=1;i<=n;i++) {
			dorm[i]=in.nextLong();
			sum[i]=sum[i-1]+dorm[i];
		}
		int idx=1;
		for(int i=0;i<m;i++) {
			room[i]=in.nextLong();
			for(int j=idx;j<=n;j++) {
				if(room[i]<=sum[j]) {
					ans[i][0]=j;
					ans[i][1]=room[i]-sum[j-1];
					idx=j;
					break;
				}
			}
		}
		for(int i=0;i<m;i++) 
			System.out.println(ans[i][0]+" "+ans[i][1]);
		
		in.close();
	}

}
