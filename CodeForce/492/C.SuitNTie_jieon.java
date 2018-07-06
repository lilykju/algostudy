package d;

import java.util.Arrays;
import java.util.Scanner;

public class R492_SuitNTie {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] num=new int[n+1];
		int[] loca=new int[2*n];
		Arrays.fill(num, -1);
		for(int i=0;i<2*n;i++) {
			int pn=in.nextInt();
			loca[i]=pn;
			if(num[pn]==-1) {
				num[pn]=i;
			}else {
				num[pn]=i-num[pn]-1;
			}
		}
		boolean[] check=new boolean[n+1];
		int answer=0;
		for(int i=0;i<2*n;i++) {
			if(check[loca[i]])continue;
			answer+=num[loca[i]];
			for(int k=i+1;k<=i+num[loca[i]];k++) {
				if(check[loca[k]]) answer--;
			}
			check[loca[i]]=true;
		}
		System.out.println(answer);
		in.close();
	}
}
