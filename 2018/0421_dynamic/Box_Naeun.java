package dynamic;

import java.util.Scanner;

public class Box {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int box;
		int[] d=new int[n];
		int max=0;
		while(n-->0) {
			box=in.nextInt();
			for(int k=0;k<=max;k++) {
				if(d[k]>=box||d[k]==0) {
					if(d[k]==0) max++;
					d[k]=box;
					break;
				}
			}
		}
		System.out.println(max);
		in.close();
	}
}
