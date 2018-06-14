package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChildrenDay {
	
	static int append(int here, int edge, int mod) {
		int there=here*10+edge;
		if(there>=mod) return mod+there%mod;
		return there%mod;
	}
	
	static String gifts(int[] digits, int n, int m) {
		int[] parent=new int[2*n];
		Arrays.fill(parent, -1);
		int[] choice=new int[2*n];
		Arrays.fill(choice, -1);
		Queue<Integer> q=new LinkedList<>();
		parent[0]=0;
		q.add(0);
		while(!q.isEmpty()) {
			int here=q.poll();
			for(int i=0;i<digits.length;i++) {
				int there=append(here,digits[i],n);
				if(parent[there]==-1) {
					parent[there]=here;
					choice[there]=digits[i];
					q.add(there);
				}
			}
			
		}
		
		if(parent[n+m]==-1) return "IMPOSSIBLE";
		StringBuffer ret=new StringBuffer();
		int here=n+m;
		while(parent[here]!=here) {
			ret.append(Integer.toString(choice[here]));
			here=parent[here];
		}
		return ret.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		while(t-->0) {
			String[] ss=in.next().split("");
			int n=in.nextInt();
			int m=in.nextInt();
			int l=ss.length;
			int[] d=new int[l];
			for(int i=0;i<l;i++) {
				d[i]=Integer.parseInt(ss[i]);
			}
			Arrays.sort(d);
			System.out.println(gifts(d,n,m));
			
		}
		in.close();
	}
}
