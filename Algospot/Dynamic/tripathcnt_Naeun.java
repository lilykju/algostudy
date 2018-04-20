package Dynamic;

import java.util.Scanner;

public class tripathcnt {
	
	static int n;
	static int[][] tri;
	static int[][] count, path;
	
	static int go(int x,int y) {
		if(x==n-1) {
			path[x][y]=tri[x][y];
			return 1;
		}
		if(count[x][y]>0) return count[x][y];
		int c1=go(x+1,y);
		int c2=go(x+1,y+1);
		path[x][y]=tri[x][y];
		if(path[x+1][y]>path[x+1][y+1]) {
			path[x][y] +=path[x+1][y];
			return count[x][y]=c1;
		}
		if(path[x+1][y]<path[x+1][y+1]) {
			path[x][y] +=path[x+1][y+1];
			return count[x][y]=c2;
		}
		path[x][y] +=path[x+1][y];
		return count[x][y]=c1+c2;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_case = in.nextInt();
		while (test_case-- > 0) {
			n=in.nextInt();
			tri=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<=i;j++) {
					tri[i][j]=in.nextInt();
				}
			}
			count=new int[n][n];
			path = new int[n][n];
			
			System.out.println(go(0,0));
		}
		in.close();
	}
}
