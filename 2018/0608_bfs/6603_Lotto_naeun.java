package graph;

import java.util.Scanner;

public class N6603_Lotto {
	
	static int k;
	static int[] num;
	
	static void dfs(int x,int count, String answer) {
		if(count==5) {
			System.out.println(answer);
			return;
		}
		for(int i=x+1;i<k;i++) {
			dfs(i, count+1, answer+num[i]+" ");
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true) {
			k=in.nextInt();
			if(k==0) break;
			num=new int[k];
			for(int i=0;i<k;i++)
				num[i]=in.nextInt();
			for(int i=0;i<k-5;i++)
				dfs(i,0,num[i]+" ");
			System.out.println();
		}
		in.close();
	}
}
