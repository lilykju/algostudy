package dynamic;

import java.util.Scanner;

//fibonacci
public class N1904_01tile {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int r=15746;
		int[] d=new int[n+1];
		d[0]=d[1]=1;
		
		for(int i=2;i<=n;i++) {
			d[i]=(d[i-1]+d[i-2])%r;
		}
		
		System.out.println(d[n]);
		
		in.close();
	}

}
