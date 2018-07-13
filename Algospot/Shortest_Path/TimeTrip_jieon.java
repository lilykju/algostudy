package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeTrip {
	
	int INF=Integer.MAX_VALUE;
	int v;
	
	List<Edge>[] graph;
	boolean[][] reachable;
	
	long bellman2(int s, int target,boolean mode) {
		
		long[] upper=new long[v];
		Arrays.fill(upper, INF);
		upper[s] =0;
		
		for(int k=0;k<v-1;k++) {
			for(int here=0;here<v;here++) {
				for(Edge e: graph[here]) {
					int there=e.end;
					int cost=e.cost;
					if(mode) cost=-cost;
					upper[there]=Math.min(upper[there], upper[here]+cost);
				}
			}
		}
		for(int here=0;here<v;here++)
			for(Edge e:graph[here]) {
				int there=e.end;
				int cost=e.cost;
				if(mode) cost=-cost;
				if(upper[here]+cost<upper[there]) {
					//here는 음수사이클에 들어있다.
					if(reachable[s][here]&&reachable[here][target])
						return -INF;	
				}
			}
		
		return upper[target];
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] s=br.readLine().split(" ");
			int g=Integer.parseInt(s[0]);
			int w=Integer.parseInt(s[1]);
			TimeTrip tt=new TimeTrip();
			tt.v=g;
			tt.reachable=new boolean[g][g];
			tt.graph=(List<Edge>[])new List[g];
			for(int i=0;i<g;i++)
				tt.graph[i]=new ArrayList<>();
			for(int i=0;i<w;i++) {
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				int d=Integer.parseInt(s[2]);
				tt.graph[a].add(new Edge(b,d));
				tt.reachable[a][b]=true;
			}
			
			for(int k=0;k<g;k++)
				for(int i=0;i<g;i++) {
					for(int j=0;j<g;j++) {
						if(tt.reachable[i][j]) {
							for(Edge e:tt.graph[j]) {
								tt.reachable[i][e.end]=true;
							}
						}
				}
			}
	
			long ans=tt.bellman2(0, 1, false);
			if(ans==-tt.INF) System.out.print("INFINITY ");
			else if(ans==tt.INF) {
				System.out.println("UNREACHABLE");
				continue;
			}else System.out.print(ans+" ");
	
			ans=tt.bellman2(0, 1, true);
			if(ans==-tt.INF) System.out.println("INFINITY");
			else System.out.println(-ans);
			
		}
	}
}
