package Graph;

import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class ed {
	int end;
	double cost;

	ed(int end, double cost) {
		this.end = end;
		this.cost = cost;
	}
}

public class Routing {
	
	static List<ed>[] graph;
	static double[] dist;
	static boolean[] visit;
	
	static void dijkstra(int start,int end) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer> (){
			public int compare(Integer one, Integer two) {
				return Double.compare(dist[one], dist[two]);
			}
		});
		dist[start]=0;
		pq.add(start);
		while(!pq.isEmpty()) {
			int x=pq.poll();
			if(x==end) return;
			if(visit[x]) continue;
			for(ed e:graph[x]) {
				if(!visit[e.end]) {
					if(dist[e.end] == -1 || dist[e.end] > (dist[x] + e.cost))
						dist[e.end] = dist[x] + e.cost;
					pq.add(e.end);
				}
			}
			visit[x]=true;
		}
		
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			graph=(List<ed>[])new List[n];
			for(int i=0;i<n;i++)
				graph[i]=new ArrayList<>();
			
			for(int i=0;i<m;i++) {
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				double c=Double.parseDouble(s[2]);
				graph[a].add(new ed(b,Math.log10(c)));
				graph[b].add(new ed(a,Math.log10(c)));
			}
			dist = new double[n];
			Arrays.fill(dist, -1);
			visit = new boolean[n];
			dijkstra(0,n-1);
			System.out.println(String.format("%012.10f",Math.pow(10, dist[n-1])));
		}
	}
}
