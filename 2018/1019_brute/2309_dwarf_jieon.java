package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class N2309_dwarf {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] tall=new int[9];
		int sum=-100;
		for(int i=0;i<9;i++) {
			tall[i]=in.nextInt();
			sum+=tall[i];
		}
		Arrays.sort(tall);
		int a=0,b=0;
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(tall[i]+tall[j]==sum) {
					a=i;
					b=j;
				}
			}
		}
		for(int i=0;i<9;i++) {
			if(i==a||i==b) continue;
			System.out.println(tall[i]);
		}
		in.close();
	}

}
