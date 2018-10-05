package strings;

import java.util.Scanner;

public class N1120_String {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String A=in.next(), B=in.next();
		int max=0;
		
		for(int k=0;k<=B.length()-A.length();k++) {
			int temp=0;
			for(int i=0;i<A.length();i++) {
				if(A.charAt(i)==B.charAt(i+k)) temp++;
			}
			if(temp>max) 
				max=temp;	
		}

		System.out.println((A.length()-max));
		
		in.close();

	}

}
