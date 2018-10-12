package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class N5214_Transfer {
/*
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int m=in.nextInt();
		int[][] train=new int[m][k];
		boolean[][] connected=new boolean[n+1][m];
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				train[i][j]=in.nextInt();
				connected[train[i][j]][i]=true;
			}
		}
		in.close();
	     if(n==1) {
	       System.out.println(1);
	       return;
	     }
		int[] d=new int[n+1];
		d[1]=1;
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int x=q.poll();
			for(int i=0;i<m;i++) {
				if(connected[x][i]) {
					for(int j=0;j<k;j++) {
						int go=train[i][j];
						if(d[go]==0) {
							d[go]=d[x]+1;
							q.add(go);
							if(go==n) {
								System.out.println(d[go]);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
		
	}*/
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int m=in.nextInt();
		List<Integer>[] con=(List<Integer>[])new List[n+1];
		for(int i=1;i<=n;i++)con[i]= new ArrayList<>();
		int[][] train=new int[m][k];
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				train[i][j]=in.nextInt();
				con[train[i][j]].add(i);
			}
		}
		in.close();
	    boolean[] check=new boolean[m];
		int[] d=new int[n+1];
		d[1]=1;
		Queue<Integer> q=new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()) {
			int x=q.poll();
			for(int i:con[x]) {
				if(check[i]) continue;
				check[i]=true;
				for(int j=0;j<k;j++) {
					int go=train[i][j];
					if(d[go]==0) {
						d[go]=d[x]+1;
						q.add(go);
					}
				}
			}
		}
		System.out.println(d[n]==0?-1:d[n]);
	}

}
