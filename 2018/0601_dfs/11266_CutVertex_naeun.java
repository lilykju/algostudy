package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N11266_CutVertex {
	
	static List<Integer>[] graph;
	static boolean[] isCut;
	static int[] d;
	static int counter=0, ans=0;
	
	static int findCutVertex(int here,boolean isRoot) {
		d[here]=counter++;
		//System.out.println(here+" "+d[here]+" "+graph[here].size());
		int ret=d[here];
		
		int chi=0;
		for(int i=0;i<graph[here].size();i++) {
			int there=graph[here].get(i);
			if(d[there]==-1) {
				++chi;
				int sub=findCutVertex(there,false);
				if(!isRoot&&sub>=d[here])
					isCut[here]=true;
				ret=Math.min(ret, sub);
			}else
				ret=Math.min(ret, d[there]);
		}
		if(isRoot) isCut[here]=(chi>=2);
		if(isCut[here]) ans++;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int v=in.nextInt();
		int e=in.nextInt();
		isCut=new boolean[v+1];
		d=new int[v+1];
		Arrays.fill(d, -1);
		graph=(List<Integer>[])new List[v+1];
		for(int i=1;i<=v;i++)
			graph[i]=new ArrayList<>();
		for(int i=0;i<e;i++) {
			int a=in.nextInt(), b=in.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1;i<=v;i++) {
			if(d[i]==-1)
				findCutVertex(i,true);
			
		}
		
		System.out.println(ans);
		for(int i=1;i<=v;i++) {
			if(isCut[i])
				System.out.print(i+" ");
		}
		
		in.close();
	}
}
