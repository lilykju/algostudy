package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.PriorityQueue;


class Edge {
	//public int start;
	public int end;
	public int cost;

	public Edge() {
		this(0, 0);
	}

	public Edge(int end, int cost) {
		//this.start = start;
		this.end = end;
		this.cost = cost;
	}
}
/*
class Compare implements Comparator<Edge> {
	public int compare(Edge one, Edge two) {
		return Integer.compare(one.cost, two.cost);
	}
}*/
public class JeanieRoute {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int l = in.nextInt();
		ArrayList<Integer> letter = new ArrayList<>();
		int[][] ctc = new int[n+1][n+1];
		
		for(int i=0;i<l;i++) {
			letter.add(in.nextInt());
		}
		int[] check = new int[n+1];
		for(int i=0;i<n-1;i++) {
			int u=in.nextInt();
			int v=in.nextInt();
			int cost=in.nextInt();
			ctc[u][v]=ctc[v][u]=cost;	
			check[u]++;
			check[v]++;
		}
		
		boolean[] c=new boolean[n+1];
		for(int k=1;k<=n;k++) {
			if(letter.contains(k)) continue;
			for(int i=1; i<=n; i++) {
				if(ctc[k][i]==0||c[k]) continue;
				for(int j=1; j<=n; j++) {
					if(ctc[k][j]==0||i==j||c[k]) continue;
					ctc[i][j]=ctc[j][i]=ctc[k][j]+ctc[k][i];
				}
			}
			c[k]=true;
		}
		
		@SuppressWarnings("unchecked")
		List<Edge>[] path = (List<Edge>[])new List[l];
		for(int i=0;i<l;i++) {
			path[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<l;i++) {
			for(int j=i+1;j<l;j++) {				
				if(ctc[letter.get(i)][letter.get(j)]==0)continue;
				path[i].add(new Edge(j,ctc[letter.get(i)][letter.get(j)]));
				path[j].add(new Edge(i,ctc[letter.get(i)][letter.get(j)]));
			}
		}
		
		//d аж╪р
		int[][] d=new int[l][1<<l];
		int min=Double.MAX_EXPONENT;
		int togo=(1<<l)-1;
		System.out.println(" togo:"+togo);
		for(int i=0;i<l;i++) {
			togo &=~(1<<i);
			int temp = go(path, d, i, togo);
			togo |= (1<<i);
			if(min>temp) min=temp;
		}
		
		System.out.println(min);
		
		in.close();
    }
	
	static int go(List<Edge>[] path, int[][] d,int start,int togo) {	
		System.out.println("start:"+start+" togo:"+togo);
		if(togo==0) return 0;
		if(d[start][togo]!=0) return d[start][togo];
		if(path[start].size()==1) {
			int to=path[start].get(0).end;
			if((togo&(1<<to))!=0) togo &=~(1<<to);
			return path[start].get(0).cost+go(path, d, to, togo);
		}
		int min=Double.MAX_EXPONENT;
		for(Edge e:path[start]) {	
			int temp=0;
			if((togo&(1<<e.end))!=0) {
				togo &=~(1<<e.end);
				temp = e.cost+go(path, d, e.end, togo);
				togo |= (1<<e.end);
			}else {
				temp = e.cost+go(path, d, e.end, togo);
			}
			if(temp<min) temp = min;
		}
		
		return min;
	}
	
	
	
}
