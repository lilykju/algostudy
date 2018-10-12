package b;

import java.util.Scanner;

public class R511_CoverPoint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int answer=0;
		for(int i=0;i<n;i++) {
			int x=in.nextInt(), y=in.nextInt();
			if(x+y>answer) answer = x+y;
		}
		System.out.println(answer);
		in.close();

	}

}
