package b;

import java.util.ArrayList;
import java.util.Scanner;

public class R501_Obtaining {
	
	static void swap(char[] s, int a,int b) {
		char temp=s[a];
		s[a]=s[b];
		s[b]=temp;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char[] s=in.next().toCharArray();
		char[] t=in.next().toCharArray();
		ArrayList<Integer> answer=new ArrayList<>();
		boolean b=false;
		for(int i=0;i<n;i++) {
			if(t[i]==s[i]) continue;
			int j;
			for(j=i+1;j<n;j++) {
				if(t[i]==s[j]) break;
			}
			if(j==n) {
				b=true; break;
			}
			for(int k=j-1;k>=i;k--) {
				answer.add(k);
				swap(s,k,k+1);
			}
		}
		if(b) {
			System.out.println(-1);
		}else {
			System.out.println(answer.size());
			for(int i:answer)
				System.out.print((i+1)+" ");
		}
		
		
		in.close();
	}
}
