package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	//시간복잡도 : O(nm)
	//공간복잡도 : O(nm)
	//d[i][j] : i번째 동전까지 사용해 j원을 만드는 경우의 수
	static long getWays(int n, int[] c){
        int size=c.length;
        Arrays.sort(c);
        long[][] d=new long[size+1][n+1];
        d[0][0]=1;
        for(int i=1;i<=size;i++) {
        	for(int j=0;j<=n;j++) {
        		d[i][j]=d[i-1][j];	//i번째 동전 사용하지 않음
        		if(j-c[i-1]>=0) {
        			d[i][j] += d[i][j-c[i-1]];	//i번째 동전 사용
        		}
        	}
        }
        return d[size][n];
    }
/*
 * 위의 2차원을 1차원으로 변경  
 * static long getWays(int n, int[] c){
        int size=c.length;
        Arrays.sort(c);
        long[] d=new long[n+1];
        d[0]=1;
        for(int i=1;i<=size;i++) {
        	for(int j=0;j<=n;j++) {
        		if(j-c[i-1]>=0) {
        			d[j] += d[j-c[i-1]];	//i번째 동전 사용
        		}
        	}
        }
        return d[size][n];
    }
 * 
 * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
