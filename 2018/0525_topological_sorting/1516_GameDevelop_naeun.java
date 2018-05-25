package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class N1516_GameDevelop {
	
	static int n;
	static int[] time,result,d;
	static List<Integer>[] graph;
	static ArrayList<Integer> a;
	
	static void bfs() {
		while(!a.isEmpty()) {
			Iterator<Integer> it=a.iterator();
			while(it.hasNext()) {
				int i=(int) it.next();
				if(d[i]==0) {
					result[i] += time[i];
					for(int k: graph[i]) {
						if(result[k]<result[i]) {
							result[k]=result[i];
						}
						d[k]--;
					}
					it.remove();
				}
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		time=new int[n+1];
		result=new int[n+1];
		d=new int[n+1];
		a=new ArrayList<>();
		graph=(List<Integer>[])new List[n+1];
		for(int i=1;i<=n;i++) {
			graph[i]=new ArrayList<>();
			a.add(i);
		}
		for(int i=1;i<=n;i++) {
			time[i]=in.nextInt();
			while(true) {
				int temp=in.nextInt();
				if(temp==-1) break;
				d[i]++;
				graph[temp].add(i);
			}
		}
		
		bfs();
		
		for(int i=1;i<=n;i++)
			System.out.println(result[i]);
		
		in.close();
	}	
}
