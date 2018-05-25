package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class N2623_MusicPro {
	
	static int n;
	static boolean[][] graph;
	static boolean[] check;
	static ArrayList<Integer> order;
	
	static void dfs(int x) {
		check[x]=true;
		for(int next=1;next<=n;next++) {
			if(graph[x][next]&&!check[next])
				dfs(next);
		}
		order.add(x);
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int m=in.nextInt();
		graph=new boolean[n+1][n+1];
		while(m-->0) {
			int k=in.nextInt();
			int a=in.nextInt();
			for(int i=1;i<k;i++) {
				int b=in.nextInt();
				graph[b][a]=true;
				a=b;
			}
		}
		check=new boolean[n+1];
		order=new ArrayList<>();
		
		for(int i=1;i<=n;i++)
			if(!check[i]) dfs(i);
		
		for(int i=0;i<order.size();i++) {
			for(int j=i+1;j<order.size();j++) {
				if(graph[order.get(i)][order.get(j)]) {
					order.clear();
					order.add(0);
				}
			}
		}
		for(int o:order) {
			System.out.println(o);
		}
		
		in.close();
	}
}
