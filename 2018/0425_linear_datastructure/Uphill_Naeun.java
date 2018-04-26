package arrays;

import java.util.Scanner;

public class Uphill {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt();
		int[] road=new int[n];
		for(int i=0;i<n;i++) {
			road[i]=in.nextInt();
		}
		
		int nowH=road[0];
		int answer=0;
		for(int i=1;i<n;i++) {
			if(road[i-1]>=road[i]) {
				nowH=road[i];
			}else {
				if(answer<road[i]-nowH){
					answer=road[i]-nowH;
				}
			}
		}
		System.out.println(answer);
		
		in.close();
	}
}
