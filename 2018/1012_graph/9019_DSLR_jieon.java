package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N9019_DSLR {
	
	static int[] before;
	static char[] type, kt= {'D','S','L','R'};
	
	static int dslr(int n, char type) {
		if(type=='D') return (n*2)%10000;
		if(type=='S') return (n-1==-1)? 9999:n-1;
		if(type=='L') return (n%1000)*10+n/1000;
		return n/10 + (n%10)*1000;
	}
	
	static void bfs(int from,int to) {
		Queue<Integer> q=new LinkedList<>();
		q.add(from);
		while(!q.isEmpty()) {
			int x=q.poll();
			for(int k=0;k<4;k++) {
				int next=dslr(x,kt[k]);
				if(before[next]==-1) {
					//System.out.println(next);
					before[next]=x;
					type[next]=kt[k];
					q.add(next);
					if(next==to) return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int from=in.nextInt(), to=in.nextInt();
			before=new int[10000];
			type=new char[10000];
			Arrays.fill(before, -1);
			
			bfs(from,to);
			
			ArrayList<Character> ans=new ArrayList<>();
			int x=to;
			while(x!=from) {
				ans.add(type[x]);
				x=before[x];
			}
			for(int i=ans.size()-1;i>=0;i--)
				System.out.print(ans.get(i));
			System.out.println();
		}
		in.close();

	}

}
