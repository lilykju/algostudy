package b;

import java.util.ArrayList;
import java.util.Scanner;

public class R481_FileName {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int n=in.nextInt();
		in.nextLine();
		/*char[] name=new char[n];
		name=in.nextLine().toCharArray();*/
		String name=in.nextLine();
		
		int answer=0;
		for(int i=0;i<name.length()-2;i++) {
			answer += name.substring(i, i+3).equals("xxx")?1:0;
		}
		System.out.println(answer);
		in.close();
	}
}
