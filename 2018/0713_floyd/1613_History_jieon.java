package graph;

import java.util.Scanner;

public class N1613_History {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[][] adj=new int[n+1][n+1];
		
		for(int i=0;i<k;i++) {
			adj[in.nextInt()][in.nextInt()]=1;
		}
		for(int m=1;m<=n;m++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(adj[i][m]==1&&adj[m][j]==1) 
						adj[i][j]=1;
					
		int s=in.nextInt();
		for(int i=0;i<s;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			if(adj[a][b]==1) System.out.println(-1);
			else if(adj[b][a]==1) System.out.println(1);
			else System.out.println(0);
		}
		
		in.close();
	}
}
