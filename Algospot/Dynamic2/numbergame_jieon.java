package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class numbergame {
	
	static int EMPTY = -987654321;
	static int n;
	static int[] board;
	static int[][] cache;

	static int play(int left, int right) {
		if(left>right) return 0;
		int ret=cache[left][right];
		if(ret!=EMPTY) return ret;
		ret=Math.max(board[left]-play(left+1,right), board[right]-play(left,right-1));
		if(right-left+1>=2) {
			ret=Math.max(ret, -play(left+2,right));
			ret=Math.max(ret, -play(left,right-2));
		}
		
		return cache[left][right]=ret;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0) {
			n=Integer.parseInt(br.readLine().trim());
			board=new int[n];
			cache=new int[n][n];
			String[] s=br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				board[i]=Integer.parseInt(s[i]);
				Arrays.fill(cache[i], EMPTY);
			}
			System.out.println(play(0,n-1));
		}
	}
}
