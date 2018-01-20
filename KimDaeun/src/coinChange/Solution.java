package coinChange;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int m;
    static long getWays(long n, long[] c){
    	if(n<c[0]) return 0;
    	if(n==c[0]) return 1;
    	int temp=0;
    	for(int i=0;i<m;i++) {
    		if(c[i]<n) temp+=getWays(n-c[i], c);
    		if(c[i]==n) temp+=1;
    	}
		return temp;
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}