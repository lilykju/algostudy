package graph;

import java.util.Scanner;

public class N2529_Inequality {
	
	static int n;
	static int[][] answer;
	
	static void go(boolean[] adj,int a) {
		int k=1;
		for(int i=0;i<=n;i++) {
			if(!adj[i]) {
				for(int j=i;j>=0;j--) {
					if(answer[a][j]!=0) break;
					answer[a][j]=k++;
				}
			}	
		}
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		boolean[] bigg=new boolean[n+1];
		boolean[] smalle=new boolean[n+1];
		//answer[0]:최대  answer[1]:최소
		answer=new int[2][n+1];
		in.nextLine();
		String[] s=in.nextLine().split(" ");
		for(int i=0;i<n;i++) {
			if(s[i].equals(">")) {
				smalle[i]=true;
			}else {
				bigg[n-i-1]=true;
			}
		}
		go(bigg,0);
		go(smalle,1);
		for(int i=n;i>=0;i--) {
			System.out.print((answer[0][i]+8-n));
		}
		System.out.println();
		for(int i=0;i<=n;i++) {
			System.out.print((answer[1][i]-1));
		}
		
		in.close();
	}
}
