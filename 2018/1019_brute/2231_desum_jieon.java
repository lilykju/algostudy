package bruteforce;

import java.util.Scanner;

public class N2231_desum {
	
	static int sum(int x) {
		int ret=0;
		while(x>0) {
			ret+=x%10;
			x/=10;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		in.close();
		int l=(int)(Math.log10(N)+1);
		int i=(N-l*9>0)?N-l*9:1;
		int ans=0;
		for(;i<N;i++) {
			if((i+sum(i))==N) {
				ans=i;
				break;
			}
		}
		System.out.println(ans);
	}

}
