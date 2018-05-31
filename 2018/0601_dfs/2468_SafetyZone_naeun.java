package graph;

import java.util.Scanner;

public class N2468_SafetyZone {
	
	static int n;
	static int[][] mat;
	static boolean[][] check;
	
	static int[] kx= {0,0,1,-1};
	static int[] ky= {-1,1,0,0};
	
	static void dfs(int x,int y,int k) {
		check[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx=x+kx[i];
			int ny=y+ky[i];
			if(0<=nx&&nx<n&&0<=ny&&ny<n&&!check[nx][ny]) {
				if(!check[nx][ny]&&mat[nx][ny]>k)
					dfs(nx,ny,k);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		mat= new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j]=in.nextInt();
			}
		}
		
		int answer=1;
		for(int k=1;k<100;k++) {
			check= new boolean[n][n];
			int area=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!check[i][j]&&mat[i][j]>k) {
						dfs(i,j,k);
						area++;
					}
				}
			}
			
			if(area==0) break;
			if(area>answer) answer=area;
		}
		
		System.out.println(answer);
		in.close();
	}

}
