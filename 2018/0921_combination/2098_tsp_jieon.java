package search;

import java.util.Scanner;

public class N2098_tsp {
	
	static int n;
	static int[][] W;
	static int[][] d;
	
	static int dp(int here, int visited) {
		if(visited==(1<<n)-1) { 
			if(W[here][0]==0) return 987654321;
			return W[here][0];
		}
		
		if(d[here][visited]!=0) return d[here][visited];
		int ret=987654321;
		for(int next=0;next<n;next++) {
			if((visited & (1<<next))!=0 || W[here][next]==0) continue;
			ret = Math.min(ret, dp(next,visited|(1<<next))+W[here][next]);
		}
		return d[here][visited]=ret;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		W=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				W[i][j]=in.nextInt();
		in.close();
		d=new int[n][1<<n];
		
		System.out.println(dp(0,1));
		
	}
	
	//å
	
	
}
