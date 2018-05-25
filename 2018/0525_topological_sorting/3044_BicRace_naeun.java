package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N3044_BicRace {
	final static int MAX=1000000000;
	static int n;
	static List<Integer>[] graph;
	static int[] ch;
	static long[] count;
	static boolean inf,big;
	
	static void dfs(int here) {
		if(inf) return;
		if(ch[here]==2) return;
		if(ch[here]==1) {
			inf=true;
			return;
		}
		ch[here]=1;
		for(int i:graph[here]) {
			dfs(i);
			if(inf&&count[i]==0) inf=false;
			count[here]+=count[i];
		}
		if(count[here]>=MAX) {
			count[here]%=MAX;
			big=true;
		}
		ch[here]=2;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int m=in.nextInt();
		count=new long[n+1];
		ch=new int[n+1];
		graph=(List<Integer>[])new List[n+1];
		for(int i=1;i<=n;i++)
			graph[i]=new ArrayList<>();
		for(int i=0;i<m;i++) {
			int a=in.nextInt();
			int b=in.nextInt();
			graph[b].add(a);
		}
		count[1]=1;
		dfs(2);
		String answer=Long.toString(count[2]);
		if(!inf&&big)
			while(answer.length()<9) answer = "0"+answer;
		System.out.println((inf) ? "inf":answer);
		
		in.close();
	}
}
