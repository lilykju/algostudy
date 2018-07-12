package graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class N2610_PreMeeting {
	static int MAX=1000000000;
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int[][] adj=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(adj[i], MAX);
			adj[i][i]=0;
		}
		for(int i=0;i<m;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			adj[a][b]=adj[b][a]=1;
		}
		
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					if(adj[i][j]>adj[i][k]+adj[k][j]) {
						adj[i][j]=adj[i][k]+adj[k][j];
					}
		
		int[] mdist=new int[n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				if(adj[i][j]<MAX&&adj[i][j]>mdist[i])
					mdist[i]=adj[i][j];
		}
		
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		boolean[] check=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			if(!check[i]) {
				int d=mdist[i];
				int cm=i;
				for(int j=i;j<=n;j++) {
					if(adj[i][j]<MAX) {
		
						System.out.println(j+" "+mdist[j]);
						if(d>mdist[j]) {
							d=mdist[j];
							cm=j;
						}
						check[j]=true;
					}
				}
				
				pq.add(cm);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty())
			System.out.println(pq.poll());
		
		in.close();
	}
}
