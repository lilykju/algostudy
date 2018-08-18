package c;

import java.util.Scanner;

public class Ed48_Mushroom {
	
	static long straight(int[][] glade, int n, int x, int y) {
		long ret=0;
		int start=y*2;
		for(int i=y;i<n;i++) 
			ret += glade[x][i]*start++;
		
		for(int i=n-1;i>=y;i--) 
			ret += glade[-(x-1)][i]*start++;

		return ret;
	}
	
	static long go(int[][] glade,int n, int x, int y) {
		if(y==n) return 0;
		long a=straight(glade,n,x,y);
		long b=glade[x][y]*y*2+glade[-(x-1)][y]*(y*2+1)+go(glade,n,-(x-1),y+1);
		return Math.max(a,b);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] glade=new int[2][n];
		for(int i=0;i<2;i++)
			for(int j=0;j<n;j++)
				glade[i][j]=in.nextInt();
		
		System.out.println(go(glade,n,0,0));
		in.close();
	}
}
