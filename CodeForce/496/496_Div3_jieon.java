package d;

import java.util.Scanner;

public class R496_Div3 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String[] n=in.nextLine().split("");
		int[] ns=new int[n.length+1];
		for(int i=1;i<=n.length;i++)
			ns[i]=Integer.parseInt(n[i-1])+ns[i-1];
		
		int ans=0;
		int si=0, ei=1;
		while(ei<ns.length) {
			for(int i=si;i<ei;i++) {
				if((ns[ei]-ns[i])%3==0) {
					ans++;
					si=ei;
					break;
				}
			}
			ei++;
		}
		System.out.println(ans);
		in.close();
	}
}
