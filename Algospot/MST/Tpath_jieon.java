package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class eeee{
	int x,y,cost;
	eeee(int a,int b,int c){
		x=a;
		y=b;
		cost=c;
	}
}

public class Tpath {
	static int INF=987654321;
	static int v;
	static List<eeee>[] path;
	static ArrayList<Integer> weights;
	
	static int primLO(int lo) {
		boolean[] check=new boolean[v];
		PriorityQueue<eeee> pq=new PriorityQueue<>(new Comparator<eeee>() {
			public int compare(eeee a,eeee b) {
				return Integer.compare(a.cost, b.cost);
			}
		});
		
		for(eeee ee:path[0]) {
			if(ee.cost>=lo)pq.add(ee);
		}
		check[0]=true;
		
		int hi=-1;
		while(!pq.isEmpty()) {
			eeee e=pq.poll();
			if(check[e.y])continue;
			if(e.cost>hi) hi=e.cost;
			check[e.y]=true;
			if(e.y==v-1)break;
			//System.out.println("pLO: e.y="+e.y+" e.cost="+e.cost);
			for(eeee ee:path[e.y]) 
				if(!check[ee.y]&&ee.cost>=lo) 
					pq.add(ee);
		}
		
		return (check[v-1])? hi:-1;
	}
	
	static int primHI(int lo,int hi) {
		
		boolean[] check=new boolean[v];
		PriorityQueue<eeee> pq=new PriorityQueue<>(new Comparator<eeee>() {
			public int compare(eeee a,eeee b) {
				return Integer.compare(hi-a.cost, hi-b.cost);
			}
		});
		
		for(eeee ee:path[0]) {
			if(ee.cost>lo&&ee.cost<=hi)pq.add(ee);
		}
		check[0]=true;

		int low=0;
		while(!pq.isEmpty()) {
			eeee e=pq.poll();
			if(check[e.y])continue;
			if(low==0||e.cost<low) low=e.cost;
			check[e.y]=true;
			if(e.y==v-1) break;
			for(eeee ee:path[e.y]) 
				if(!check[ee.y]&&ee.cost>lo&&ee.cost<=hi) 
					pq.add(ee);
		}
		
		return (check[v-1])? low:-1;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			v=in.nextInt();
			int e=in.nextInt();
			path=(List<eeee>[])new List[v];
			for(int i=0;i<v;i++) path[i]=new ArrayList<>();
			
			weights=new ArrayList<>();
			for(int i=0;i<e;i++) {
				int a=in.nextInt();
				int b=in.nextInt();
				int c=in.nextInt();
				path[a].add(new eeee(a,b,c));
				path[b].add(new eeee(b,a,c));
				if(!weights.contains(c)) weights.add(c);
			}
			Collections.sort(weights);
			
			int i=0,lo=0,hi=0,ret=INF;
			while(i<weights.size()) {
				lo=weights.get(i);
				hi=primLO(lo);
				//System.out.println("hi: "+hi);
				if(hi==-1) break;
				ret=Math.min(ret, hi-lo);
				lo=primHI(lo,hi);
				//System.out.println("lo: "+lo);
				if(lo==-1) i++;
				else {
					ret=Math.min(ret, hi-lo);
					i=weights.indexOf(lo)+1;
				}
			}
			
			System.out.println(ret);
		}
		in.close();
	}

}
