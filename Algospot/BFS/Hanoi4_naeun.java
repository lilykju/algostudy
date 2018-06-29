package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hanoi4 {

	static int[] c;
	
	static int get(int state, int index) {
		return (state>>(index*2))&3;
	}
	
	static int set(int state, int index, int value) {
		return (state & ~(3<<(index*2)))|(value<<(index*2));
	}
	
	static int sgn(int x) {
		if(x==0) return 0;
		return x>0? 1:-1;
	}
	
	static int incr(int x) {
		if(x<0) return x-1;
		return x+1;
	}
	
	static int bidir(int discs, int begin, int end) {
		if(begin==end) return 0;
		Queue<Integer> q=new LinkedList<>();
		q.add(begin);
		c[begin]=1;
		q.add(end);
		c[end]=-1;
		while(!q.isEmpty()) {
			int here=q.poll();
			int[] top= {-1,-1,-1,-1};
			for(int i=discs-1;i>=0;i--) {
				top[get(here,i)]=i;
			}
			for(int i=0;i<4;i++) {
				if(top[i]!=-1)
					for(int j=0;j<4;j++) 
						if(i!=j&&(top[j]==-1||top[j]>top[i])) {
							int there=set(here, top[i],j);
							if(c[there]==0) {
								c[there]=incr(c[here]);
								q.add(there);
							}else if(sgn(c[there]) != sgn(c[here])){
								return Math.abs(c[there])+Math.abs(c[here])-1;
							}
						}
					
			}
		}
		return -1;
	}
	
	static int bfs(int discs, int begin, int end) {
		if(begin==end) return 0;
		Queue<Integer> q=new LinkedList<>();
		Arrays.fill(c, -1);
		q.add(begin);
		c[begin]=0;
		while(!q.isEmpty()) {
			int here=q.poll();
			int[] top= {-1,-1,-1,-1};
			for(int i=discs-1;i>=0;i--) {
				top[get(here,i)]=i;
			}
			for(int i=0;i<4;i++) {
				if(top[i]!=-1)
					for(int j=0;j<4;j++) 
						if(i!=j&&(top[j]==-1||top[j]>top[i])) {
							int there=set(here, top[i],j);
							if(c[there]!=-1) continue;
							c[there]=c[here]+1;
							if(there==end) return c[there];
							q.add(there);
						}
					
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n=in.nextInt();
			c=new int[1<<n*2];
			int begin=0;
			int end=0;
			for(int i=0;i<4;i++) {
				int temp=in.nextInt();
				for(int j=0;j<temp;j++) {
					int cir=in.nextInt();
					begin=set(begin,cir-1,i);
					end=set(end,cir-1,3);
				}
			}
			System.out.println(bidir(n,begin,end));
		}
		
		in.close();
	}
}
