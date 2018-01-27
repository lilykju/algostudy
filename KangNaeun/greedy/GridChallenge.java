package greedy;

import java.util.Arrays;
import java.util.Scanner;

//	시간복잡도 : O(n^2)
//  설명 : i행 정렬을 한 후 j열에서 i-1행의 값보다 작으면 false 
public class GridChallenge {
	static boolean gridChallenge(String[] grid,int n) {
        int[][] c=new int[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		c[i][j]=grid[i].charAt(j)-'a';
        	}
        	Arrays.sort(c[i]);
        	if(i==0) continue;
        	for(int j=0;j<n;j++) {
        		if(c[i-1][j]>c[i][j]) return false;
        	}
        }        
		return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->=0) {
	        int n = in.nextInt();
	        String[] grid = new String[n];
	        for(int grid_i = 0; grid_i < n; grid_i++){
	            grid[grid_i] = in.next();
	        }
	        String result = gridChallenge(grid,n)? "YES" : "NO";
	        System.out.println(result);
        }
        in.close();
    }
}
