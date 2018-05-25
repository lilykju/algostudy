package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Familytree {
	
	final static int INT_MAX=Integer.MAX_VALUE;
	static int[] rangeMin;
	static int[] arr, depth, idx;
	static int k;
	
	static void Preorder(List<Integer>[] tree,int now,int d) {
		depth[now]=d;
		idx[now]=k;
		for(int i=0;i<tree[now].size();i++) {
			arr[k++]=now;
			Preorder(tree,tree[now].get(i),d+1);
		}
		arr[k++]=now;
	}
	
	static int init(int left, int right, int node) {
		if(left==right) return rangeMin[node]=depth[arr[left]];
		int mid=(left+right)/2;
		int leftMin=init(left,mid,node*2+1);
		int rightMin=init(mid+1,right,node*2+2);
		return rangeMin[node]=Math.min(leftMin,rightMin);
	}
	
	static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right<nodeLeft||nodeRight<left) return INT_MAX;
		if(left<=nodeLeft&&nodeRight<=right) return rangeMin[node];
		int mid=(nodeLeft+nodeRight)/2;
		
		return Math.min(query(left,right, node*2+1, nodeLeft, mid), 
				query(left, right, node*2+2, mid+1, nodeRight));
	}
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int q=Integer.parseInt(s[1]);
			
			List<Integer>[] tree=(List<Integer>[])new List[n];
			for(int i=0;i<n;i++) {
				tree[i]=new ArrayList<>();
			}
			s=br.readLine().split(" ");
			for(int i=1;i<n;i++) {
				tree[Integer.parseInt(s[i-1])].add(i);
			}
			k=0;
			rangeMin = new int[8*n];
			arr= new int[2*n];
			depth = new int[n];
			idx = new int[n];
			Preorder(tree,0,0);
			init(0,2*n-2,0);
			
			for(int i=0;i<q;i++) {
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				int h;
				if(idx[a]>idx[b]) h=query(idx[b],idx[a],0,0,2*n-2);
				else h=query(idx[a],idx[b],0,0,2*n-2);
				System.out.println((depth[a]+depth[b]-2*h));
			}
			
		}
	}
}
