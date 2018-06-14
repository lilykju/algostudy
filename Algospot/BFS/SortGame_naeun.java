package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SortGame {
	
	static HashMap<Integer, Integer> toSort;
	
	static void reverse(int[] perm,int i,int j) {
		
		for(int k=i;k<=(i+j)/2;k++) {
			int temp=perm[k];
			perm[k]=perm[i+j-k];
			perm[i+j-k]=temp;
		}	
	}
	
	
	static void test(int[] t,int c) {
		for(int i=0;i<t.length;i++)
			System.out.print(t[i]);
		System.out.println(" = "+c);
	}
	
	static int toInt(int[] x) {
		int to=0;
		for(int i=0;i<x.length;i++) {
			to*=10;
			to+=x[i];
		}
		return to;
	}
	
	static int[] toArr(int n,int x) {
		int[] to=new int[n];
		for(int i=0;i<n;i++) {
			to[n-i-1]=x%10;
			x/=10;
		}
		return to;
	}
	
	static void precalc(int n) {
		int[] perm=new int[n];
		for(int i=0;i<n;i++) perm[i]=i;
		Queue<Integer> q=new LinkedList<>();
		q.add(toInt(perm));
		toSort.put(toInt(perm), 0);
		while(!q.isEmpty()) {
			int x=q.poll();
			int cost=toSort.get(x);
			int[] here=toArr(n,x);
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					reverse(here,i,j);
					int temp=toInt(here);
					if(!toSort.containsKey(temp)) {
						toSort.put(temp, cost+1);
						q.add(temp);
					}
					reverse(here,i,j);
				}
			}		
		}	
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		toSort=new HashMap<>();
		while(t-->0) {
			int n=in.nextInt();
			int[] perm=new int[n];
			for(int i=0;i<n;i++) {
				perm[i]=in.nextInt();
			}
			precalc(n);
			int[] fixed=new int[n];
			for(int i=0;i<n;i++) {
				int smaller=0;
				for(int j=0;j<n;j++) {
					if(perm[j]<perm[i])smaller++;
				}
				fixed[i]=smaller;
			}
			System.out.println(toSort.get(toInt(fixed)));
		}
		in.close();
	}
}
