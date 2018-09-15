package dynamic;

import java.util.Scanner;

public class N1028_DiamondM {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		int c=in.nextInt();
		boolean[][] one=new boolean[r][c];
		in.nextLine();
		for(int i=0;i<r;i++) {
			String ins=in.nextLine();
			for(int j=0;j<c;j++){
				one[i][j]=(ins.charAt(j)=='1'); 
			}
		}
		in.close();
		int[][][] d=new int[2][r][c];
		for(int s=0;s<r+c;s++) {
			int temp=0;
			int i=(s<r)?s:r-1;
			for(int j=(s<r)?0:s-r+1;i>=0&&j<c;j++,i--) {
				if(one[i][j]) d[0][i][j]=++temp;
				else temp=0;
			}
			temp=0;
			i=(s<r)?s:r-1;
			for(int j=(s<r)?c-1:r+c-1-s;i>=0&&j>=0;j--,i--) {
				System.out.println(i+" "+j);
				if(one[i][j]) d[1][i][j]=++temp;
				else temp=0;
			}
		}
		int answer=0;
		for(int t=(Math.min(r, c)+1)/2;t>0;t--) {
			int tn=t-1;
			for(int j=t-1;j<c-tn;j++) {
				for(int i=0;i<r-tn*2;i++) {
					//System.out.println(i+" "+j);
					if(d[0][i][j]>=t&&d[1][i][j]>=t&&d[0][i+tn][j+tn]>=t&&d[1][i+tn][j-tn]>=t) {
						answer=t;
						break;
					}
				}
				if(answer>0)break;
			}
			if(answer>0)break;
		}
		
		System.out.println(answer);
		
		
		/*
		System.out.println();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++){
				System.out.print(d[0][i][j]+" "); 
			}
			System.out.println();
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++){
				System.out.print(d[1][i][j]+" "); 
			}
			System.out.println();
		}*/
	}
}
