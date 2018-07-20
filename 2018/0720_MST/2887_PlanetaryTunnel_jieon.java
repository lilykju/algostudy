package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class planet{
	int idx,x,y,z;
	planet(int i,int a,int b,int c){
		idx=i;
		x=a;
		y=b;
		z=c;
	}
}
public class N2887_PlanetaryTunnel {

	static int n;
	static List<Edge>[] dist;
	
	static int prim() {
		
		boolean[] check=new boolean[n];
		int sum=0;
		PriorityQueue<Edge> pq=new PriorityQueue<>(new Comparator<Edge> (){
			public int compare(Edge a,Edge b) {
				return Double.compare(a.cost, b.cost);
			}
		});
		for(Edge ee:dist[0]) {
			pq.add(ee);
		}
		check[0]=true;
		while(!pq.isEmpty()) {
			Edge e=pq.poll();
			if(check[e.end]) continue;
			sum+=e.cost;
			check[e.end]=true;
			for(Edge ee:dist[e.end]) 
				if(!check[ee.end]) pq.add(ee);

		}
		
		return sum;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		planet[] pls=new planet[n];
		dist=(List<Edge>[])new List[n];

		for(int i=0;i<n;i++) {
			pls[i]=new planet(i,in.nextInt(),in.nextInt(),in.nextInt());
			dist[i]=new ArrayList<>();
		}
		
		Arrays.sort(pls, new Comparator<planet>(){
			public int compare(planet a,planet b) {
				return Integer.compare(a.x, b.x);
			}
		});
		for(int i=1;i<n;i++) {
			dist[pls[i-1].idx].add(new Edge(pls[i].idx,Math.abs(pls[i].x-pls[i-1].x)));
			dist[pls[i].idx].add(new Edge(pls[i-1].idx,Math.abs(pls[i-1].x-pls[i].x)));
		}
	
		Arrays.sort(pls, new Comparator<planet>(){
			public int compare(planet a,planet b) {
				return Integer.compare(a.y, b.y);
			}
		});
		for(int i=1;i<n;i++) {
			dist[pls[i-1].idx].add(new Edge(pls[i].idx,Math.abs(pls[i].y-pls[i-1].y)));
			dist[pls[i].idx].add(new Edge(pls[i-1].idx,Math.abs(pls[i-1].y-pls[i].y)));
		}
		
		Arrays.sort(pls, new Comparator<planet>(){
			public int compare(planet a,planet b) {
				return Integer.compare(a.z, b.z);
			}
		});
		for(int i=1;i<n;i++) {
			dist[pls[i-1].idx].add(new Edge(pls[i].idx,Math.abs(pls[i].z-pls[i-1].z)));
			dist[pls[i].idx].add(new Edge(pls[i-1].idx,Math.abs(pls[i-1].z-pls[i].z)));
		}
		
		
		System.out.println(prim());
		in.close();
	}
}
