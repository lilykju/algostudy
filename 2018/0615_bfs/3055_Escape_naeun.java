package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x,y;
	public Pair(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class N3055_Escape {
	
	static int r,c;
	static int[][] map;
	static int[] kx= {0,0,1,-1}, ky= {1,-1,0,0};
	
	static int bfs(Pair p,boolean mode) {
		boolean[][] check=new boolean[r][c];
		Queue<Pair> q=new LinkedList<>();
		q.add(p);
		check[p.x][p.y]=true;
		while(!q.isEmpty()) {
			p=q.poll();
			int count=map[p.x][p.y]+1;
			for(int k=0;k<4;k++) {
				int nx=p.x+kx[k];
				int ny=p.y+ky[k];
				if(0<=nx&&nx<r&&0<=ny&&ny<c&&!check[nx][ny]) {
					if(mode&&map[nx][ny]==-2) return count;
					if(map[nx][ny]==0||count<map[nx][ny]) {
						map[nx][ny]=count;
						check[nx][ny]=true;
						q.add(new Pair(nx,ny));
					}
				}
			}
		}

		return r*c*2;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		r=in.nextInt();
		c=in.nextInt();
		map=new int[r][c];
		ArrayList<Pair> wa=new ArrayList<>();
		Pair start=new Pair(0,0);
		in.nextLine();
		for(int i=0;i<r;i++) {
			String s=in.nextLine();
			for(int j=0;j<c;j++) {
				int temp=0;
				switch(s.charAt(j)) {
				case '.' : break;
				case 'X' : temp=-1; break;
				case '*' : wa.add(new Pair(i,j)); break;
				case 'D' : temp=-2; break;
				case 'S' : start.x=i; start.y=j; break;
				}
				map[i][j]=temp;
			}
		}
		
		for(Pair p: wa) {
			map[p.x][p.y]=0;
			bfs(p,false);
		}
		/*
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		map[start.x][start.y]=0;
		int answer=bfs(start,true);
		/*
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		
		System.out.println((answer==r*c*2)?"KAKTUS":answer);
		in.close();
	}

}
