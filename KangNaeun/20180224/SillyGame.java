package game;

import java.util.Scanner;

public class SillyGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			boolean[] c = new boolean[n+1];
			int prime =0;
			for(int i=2;i<=n;i++) {
				if(!c[i]) {
					prime++;
					for(int j=i;j<=n;j+=i) {
						c[j]=true;
					}
				}
			}
			String answer;
			if(prime%2==1) answer="Alice";
			else answer="Bob";
			System.out.println(answer);
		}
		in.close();
	}
}
