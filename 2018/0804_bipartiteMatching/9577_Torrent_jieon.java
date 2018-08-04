package networkflow;

import java.util.Arrays;
import java.util.Scanner;

public class N9577_Torrent {

	static boolean dfs(boolean[][] time, boolean[] check,int[] pred, int n, int x) {
		if(x==-1) return true;
		for(int i=1;i<=n;i++) {
			if(!time[x][i]||check[i]) continue;
			check[i]=true;
			if(dfs(time, check,pred,n,pred[i])) {
				pred[i] = x;
				return true;
			}
		}
		return false;
	}
	
	static int flow(boolean[][] time, int n,int tn) {
		int ans =0;
		int[] pred = new int[n+1];
		Arrays.fill(pred, -1);
		boolean[] check;
		for(int i=0;i<tn;i++) {
			check = new boolean[n+1];
			if(dfs(time, check,pred,n,i)) ans++;
			if(ans==n) return i+1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n=in.nextInt();
			int m=in.nextInt();
			boolean[][] time=new boolean[101][n+1];

			int tn=0;
			for(int i=0;i<m;i++) {
				int t1=in.nextInt();
				int t2=in.nextInt();
				int p=in.nextInt();
				for(int j=0;j<p;j++) {
					int piece=in.nextInt();
					for(int k=t1;k<t2;k++)
						time[k][piece]=true;
				}
				if(tn<t2) tn=t2;
			}
			System.out.println(flow(time,n,tn));
			
		}
		in.close();
	}
}
