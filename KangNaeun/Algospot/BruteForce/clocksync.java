package BruteForce;

import java.util.Scanner;

public class clocksync {
	
	static int SWITCH = 10;
	static int INF = 9999;

	static int[][] switches= {{0,1,2,-1,-1},{3,7,9,11,-1},{4,10,14,15,-1},{0,4,5,6,7},{6,7,8,10,12},
			{0,2,14,15,-1},{3,14,15,-1,-1},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13}};
	
	static boolean areAligned(int[] clocks) {
		for(int i=0;i<clocks.length;i++) {
			if(clocks[i]!=0) return false;
		}
		return true;
	}
	
	static void push(int[] clocks, int snum) {
		for(int i=0;i<5;i++) {
			if(switches[snum][i]!=-1) {
				clocks[switches[snum][i]] += 1;
				if(clocks[switches[snum][i]]==4) clocks[switches[snum][i]]=0;
			}
		}
	}

<<<<<<< HEAD
	
=======
>>>>>>> 89d4a3552000a49b6debb94ab08375e3145ad383
	static int solve(int[] clocks, int snum) {
		if(areAligned(clocks)) return 0;
		if(snum==SWITCH) return INF;
		int ret = INF;
		for(int cnt = 0; cnt< 4; ++cnt) {
			ret = Math.min(ret, cnt+solve(clocks, snum+1));
<<<<<<< HEAD
			//4¹øÈ£Ãâ -> ¿ø»óÅÂ
=======
			//4Â¹Ã¸ÃˆÂ£ÃƒÃ¢ -> Â¿Ã¸Â»Ã³Ã…Ã‚
>>>>>>> 89d4a3552000a49b6debb94ab08375e3145ad383
			push(clocks, snum);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t= in.nextInt();
		while(t-->0) {
			
			int[] clocks=new int[16];
			for(int i=0;i<16;i++) {
				clocks[i]=in.nextInt()/3;
				if(clocks[i]==4)  clocks[i]=0;
			}
			
			int answer= solve(clocks,0);
			if(answer==INF) System.out.println(-1);
			else System.out.println(answer);
		}
		in.close();
	}
	
	
}
