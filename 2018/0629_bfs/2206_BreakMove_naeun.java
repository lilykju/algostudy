package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N2206_BreakMove {
	
	static int[] kx= {0,0,1,-1}, ky= {1,-1,0,0};

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		
		int[][][] mat=new int[n][m][2];
		in.nextLine();
		for(int i=0;i<n;i++) {
			String s=in.nextLine();
			for(int j=0;j<m;j++)
				mat[i][j][0]=mat[i][j][1]=(s.charAt(j)=='1')? -2:-1 ;
		}
		
		Queue<Integer> q=new LinkedList<>();
		mat[0][0][0]=mat[0][0][1]=1;
		q.add(0);
		while(!q.isEmpty()) {
			int x=q.peek()/m;
			int y=q.poll()%m;
			for(int k=0;k<4;k++) {
				int nx=x+kx[k], ny=y+ky[k];
				boolean b=false;
				if(0<=nx&&nx<n&&0<=ny&&ny<m) {
					if(mat[x][y][0]>0&&(mat[nx][ny][0]==-1||mat[nx][ny][0]>mat[x][y][0]+1)) {
						mat[nx][ny][0]=mat[x][y][0]+1;
						b=true;
					}
					if(mat[x][y][1]>0&&mat[nx][ny][1]==-1||mat[nx][ny][1]>mat[x][y][1]+1) {
						mat[nx][ny][1]=mat[x][y][1]+1;
						b=true;
					}
					if(mat[nx][ny][0]==-2&&mat[x][y][0]>0)
						if(mat[nx][ny][1]==-2||mat[nx][ny][1]>mat[x][y][0]+1) {
							mat[nx][ny][1]=mat[x][y][0]+1;
							b=true;
						}
					if(b) q.add(nx*m+ny);
				}
			}	
		}
		int answer=0;
		if(mat[n-1][m-1][0]==-1) answer=mat[n-1][m-1][1];
		else if(mat[n-1][m-1][1]==-1) answer=mat[n-1][m-1][0];
		else answer=Math.min(mat[n-1][m-1][0], mat[n-1][m-1][1]);
		System.out.println(answer);
		in.close();
	}
}
