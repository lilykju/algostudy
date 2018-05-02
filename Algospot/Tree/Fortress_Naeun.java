package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Fortress {
	
	static List<Integer>[] tree;
	static int[] x,y,r;
	static int n, longest;
	static boolean[] d;
	
	static int pow(int a) {
		return a*a;
	}
	
	static int powdist(int a,int b) {
		return pow(x[a]-x[b])+pow(y[a]-y[b]);
	}
	
	static boolean encloses(int a,int b) {
		return r[a]>r[b] && powdist(a,b) < pow(r[a]-r[b]);
	}
	
	static boolean isChild(int p,int c) {
		if(!encloses(p,c)) return false;
		for(int i=1;i<n;i++) {
			if(i!=p&&i!=c&&encloses(p,i)&&encloses(i,c)) 
				return false;
		}
		return true;
	}
	
	static void getTree(int root) {
		for(int i=1;i<n;i++) {
			if(!d[i]&&isChild(root,i)) {
				tree[root].add(i);
				d[i]=true;
			}
		}
		for(int next:tree[root]) {
			getTree(next);
		}
	}
	
	static int height(int node) {
		if(tree[node].size()==0) return 0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i:tree[node]) {
			pq.add(-height(i));
		}
		int top=1-pq.poll();
		int h=top;
		if(!pq.isEmpty()) {
			h+=1-pq.poll();
		}
		if(h>longest) longest=h;
		
		return top;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			n=in.nextInt();
			x=new int[n];
			y=new int[n];
			r=new int[n];
			for(int i=0;i<n;i++) {
				x[i]=in.nextInt();
				y[i]=in.nextInt();
				r[i]=in.nextInt();
			}
			
			tree=(List<Integer>[])new List[n];
			for(int i=0;i<n;i++) tree[i]=new ArrayList<>();
			d=new boolean[n];
			longest=0;
			getTree(0);
			height(0);
			System.out.println(longest);
		}
		in.close();
	}
}
