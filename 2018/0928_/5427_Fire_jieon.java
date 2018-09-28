package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5427_Fire {

	static class pair{
		int x,y;
		pair(int i,int j){x=i;y=j;}
	}
	
	public static void main(String[] args) {
		int[] kx= {-1,0,1,0};
		int[] ky= {0,-1,0,1};
		Scanner in=new Scanner(System.in);
		int tc=in.nextInt();
		while(tc-->0) {
			int w=in.nextInt();
			int h=in.nextInt();
			int[][] building=new int[h][w];
			Queue<pair> queue=new LinkedList<>();
			pair sg=null;
			in.nextLine();
			for(int i=0;i<h;i++) {
				in.nextLine();
				String s=in.nextLine();
				for(int j=0;j<w;j++) {
					if(s.charAt(j)=='#') building[i][j]=-1;
					else if(s.charAt(j)=='.') building[i][j]=w*h;
					else if(s.charAt(j)=='*') queue.add(new pair(i,j));
					else if(s.charAt(j)=='@') {
						building[i][j]=w*h;
						sg=new pair(i,j);
					}
				}
			}
			while(!queue.isEmpty()) {
				pair p=queue.poll();
				for(int k=0;k<4;k++) {
					int nx=p.x+kx[k];
					int ny=p.y+ky[k];
					if(0<=nx&&nx<h&&0<=ny&&ny<w&&building[nx][ny]>building[p.x][p.y]+1) {
						building[nx][ny]=building[p.x][p.y]+1;
						queue.add(new pair(nx,ny));
					}
				}
			}
			building[sg.x][sg.y]=0;
			queue.add(sg);
			int answer=-1;
			while(!queue.isEmpty()) {
				pair p=queue.poll();
				if(0==p.x||p.x==h-1||0==p.y||p.y==w-1) {
					answer=building[p.x][p.y]+1;
					break;
				}
				for(int k=0;k<4;k++) {
					int nx=p.x+kx[k];
					int ny=p.y+ky[k];
					if(0<=nx&&nx<h&&0<=ny&&ny<w&&building[nx][ny]>building[p.x][p.y]+1) {
						building[nx][ny]=building[p.x][p.y]+1;
						queue.add(new pair(nx,ny));
					}
				}
			}
			System.out.println(answer==-1?"IMPOSSIBLE":answer);
		}
		in.close();
	}

}
