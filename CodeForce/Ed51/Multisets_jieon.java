package c;

import java.util.Scanner;

public class Ed51_Multisets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] s=new int[n];
		int[] h=new int[101];
		char[] ans=new char[n];
		for(int i=0;i<n;i++) {
			s[i]=in.nextInt();
			h[s[i]]++;
		}
		in.close();
		int one=0,big=0;
		for(int i=1;i<=100;i++) {
			if(h[i]==1)one++;
			else if(h[i]>2)big++;
		}
		if(one%2==0) {
			one/=2;
			for(int i=0;i<n;i++) {
				if(h[s[i]]==1&&one-->0) {
					ans[i]='B';
				}else ans[i]='A';
			}
		}else if(big>0) {
			one/=2;
			big=1;
			for(int i=0;i<n;i++) {
				if(h[s[i]]==1&&one-->0) {
					ans[i]='B';
				}else if(big==1&&h[s[i]]>2){
					big=0;
					ans[i]='B';
				}else ans[i]='A';
			}
		}else {
			System.out.println("NO");
			return;
		}
		
		System.out.println("YES");
		for(int i=0;i<n;i++)
			System.out.print(ans[i]);
	}

}
