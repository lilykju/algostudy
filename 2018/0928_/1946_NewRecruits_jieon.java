package greedy;

import java.util.Scanner;

public class N1946_NewRecruits {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int tc=in.nextInt();
		while(tc-->0) {
			int n=in.nextInt();
			int[] order=new int[n+1];
			for(int i=0;i<n;i++) 
				order[in.nextInt()]=in.nextInt();
			
			int answer=0;
			int max=n+1;
			for(int i=1;i<=n;i++) {
				if(order[i]<max) {
					answer+=1;
					max=order[i];
				}
			}
			System.out.println(answer);
		}
		in.close();
	}

}
