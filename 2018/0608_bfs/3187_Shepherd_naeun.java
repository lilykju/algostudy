package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N3187_Shepherd {
	
	static String[][] mat;
	static boolean[][] checked;
	static int[] kx= {0,0,1,-1}, ky= {1,-1,0,0};
	static int r,c,k,v;

	static void bfs(Pair p) {
		int tempk=0;
		int tempv=0;
		Queue<Pair> q=new LinkedList<>();
		q.add(p);
		checked[p.x][p.y]=true;
		if(mat[p.x][p.y].equals("k")) tempk++;
		else if(mat[p.x][p.y].equals("v")) tempv++;
		while(!q.isEmpty()) {
			p=q.poll();
			for(int k=0;k<4;k++) {
				int nx=p.x+kx[k];
				int ny=p.y+ky[k];
				if(0<=nx&&nx<r&&0<=ny&&ny<c&&!checked[nx][ny]) {
					checked[nx][ny]=true;
					if(!mat[nx][ny].equals("#")) {
						if(mat[nx][ny].equals("k")) tempk++;
						else if(mat[nx][ny].equals("v")) tempv++;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}
		if(tempk>tempv) k+=tempk;
		else v+=tempv;
	}
	
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		r=in.nextInt();
		c=in.nextInt();
		mat=new String[r][c];
		checked=new boolean[r][c];
		in.nextLine();
		for(int i=0;i<r;i++) {
			mat[i]=in.nextLine().split("");
		}
		k=0;v=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!checked[i][j]&&!mat[i][j].equals("#")) bfs(new Pair(i,j));
			}
		}
		System.out.println(k+" "+v);
		in.close();
	}
}
