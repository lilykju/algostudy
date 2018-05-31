package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class N2573_Iceberg {
	
	static int n,m;
	static int[][] mat;
	static boolean[][] check;
	static ArrayList<Integer> a; 
	
	static int[] kx= {0,0,1,-1};
	static int[] ky= {-1,1,0,0};
	
	
	static int dfs(int x,int y) {
		//System.out.println(x+", "+y+" : "+mat[x][y]);
		int count=1;
		int zero=0;
		check[x][y]=true;
		for(int k=0;k<4;k++) {
			int nx=x+kx[k];
			int ny=y+ky[k];
			if(0<=nx&&nx<n&&0<=ny&&ny<m&&!check[nx][ny]) {
				if(mat[nx][ny]!=0) {
					count+=dfs(nx,ny);
				}else zero++;
			}
		}
		if(mat[x][y]<=zero) {
			mat[x][y]=0;
			a.remove((Integer) (x*m+y));
		}else {
			mat[x][y]-=zero;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		mat=new int[n][m];
		a=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mat[i][j]=in.nextInt();
				if(mat[i][j]!=0)a.add(i*m+j);
			}
		}
		int year=0;
		while(true) {
			check= new boolean[n][m];
			int size=a.size();
			if(size==0) {
				year=0;
				break;
			}
			int x=a.get(0)/m;
			int y=a.get(0)%m;
			int count=dfs(x,y);
			if(size>count) break;
			year++;
		}
		System.out.println(year);
		
		in.close();
	}

}
