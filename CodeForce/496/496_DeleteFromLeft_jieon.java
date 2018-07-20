package b;

import java.util.Scanner;

public class R496_DeleteFromLeft {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		StringBuffer sb1=new StringBuffer(in.nextLine());
		StringBuffer sb2=new StringBuffer(in.nextLine());
		
		int le1=sb1.length();
		int le2=sb2.length();
		
		sb1=sb1.reverse();
		sb2=sb2.reverse();

		int i;
		for(i=0;i<Math.min(le1, le2);i++) {
			if(sb1.charAt(i)!=sb2.charAt(i)) break;
		}
		
		System.out.println((le1+le2-i*2));
		in.close();
	}
}
