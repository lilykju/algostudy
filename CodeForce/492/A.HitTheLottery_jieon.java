package a;

import java.util.Scanner;

public class R492_HitTheLottery {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int[] type= {100, 20, 10, 5, 1};
		int answer=0;
		for(int i=0;i<5;i++) {
			answer+=m/type[i];
			m %= type[i];
		}
		System.out.println(answer);
		in.close();
	}
}
