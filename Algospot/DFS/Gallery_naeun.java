package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gallery {
	
	static final int UNWATCHED =0, WATCHED=1, INSTALLED=2;
	static List<Integer>[] adj;
	static int installed;
	static boolean[] visited;
	
	static int dfs(int here) {
		visited[here]=true;
		int[] children= {0,0,0};
		for(int i=0;i<adj[here].size();i++) {
			int there=adj[here].get(i);
			if(!visited[there])
				++children[dfs(there)];
		}
		
		if(children[UNWATCHED]!=0) {
			++installed;
			return INSTALLED;
		}
		if(children[INSTALLED]!=0)
			return WATCHED;
		return UNWATCHED;
	}
	
	static int installCamera(int g) {
		installed=0;
		visited=new boolean[g];
		for(int u=0;u<g;u++) {
			if(!visited[u]&&dfs(u)==UNWATCHED)
				installed++;
		}
		return installed;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		while(t-->0) {
			int g=in.nextInt();
			int h=in.nextInt();
			adj=(List<Integer>[])new List[g];
			for(int i=0;i<g;i++)
				adj[i]=new ArrayList<>();
			for(int i=0;i<h;i++) {
				int a=in.nextInt(), b=in.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			
			System.out.println(installCamera(g));
		}
		in.close();
	}
}
