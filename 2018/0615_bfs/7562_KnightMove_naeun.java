package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7562_KnightMove {
	
	static int i, endX, endY;
	static int[][] count;
	static boolean[][] visited;
	static int[] kx= {-2,-2,-1,-1,1,1,2,2}, ky= {-1,1,-2,2,-2,2,-1,1};
	
	static void bfs(Pair p) {
		if(p.x==endX&&p.y==endY) return ;
		Queue<Pair> q=new LinkedList<>();
		q.add(p);
		visited[p.x][p.y]=true;
		while(!q.isEmpty()) {
			p=q.poll();
			for(int k=0;k<8;k++) {
				int nx=p.x+kx[k];
				int ny=p.y+ky[k];
				if(0<=nx&&nx<i&&0<=ny&&ny<i&&!visited[nx][ny]) {
					count[nx][ny]=count[p.x][p.y]+1;
					if(nx==endX&&ny==endY) return ;
					visited[nx][ny]=true;
					q.add(new Pair(nx,ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		while(t-->0) {
			i=in.nextInt();
			int startX=in.nextInt();
			int startY=in.nextInt();
			endX=in.nextInt();
			endY=in.nextInt();
			count=new int[i][i];
			visited=new boolean[i][i];
			bfs(new Pair(startX,startY));
			System.out.println(count[endX][endY]);
		}
		in.close();
	}
}
