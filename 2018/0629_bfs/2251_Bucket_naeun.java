package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class tri{
	int a,b,c;
	public tri(int x,int y,int z) {
		a=x;
		b=y;
		c=z;
	}
}

public class N2251_Bucket {
	
	static int a,b,c;
	static boolean[] answer;
	static boolean[][][] check;
	
	static boolean doCheck(int x,int y,int z) {
		if(check[x][y][z]) return false;
		check[x][y][z]=true;
		System.out.println(x+" "+y+" "+z);
		return true;
	}
	
	static tri pour(int x,int y,int z,int b) {
		if(x!=0) {
			if(y!=b) {
				if(x<=b-y) {
					return new tri(0,y+x,z);
				}else {
					return new tri(x-b+y,b,z);
				}
			}
		}
		return null;
	}
	
	static void bfs() {

		Queue<tri> q=new LinkedList<>();
		check[0][0][c]=true;
		q.add(new tri(0,0,c));
		
		while(!q.isEmpty()) {
			tri st=q.poll();
			if(st.a==0) answer[st.c]=true;
			tri ret=pour(st.a,st.b,st.c,b);
			if(ret!=null&&doCheck(ret.a,ret.b,ret.c)) q.add(new tri(ret.a,ret.b,ret.c));
			ret=pour(st.a,st.c,st.b,c);
			if(ret!=null&&doCheck(ret.a,ret.c,ret.b)) q.add(new tri(ret.a,ret.c,ret.b));
			ret=pour(st.b,st.a,st.c,a);
			if(ret!=null&&doCheck(ret.b,ret.a,ret.c)) q.add(new tri(ret.b,ret.a,ret.c));
			ret=pour(st.b,st.c,st.a,c);
			if(ret!=null&&doCheck(ret.c,ret.a,ret.b)) q.add(new tri(ret.c,ret.a,ret.b));
			ret=pour(st.c,st.a,st.b,a);
			if(ret!=null&&doCheck(ret.b,ret.c,ret.a)) q.add(new tri(ret.b,ret.c,ret.a));
			ret=pour(st.c,st.b,st.a,b);
			if(ret!=null&&doCheck(ret.c,ret.b,ret.a)) q.add(new tri(ret.c,ret.b,ret.a));
		}
	
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		a=in.nextInt();
		b=in.nextInt();
		c=in.nextInt();
		
		answer=new boolean[c+1];
		check=new boolean[a+1][b+1][c+1];
		
		bfs();
		
		for(int i=0;i<=c;i++)
			if(answer[i]) System.out.print(i+" ");
		
		
		in.close();
	}

}
