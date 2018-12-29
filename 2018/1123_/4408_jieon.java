package study;

import java.util.Scanner;

public class N4408_MatchRoom {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int TC=in.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			int N=in.nextInt();
			int[][] room=new int[N][2];
			for(int i=0;i<N;i++) {
				room[i][0]=(in.nextInt()+1)/2;
				room[i][1]=(in.nextInt()+1)/2;
			}

			int answer=0;
			int[] over=new int[201];
			for(int i=0;i<N;i++) {
				int start=Math.min(room[i][0], room[i][1]);
				int end=Math.max(room[i][0], room[i][1]);
				for(int k=start;k<=end;k++) {
					over[k]++;
				}
			}
			for(int k=1;k<201;k++) {
				if(answer<over[k]) answer=over[k];
			}
			
			
			System.out.println("#"+tc+" "+answer);
		}
		in.close();
	}

}
