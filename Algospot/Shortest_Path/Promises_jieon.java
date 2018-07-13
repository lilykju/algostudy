package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Promises {
	
	static int v;
	static int[][] adj;
	static int MAX=1000000000;
	
	static boolean update(int a,int b,int c) {
		if(adj[a][b]<=c) return false;
		for(int x=0;x<v;x++)
			for(int y=0;y<v;y++)
				adj[x][y]=Math.min(adj[x][y], Math.min(adj[x][a]+c+adj[b][y], adj[x][b]+c+adj[a][b]));
		return true;
	}
	
	static void floyd() {

		for(int k=0;k<v;k++)
			for(int i=0;i<v;i++)
				for(int j=0;j<v;j++)
					if(adj[i][j]>adj[i][k]+adj[k][j]) {
						adj[i][j]=adj[i][k]+adj[k][j];
					}

	}
	
	static boolean isRight(int a,int b,int c) {
		//System.out.println(adj[a][b]+" "+c);
		if(adj[a][b]<=c) return false;
		for(int i=0;i<v;i++)
			for(int j=0;j<v;j++) {
				adj[i][j]=Math.min(adj[i][j], Math.min(adj[i][a]+c+adj[b][j], adj[i][b]+c+adj[a][j]));
				//System.out.println(i+" "+j+" "+adj[i][j]);
			}
				
		return true;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int tk=in.nextInt();
		while(tk-->0) {
			v=in.nextInt();
			int M=in.nextInt();
			int N=in.nextInt();
			adj=new int[v][v];
			for(int i=0;i<v;i++) {
				Arrays.fill(adj[i], MAX);
				adj[i][i]=0;
			}
			for(int i=0;i<M;i++) {
				int a=in.nextInt();
				int b=in.nextInt();
				int c=in.nextInt();
				adj[a][b]=adj[b][a]=c;
			}
			floyd();
			int answer=0;
			for(int i=0;i<N;i++) {
				if(!update(in.nextInt(),in.nextInt(),in.nextInt())) {
					answer++;
				}	
			}
			System.out.println(answer);
		}
		in.close();
	}
}
