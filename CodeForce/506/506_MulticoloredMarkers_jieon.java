package f;

import java.util.Scanner;

public class R506_MulticoloredMarkers {
	
	static boolean isRec(long one, int a, long b) {
		for(int i=a;i>0;i--) {
			if(one%i==0) {
				if(one/i<=b) return true;	
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long one=in.nextLong();
		long two=in.nextLong();
		long sum=one+two;
		one=Math.min(one, two);
		in.close();
		long answer=0;
		for(int i=(int)Math.sqrt(sum);i>0;i--) {
			if(sum%i==0) {
				long a=sum/i;
				if(isRec(one,i,a)||isRec(sum-one,i,a)) {
					answer=(i+a)*2;
					break;
				}
			}
		}
		System.out.println(answer);

	}

}
