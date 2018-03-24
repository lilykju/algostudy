package Dynamic;

import java.util.Scanner;

public class trianglepath {

	static int maxPath(int n, int[][] tri, int[][] d, int x,int y) {
		if(d[x][y]!=0) return d[x][y];
		if(x==n-1) return d[x][y]=tri[x][y];
		
		return d[x][y]=Math.max(maxPath(n,tri,d,x+1,y), maxPath(n,tri,d,x+1,y+1))+tri[x][y];
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			int[][] tri=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					tri[i][j]=in.nextInt();
				}
			}
			
			int[][] d=new int[n][n];
			
			System.out.println(maxPath(n,tri,d,0,0));
			
			
		}
		in.close();
	}
}
