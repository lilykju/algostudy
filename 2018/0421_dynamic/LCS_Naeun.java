package dynamic;

import java.util.Scanner;

public class LCS {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		int[][] d=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++) {
			int max=0;
			for(int j=1;j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					d[i][j]=d[i-1][j-1]+1;
				}else {
					d[i][j]=Math.max(d[i-1][j], max);
				}
				if(d[i][j]>max) max=d[i][j];
			}
		}
		System.out.println(d[s1.length()][s2.length()]);
		in.close();
	}
}
