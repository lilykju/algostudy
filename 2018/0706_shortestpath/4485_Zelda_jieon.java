package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N4485_Zelda {

	static int n;
	static int[][] mat, dist;
	static int[] kx= {0,0,-1,1}, ky= {-1,1,0,0};
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		dist[0][0]=mat[0][0];
		q.add(0);
		while(!q.isEmpty()) {
			int x=q.peek()/n;
			int y=q.poll()%n;
			for(int k=0;k<4;k++) {
				int nx=x+kx[k], ny=y+ky[k];
				if(0<=nx&&nx<n&&0<=ny&&ny<n) {
					if(dist[nx][ny]>dist[x][y]+mat[nx][ny]) {
						dist[nx][ny]=dist[x][y]+mat[nx][ny];
						q.add(nx*n+ny);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=0;
		int inf=10000000;
		while(true) {
			n=in.nextInt();
			if(n==0)break;
			mat=new int[n][n];
			dist=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) 
					mat[i][j]=in.nextInt();
				Arrays.fill(dist[i], inf);	
			}
			bfs();
			System.out.println("Problem "+ ++t+": "+dist[n-1][n-1]);
		}
		in.close();
	}
}
