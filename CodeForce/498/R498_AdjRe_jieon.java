package a;

import java.util.Scanner;

public class R498_AdjRe {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for(int i=0;i<n;i++) {
			int temp=in.nextInt();
			if(temp%2==0) temp--;
			System.out.print(temp+" ");
		}
		in.close();
	}
}
