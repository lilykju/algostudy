package networkflow;

import java.util.Arrays;
import java.util.Scanner;

public class N11377_Strongest {
	static boolean[][] can;
	static boolean[] check;
	static int[] pred;
	static int n,m,k;
	
	static boolean dfs(int x) {
		if(x==-1) return true;
		for(int i=0;i<m;i++) {
			if(!can[x][i]||check[i]) continue;
			check[i]=true;
			if(dfs(pred[i])) {
				pred[i] = x;
				return true;
			}
		}
		return false;
	}
	
	static int flow() {
		int ans =0;
		for(int i=0;i<n;i++) {
			check = new boolean[m];
			if(dfs(i)) ans++;
		}
		int cou=0;
		for(int i=0;i<n;i++) {
			check = new boolean[m];
			if(dfs(i)) cou++;
			if(cou==k)break;
		}
		return ans+cou;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		k=in.nextInt();
		can=new boolean[n][m];
		for(int i=0;i<n;i++) {
			int wn=in.nextInt();
			for(int j=0;j<wn;j++) {
				can[i][in.nextInt()-1]=true;
			}
		}
		pred = new int[m];
		Arrays.fill(pred, -1);
		System.out.println(flow());
		in.close();
	}
}
