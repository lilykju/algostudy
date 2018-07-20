package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N1647_CitySplitPlan {
	
	static int n;
	static List<Edge>[] city;
	
	static int prim() {
		
		boolean[] check=new boolean[n];
		int sum=0, max=0;
		PriorityQueue<Edge> pq=new PriorityQueue<>(new Comparator<Edge> (){
			public int compare(Edge a,Edge b) {
				return Double.compare(a.cost, b.cost);
			}
		});
		for(Edge ee: city[0]) pq.add(ee);
		check[0]=true;
		while(!pq.isEmpty()) {
			Edge e=pq.poll();
			if(check[e.end]) continue;
			sum+=e.cost;
			if(e.cost>max) max=e.cost;
			check[e.end]=true;
			for(Edge ee:city[e.end]) {
				if(!check[ee.end]) {
					pq.add(ee);
				}
			}
		}
		
		return sum-max;
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int m=in.nextInt();
		city=(List<Edge>[])new List[n];
		for(int i=0;i<n;i++) city[i]=new ArrayList<>();
		for(int i=0;i<m;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			int c=in.nextInt();
			city[a-1].add(new Edge(b-1,c));
			city[b-1].add(new Edge(a-1,c));
		}
		System.out.println(prim());
		in.close();
	}
}
