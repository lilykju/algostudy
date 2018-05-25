package graph;

import java.util.Scanner;

public class N1005_ACMCraft {

	static int n;
	static boolean[][] graph;
	static boolean[] check;
	static int[] time;
	
	static int dfs(int x) {
		if(check[x]) return time[x];
		check[x]=true;
		int max=0;
		for(int next=1;next<=n;next++) {
			if(graph[next][x]) {
				int temp=dfs(next);
				if(temp>max) max=temp;
			}
		}
		return time[x]=time[x]+max;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			n=in.nextInt();
			int k=in.nextInt();
			check=new boolean[n+1];
			time=new int[n+1];
			for(int i=1;i<=n;i++) {
				time[i]=in.nextInt();
			}
			graph=new boolean[n+1][n+1];
			while(k-->0) {
				graph[in.nextInt()][in.nextInt()]=true;
			}
			int w=in.nextInt();
			System.out.println(dfs(w));
		
		}
		in.close();
	}
}
