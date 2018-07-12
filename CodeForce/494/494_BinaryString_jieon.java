package b;

import java.util.Scanner;

public class R494_BinaryString {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int x=in.nextInt();
		
		boolean zero=a>b;
		StringBuilder ans=new StringBuilder();
		
		for(int i=1;i<x;i++) {
			if(zero) {
				ans.append("0");
				a--;
			}
			else {
				ans.append("1");
				b--;
			}
			zero= !zero;
		}
		
		if(zero) {
			while(a-->0) ans.append("0");
			while(b-->0) ans.append("1");
		}else {
			while(b-->0) ans.append("1");
			while(a-->0) ans.append("0");
		}
		
		System.out.println(ans);
		in.close();
	}
}
