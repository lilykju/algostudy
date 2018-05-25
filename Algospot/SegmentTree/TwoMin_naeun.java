package Tree;

import java.util.Scanner;

public class TwoMin {
	
	final static int INT_MAX=Integer.MAX_VALUE;
	static int[] rangeMin, rangeSpare;
	
	static void init(int[] arr, int left, int right, int node) {
		if(left==right) {
			rangeMin[node]=arr[left];
			rangeSpare[node]=INT_MAX;
			return;
		}
		int mid=(left+right)/2;
		init(arr,left,mid,node*2+1);
		init(arr,mid+1,right,node*2+2);
		rangeMin[node]=Math.min(rangeMin[node*2+1], rangeMin[node*2+2]);
		rangeSpare[node]=Math.min(Math.min(rangeSpare[node*2+1], rangeSpare[node*2+2]), 
				Math.max(rangeMin[node*2+1], rangeMin[node*2+2]));
	}
	
	static int[] query(int left, int right, int node, int nodeLeft, int nodeRight) {
		int[] answer= {INT_MAX,INT_MAX};
		if(left<=nodeLeft&&nodeRight<=right) {
			answer[0]=rangeMin[node];
			answer[1]=rangeSpare[node];
		}else if(nodeLeft<=right&&left<=nodeRight){
			int mid=(nodeLeft+nodeRight)/2;
			int[] leftA=query(left,right, node*2+1, nodeLeft, mid);
			int[] rightA=query(left, right, node*2+2, mid+1, nodeRight);
			answer[0]= Math.min(leftA[0],rightA[0]);
			answer[1]= Math.min(Math.min(leftA[1], rightA[1]), Math.max(leftA[0], rightA[0]));
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int q=in.nextInt();
		int[] arr=new int[3*n];
		rangeMin=new int[3*n];
		rangeSpare=new int[3*n];
		for(int i=0;i<n;i++) {
			arr[i]=in.nextInt();
		}
		init(arr, 0,n-1,0);
		for(int i=0;i<q;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			int[] answer=query(a,b,0,0,n-1);
			System.out.println(answer[0]+" "+answer[1]);
		}
		in.close();
	}
}
