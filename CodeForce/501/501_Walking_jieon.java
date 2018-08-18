package d;

import java.util.Scanner;

public class R501_Walking {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		long s=in.nextLong();
		if(s<k||((s-1)/(n-1)>=k)){
			System.out.println("NO");
			in.close();
			return;
		}
		System.out.println("YES");
		s -= k;
		boolean up=true;
		int now=1;
		for(int i=0;i<k;i++) {
			int walk=1;
			if(s>=n-2) {
				walk+=n-2;
				s-= n-2;
			}else {
				walk+=(int)s;
				s=0;
			}
			if(!up) walk=-walk;
			now += walk;
			up = !up;
			System.out.print(now+" ");
		}
		
		in.close();
	}
}
