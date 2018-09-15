package a;

import java.util.Scanner;

public class R506_MESubstrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		String t=in.next();
		in.close();
		int s=n;
		for(int i=1;i<n;i++) {
			int j=0;
			while(i+j<n&&t.charAt(j)==t.charAt(i+j)) {
				j++;
			}
			if(i+j==n) {
				s=i;
				break;
			}
		}
		String p = (s==n)? t:t.substring(n-s, n);
		for(int i=1;i<k;i++)
			t+=p;
		System.out.println(t);
		
	}
}
