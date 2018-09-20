package e;

import java.util.Scanner;

public class R481_Bus {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int w=in.nextInt();
		int[] change=new int[n];
		for(int i=0;i<n;i++) {
			change[i]=in.nextInt();
		}
		int state=0;
		int min=0;
		int max=0;
		for(int i=0;i<n;i++) {
			state+=change[i];
			if(state<min) min=state;
			if(state>max) max=state;
		}
		max -=min;
		if(max>w) System.out.println(0);
		else System.out.println((w-max+1));
		in.close();
	}

}
