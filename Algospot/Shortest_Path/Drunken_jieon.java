package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Drunken {
	static int v;
	static int[] delay;
	static int[][] adj, W;
	
	static void solve() {
		ArrayList<Integer> order=new ArrayList<>();
		for(int i=1;i<=v;i++) order.add(i);
		order.sort(new Comparator<Integer>() {
			public int compare(Integer p1, Integer p2) {
				return Integer.compare(delay[p1], delay[p2]);
			}
		});
		
		for(int i=1;i<=v;i++)
			for(int j=1;j<=v;j++)
				if(i==j)
					W[i][j]=0;
				else
					W[i][j]=adj[i][j];
		for(int k=0;k<v;k++) {
			int w=order.get(k);
			for(int i=1;i<=v;i++)
				for(int j=1;j<=v;j++) {
					adj[i][j]=Math.min(adj[i][j], adj[i][w]+adj[w][j]);
					W[i][j]=Math.min(adj[i][w]+delay[w]+adj[w][j],W[i][j]);
				}
		}				
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		v=in.nextInt();
		int e=in.nextInt();
		delay=new int[v+1];
		for(int i=1;i<=v;i++) 
			delay[i]=in.nextInt();
		adj=new int[v+1][v+1];
		for(int i=0;i<=v;i++) {
			Arrays.fill(adj[i], 1000000000);
			adj[i][i]=0;
		}
		for(int i=0;i<e;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			int c=in.nextInt();
			adj[a][b]=adj[b][a]=c;
		}
		
		W=new int[v+1][v+1];
		solve();
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			System.out.println(W[a][b]);
		}
		
		in.close();
	}

}
