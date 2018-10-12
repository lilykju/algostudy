package a;

import java.util.Scanner;

public class R511_LoveThree {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.close();

		if((n-2)%3!=0) {
			System.out.println(1+" "+1+" "+(n-2));
		}else {
			System.out.println(1+" "+2+" "+(n-3));
		}
	
	}

}
