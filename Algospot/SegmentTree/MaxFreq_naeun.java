package Tree;

import java.util.Scanner;

public class MaxFreq {
	
	static class node{
		int value, freq, left, right, leftFreq, rightFreq;
		
		node(){}
		
		node(int v){
			value = v;
			freq = 1;
			left = v;
			right = v;
			leftFreq =1;
			rightFreq =1;
		}
		
		void setLeft(int l,int f) {
			left=l;
			leftFreq=f;
		}
		void setRight(int r, int f) {
			right=r;
			rightFreq=f;
		}
		void setValue(int v,int f) {
			value=v;
			freq=f;
		}
		
		void print(String s) {
			System.out.println(s+"\t left:"+left+" leftFreq:"+leftFreq+" right:"+right+" rightFreq:"+rightFreq
					+" value:"+value+" freq:"+freq);
		}
	}
	
	final static int INT_MIN=Integer.MIN_VALUE;
	static node[] ranVal;
	
	static node merge(node leftVal, node rightVal) {
		if(leftVal==null) return rightVal;
		if(rightVal==null) return leftVal;
		
		
		node ret=new node();
		
		ret.setLeft(leftVal.left,leftVal.leftFreq);
		ret.setRight(rightVal.right, rightVal.rightFreq);
		if(leftVal.right==rightVal.left) {
			if(leftVal.left==leftVal.right) 
				ret.leftFreq+=rightVal.leftFreq;
			if(rightVal.left==rightVal.right) 
				ret.rightFreq+=leftVal.rightFreq;
			ret.setValue(leftVal.right, leftVal.rightFreq+rightVal.leftFreq);
		}
		if(ret.freq<leftVal.freq) {
			ret.setValue(leftVal.value, leftVal.freq);
		}
		if(ret.freq<rightVal.freq) {
			ret.setValue(rightVal.value, rightVal.freq);
		}
		//leftVal.print("left::");
		//rightVal.print("right::");
		//ret.print("ret::");
		
		return ret;
	}
	
	static node init(int[] arr, int left, int right, int no) {
		if(left==right) {
			return ranVal[no]=new node(arr[left]);
		}
		int mid=(left+right)/2;
		node leftVal=init(arr,left,mid,no*2+1);
		node rightVal=init(arr,mid+1,right,no*2+2);
		//System.out.println("init:"+no+" "+left+" "+right);
		return ranVal[no]=merge(leftVal,rightVal);
	}
	
	static node query(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right<nodeLeft||nodeRight<left) return null;
		if(left<=nodeLeft&&nodeRight<=right) return ranVal[node];
		int mid=(nodeLeft+nodeRight)/2;
		//System.out.println("qeury:"+node+" "+nodeLeft+" "+nodeRight);
		return merge(query(left,right, node*2+1, nodeLeft, mid), 
				query(left, right, node*2+2, mid+1, nodeRight));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int q=in.nextInt();
		int[] sorted=new int[n];
		for(int i=0;i<n;i++) {
			sorted[i]=in.nextInt();
		}
		ranVal=new node[4*n];
		init(sorted,0,n-1,0);
		
		for(int i=0;i<q;i++) {
			node answer=query(in.nextInt(),in.nextInt(),0,0,n-1);
			System.out.println(answer.value+" "+answer.freq);
		}
		
		in.close();
	}
}
