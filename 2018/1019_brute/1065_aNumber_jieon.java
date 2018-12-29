package bruteforce;

import java.util.Scanner;

public class N1065_aNumber {
	
	static int solve(int N) {
		int ans=(N<100)?N:99;
		for(int i=111;i<=N;i++) {
			if((i/100-(i/10)%10)==((i/10)%10-i%10)) ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		in.close();
		int ans=0;
		if(N<100) {
			ans = N;
		}else if(N==1000){
			ans= 144;
		}else {
			int a=N/100, c=N%10;
			int b=(N/10)%10;
			ans =99+(a-1)*5;
			for(int i=1;i<b;i++) {
				if((2*i-a)>=0&&(2*i-a)<=9) ans++;
			}
			if((2*b-a)>=0&&(2*b-a)<=c)ans++;
		}
		System.out.println(ans);
	}

}
