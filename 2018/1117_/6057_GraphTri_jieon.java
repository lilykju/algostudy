package study;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class N6057_GraphTri {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int TC=in.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int n=in.nextInt();
			int m=in.nextInt();
		
			boolean[][] edge=new boolean[n+1][n+1];
			for(int i=0;i<m;i++) {
				int a=in.nextInt();
				int b=in.nextInt();
				edge[a][b]=edge[b][a]=true;
			}
			int ans=0;
			for(int i=1;i<=n-2;i++) {
				for(int j=i+1;j<=n-1;j++) {
					if(!edge[i][j])continue;
					for(int k=j+1;k<=n;k++) {
						if(edge[i][k]&&edge[j][k]) ans++;
					}
				}
			}
		

			System.out.println("#"+tc+" "+ans);
		}
		in.close();
	}

}
