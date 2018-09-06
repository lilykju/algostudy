package a;

import java.util.Scanner;

public class R73_Trains {

	public static void main(String[] agrs) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		boolean bigger=false;
		if(a>b) {
			bigger=true;
			int temp=a;
			a=b;
			b=temp;
		}
		long nextB=b;
		long totalB=a;
		while(nextB%a!=0) {
			totalB += nextB%a;
			System.out.println(totalB+ " "+ nextB);
			nextB +=b;
			
		}
		long totalA=nextB-totalB;
		String answer;
		if(totalA==totalB) answer = "Equal";
		else if((!bigger&&totalA>totalB)||(bigger&&totalB>totalA)) answer = "Dasha";
		else answer = "Masha";
		
		System.out.println(answer);
	
		in.close();
	}
}
