package d;

import java.util.Scanner;

public class Ed51_Bicoloring {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt(), k=in.nextInt();
		in.close();
		final int mod=998244353;
		int[][][] d=new int[n+1][k+1][2];
		
		for(int i=1;i<=n;i++) {
			d[i][1][0]=1;
			for(int j=2;j<=2*i&&j<=k;j++) {
				if(j==2*i) {
					d[i][j][1]=1;
				}else {
					d[i][j][0]=(((d[i-1][j][1]*2)%mod+d[i-1][j][0])%mod+d[i-1][j-1][0])%mod;
					d[i][j][1]=((d[i-1][j][1]+d[i-1][j-2][1])%mod+(d[i-1][j-1][0]*2)%mod)%mod;
				}
			}
		}
		System.out.println(((d[n][k][1]+d[n][k][0])%mod*2)%mod);
	}

}
