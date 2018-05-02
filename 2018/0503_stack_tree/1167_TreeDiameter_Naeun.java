package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge{
	int to,cost;
	Edge(int x,int y){
		to=x;
		cost=y;
	}
}

public class N1167_TreeDiameter {
	static List<Edge>[] tree;
	static int v;
	static boolean[] d;
	static int[] dfs(int x) {
		d[x]=true;
		int[] max= {x,0};
		for(Edge e:tree[x]) {
			if(d[e.to]) continue;
			int[] temp=dfs(e.to);
			if(temp[1]+e.cost>max[1]) {
				max[0]=temp[0];
				max[1]=temp[1]+e.cost;
			}
		}
		//System.out.println("max: "+max[0]+" "+max[1]);
		return max;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		v = in.nextInt();
		tree=(List<Edge>[])new List[v+1];
		d=new boolean[v+1];
		for(int i=1;i<=v;i++) tree[i]=new ArrayList<>();
		for(int i=1;i<=v;i++) {
			int x=in.nextInt();
			while(true) {
				int to=in.nextInt();
				if(to==-1) break;
				int cost=in.nextInt();
				tree[x].add(new Edge(to,cost));
			}
		}
		int root=dfs(1)[0];
		d=new boolean[v+1];
		System.out.println(dfs(root)[1]);
		in.close();
	}
}
