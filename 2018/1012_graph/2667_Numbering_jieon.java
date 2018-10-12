package bfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class N2667_Numbering {
	static int n;
	static boolean[][] mat, check;
	static int[] kx= {0,0,1,-1}, ky= {1,-1,0,0};
	
	static int bfs(int x,int y) {
		int ret=1;
		Queue<Integer> q=new LinkedList<>();
		check[x][y]=true;
		q.add(x*n+y);
		while(!q.isEmpty()) {
			x=q.peek()/n;
			y=q.poll()%n;
			for(int k=0;k<4;k++) {
				int nx=x+kx[k], ny=y+ky[k];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&mat[nx][ny]&&!check[nx][ny]) {
					ret++;
					check[nx][ny]=true;
					q.add(nx*n+ny);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		mat=new boolean[n][n];
		in.nextLine();
		for(int i=0;i<n;i++) {
			String s=in.nextLine();
			for(int j=0;j<n;j++)
				mat[i][j]= s.charAt(j)=='1';
		}
		in.close();
		
		check=new boolean[n][n];
		PriorityQueue<Integer> ans=new PriorityQueue<>();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(mat[i][j]&&!check[i][j]) ans.add(bfs(i,j));

		System.out.println(ans.size());
		while(!ans.isEmpty())
			System.out.println(ans.poll());
	}

}
