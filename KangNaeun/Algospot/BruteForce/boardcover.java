package BruteForce;

import java.util.Scanner;

public class boardcover {
	
	static int[][][] k= {{{0,1},{1,0}},{{0,1},{1,1}},{{1,0},{1,1}},{{1,0},{1,-1}}};
	
	static int cover (boolean[][] matrix,int h, int w,int x,int left) {
		if(left==0) return 1;
		
		int y=-1;
		for(int i=x;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(matrix[i][j]) {
					x=i;	
					y=j;
					break;
				}
			}
			if(y!=-1) break;
		}
		
		matrix[x][y]=false;
		int count =0;
		for(int i=0;i<4;i++) {
			int x1=x+k[i][0][0];
			int y1=y+k[i][0][1];
			int x2=x+k[i][1][0];
			int y2=y+k[i][1][1];
			if(0<=x1&&x1<h&&0<=x2&&x2<h&&0<=y1&&y1<w&&0<=y2&&y2<w) {				
				if(matrix[x1][y1]&&matrix[x2][y2]) {					
					matrix[x1][y1]=false;
					matrix[x2][y2]=false;
					count+=cover(matrix,h,w,x,left-1);
					matrix[x1][y1]=true;
					matrix[x2][y2]=true;
				}
			}
		}
		matrix[x][y]=true;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0) {
			int h=in.nextInt();
			int w=in.nextInt();
			in.nextLine();
			boolean[][] matrix=new boolean[h][w];
			int n=0;
			for(int i=0;i<h;i++) {
				String s=in.nextLine();
				for(int j=0;j<w;j++) {
					if(s.charAt(j)=='.') {
						matrix[i][j]=true; 
						n++;
					}
				}
			}

			if(n%3!=0) {
				System.out.println(0);
			}else {
				int left=n/3;
				System.out.println(cover(matrix,h,w,0,left));
			}
			
			
		}
		in.close();
	}
}
