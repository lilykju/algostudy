package d;

import java.util.Scanner;

public class R481_progression {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] m=new int[n];
		for(int i=0;i<n;i++) {
			m[i]=in.nextInt();
		}
		int answer=n==1?0:n+1;
		for(int i=-1;i<2;i++) {			
			for(int j=-1;j<2;j++) {
				if(answer==0)break;
				if((m[n-1]-m[0]-i+j)%(n-1)==0) {
					int mok=(m[n-1]-m[0]-i+j)/(n-1);
					int before=i;
					int count=Math.abs(i);
					for(int k=1;k<n;k++) {
						before = m[k-1]+before+mok-m[k];
						System.out.println(mok+" "+i+" "+j+" "+before);
						if(before<-1||before>1) {
							count=-1;
							break;
						}
						if(before!=0) count++;
					}
					if(count==-1) break;
					System.out.println(mok+" "+i+" "+j+" "+count);
					if(before==j&&answer>count) answer=count;
				}
			}
		}
		System.out.println(answer==n+1?-1:answer);
		in.close();
	}

}
