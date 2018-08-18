package dynamic;

import java.util.Scanner;

public class N2159_CakeDelivery {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int l=100000;
		int n=in.nextInt();
		int[][] loca=new int[n+1][2];
		for(int i=0;i<=n;i++) {
			loca[i][0]=in.nextInt();
			loca[i][1]=in.nextInt();
		}
		
		int[] kx= {0,0,0,-1,1}, ky= {0,-1,1,0,0};
		long[][] d=new long[n+1][5];
		for(int j=0;j<5;j++) {
			d[1][j]=Math.abs(loca[1][0]-loca[0][0]+kx[j])+Math.abs(loca[1][1]-loca[0][1]+ky[j]);
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<5;j++) {
				int x = loca[i][0] + kx[j];
				int y = loca[i][1] + ky[j];
				if(x<1||x>l||y<1||y>l) {
					d[i][j]=-1;
					continue;
				}
				for(int k=0;k<5;k++) {
					if(d[i-1][k]==-1) continue; 
					long temp=Math.abs(x-loca[i-1][0]-kx[k])+Math.abs(y-loca[i-1][1]-ky[k])+d[i-1][k];
					if(d[i][j]==0||d[i][j]>temp) d[i][j]=temp;
				}
			}	
		}
		
		long answer=d[n][0];
		for(int i=1;i<5;i++) {
			if(answer>d[n][i])answer=d[n][i];
		}
		System.out.println(answer);
		in.close();
	}
	
}
