package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishops {
	
	static List<Integer>[] graph;
	static boolean[] check;
	static int[] pred;
	
	static boolean dfs(int x) {
		if(x==-1) return true;
		for(int next:graph[x]) {
			if(check[next]) continue;
			check[next]=true;
			if(dfs(pred[next])) {
				pred[next] = x;
				return true;
			}
		}
		return false;
	}
	
	static int flow(int n,int m) {
		int ans =0;
		for(int i=0;i<n;i++) {
			check = new boolean[m];
			if(dfs(i)) ans++;
		}
		return ans;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n=Integer.parseInt(br.readLine());
			
			char[][] board = new char[n][n];
			for(int i=0;i<n;i++) {
				board[i]=br.readLine().toCharArray();
			}
			int[][] hgroup=new int[n][n];
			int[][] vgroup=new int[n][n];
			int hcnt=-1, vcnt=-1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]=='*')continue;
					if(i-1<0||j+1>=n||board[i-1][j+1]=='*') {
						hcnt++;
						hgroup[i][j]=hcnt;
					}else hgroup[i][j]=hgroup[i-1][j+1];
					
					//System.out.println("i:"+i+",j:"+j+"  hcnt:"+hcnt);
				}
			}
			graph=(List<Integer>[]) new List[hcnt+1];
			for(int i=0;i<=hcnt;i++) {
				graph[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]=='*')continue;
					if(i-1<0||j-1<0||board[i-1][j-1]=='*') {
						vcnt++;
						vgroup[i][j]=vcnt;
						graph[hgroup[i][j]].add(vcnt);
					}else {
						graph[hgroup[i][j]].add(vgroup[i-1][j-1]);
						vgroup[i][j]=vgroup[i-1][j-1];
					}
				}
			}

			pred = new int[vcnt+1];
			Arrays.fill(pred, -1);
			
			/*
			for(int i=0;i<=hcnt;i++) {
				for(int j:graph[i]) {
					System.out.print(j);
				}
				System.out.println();
			}
			*/
			
			System.out.println(flow(hcnt+1,vcnt+1));
		}
		
		
		
	}
	
	
}
