package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
	int end;
	int cost;

	Edge(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
}
public class FireTrucks {

	static List<Edge>[] graph;
	static int[] time;
	static boolean[] visit;
	
	static void dijkstra(int start) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer> (){
			public int compare(Integer one, Integer two) {
				return Integer.compare(time[one], time[two]);
			}
		});
		time[start]=0;
		pq.add(start);
		while(!pq.isEmpty()) {
			int x=pq.poll();
			if(visit[x]) continue;
			for(Edge e:graph[x]) {
				if(!visit[e.end]) {
					if(time[e.end] == -1 || time[e.end] > (time[x] + e.cost))
						time[e.end] = time[x] + e.cost;
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
			int v=Integer.parseInt(s[0]);
			int e=Integer.parseInt(s[1]);
			graph=(List<Edge>[])new List[v+1];
			for(int i=1;i<=v;i++)
				graph[i]=new ArrayList<>();
			
			int n=Integer.parseInt(s[2]);
			int m=Integer.parseInt(s[3]);
			
			for(int i=0;i<e;i++) {
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				int c=Integer.parseInt(s[2]);
				graph[a].add(new Edge(b,c));
				graph[b].add(new Edge(a,c));
			}
			
			int[] place=new int[n];
			int[] station=new int[m];
			s=br.readLine().split(" ");
			for(int i=0;i<n;i++)
				place[i]=Integer.parseInt(s[i]);
			s=br.readLine().split(" ");
			for(int i=0;i<m;i++)
				station[i]=Integer.parseInt(s[i]);
			time=new int[v+1];
			Arrays.fill(time, -1);
			for(int i=0;i<m;i++) {
				visit=new boolean[v+1];
				dijkstra(station[i]);
			}
			int answer=0;
			for(int i=0;i<n;i++)
				answer+=time[i];
			
			System.out.println(answer);
		}
	}
}
