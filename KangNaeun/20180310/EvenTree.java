package graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EvenTree {
	
	static List<Integer>[] a;
	
	static int recursionTree(int[] d, int node, int from) {
		d[node]=1;
		if(a[node].size()==1) return 0;
		int count=0;
		for(int i=0;i<a[node].size();i++) {
			int to=a[node].get(i);
			if(to==from) continue;
			//자바는 배열주소 
			count += recursionTree(d, to, node);
			d[node]+=d[to];
		}
		if(d[node]%2==0) count++;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = (List<Integer>[]) new List[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		int[] d=new int[n+1];
		System.out.println(recursionTree(d, 1, 1)-1);
		sc.close();
	}
}
