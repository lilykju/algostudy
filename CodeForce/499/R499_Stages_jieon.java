package a;

import java.util.Arrays;
import java.util.Scanner;

public class R499_Stages {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		in.nextLine();
		char[] letter=in.nextLine().toCharArray();
		Arrays.sort(letter);
		int ans=letter[0]-'a'+1;
		int before=0;
		k--;
		for(int i=1;i<n;i++) {
			if(k==0)break;
			if(letter[i]-letter[before]>1) {
				k--;
				ans+=letter[i]-'a'+1;
				before=i;
			}
		}
		System.out.println(k==0?ans:-1);
		in.close();
	}
}
