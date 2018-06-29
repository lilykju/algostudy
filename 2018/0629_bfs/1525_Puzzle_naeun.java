package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1525_Puzzle {
	
	static int[] kx= {0,0,1,-1}, ky= {1,-1,0,0};
	
	static int get(int state, int index) {
		return state/(int)Math.pow(9,index)%9;
	}
	
	static int set(int state, int index, int value) {
		return state+value*(int)Math.pow(9, index);
	}
	
	static int bfs(int begin,int end) {
		if(begin==end) return 0;
		boolean[] b=new boolean[(int)Math.pow(9, 9)];
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(begin,0));
		b[begin]=true;
		while(!q.isEmpty()) {
			int here=q.peek().x;
			int dist=q.poll().y+1;
			int zin=8;
			for(int i=0;i<8;i++) {
				if(get(here,i)==0) {
					zin=i;
					break;
				}
			}
			int x=zin/3;
			int y=zin%3;
			for(int k=0;k<4;k++) {
				int nx=x+kx[k], ny=y+ky[k];
				if(0<=nx&&nx<3&&0<=ny&&ny<3) {
					int to=nx*3+ny;
					int num=get(here,to);
					int there=set(here,zin,num);
					there=set(there,to,-num);
					if(b[there]) continue;
					b[there]=true;
					if(there==end) return dist;
					q.add(new Pair(there,dist));
				}	
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int begin=0;
		int end=0;
		for(int i=8;i>=0;i--) {
			begin=set(begin,i,in.nextInt());
			end=set(end,i,i==0?0:9-i);
		}
		
		System.out.println(bfs(begin,end));
	
		in.close();
	}
}
