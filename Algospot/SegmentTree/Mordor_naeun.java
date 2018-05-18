package Tree;

import java.util.Scanner;

public class Mordor {
	
	final static int INT_MIN=Integer.MIN_VALUE;
	static int[] rangeValue;
	
	static int init(int[] arr, int left, int right, int node) {
		if(left==right) return rangeValue[node]=arr[left];
		int mid=(left+right)/2;
		int leftValue=init(arr,left,mid,node*2+1);
		int rightValue=init(arr,mid+1,right,node*2+2);
		return rangeValue[node]=Math.max(leftValue,rightValue);
	}
	
	static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right<nodeLeft||nodeRight<left) return INT_MIN;
		//System.out.println(left+" "+right+" "+node+" "+nodeLeft+" "+nodeRight);
		if(left<=nodeLeft&&nodeRight<=right) return rangeValue[node];
		int mid=(nodeLeft+nodeRight)/2;
		
		return Math.max(query(left,right, node*2+1, nodeLeft, mid), 
				query(left, right, node*2+2, mid+1, nodeRight));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n=in.nextInt();
			int q=in.nextInt();
			int[] low=new int[n*4];
			int[] high=new int[n*4];
			rangeValue=new int[n*4];
			for(int i=0;i<n;i++) {
				high[i]=in.nextInt();
				low[i]=-high[i];
			}
			init(high,0,n-1,0);
			int[][] Q=new int[q][2];
			int[] diff=new int[q];
			for(int i=0;i<q;i++) {
				Q[i][0]=in.nextInt();
				Q[i][1]=in.nextInt();
				diff[i]=query(Q[i][0],Q[i][1],0,0,n-1);
			}
			rangeValue=new int[n*4];
			init(low,0,n-1,0);
			for(int i=0;i<q;i++) {
				diff[i]+=query(Q[i][0],Q[i][1],0,0,n-1);
			}
			for(int i=0;i<q;i++) {
				System.out.println(diff[i]);
			}
		}
		in.close();
	}
}
