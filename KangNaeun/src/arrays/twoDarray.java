package arrays;

import java.util.Scanner;

public class twoDarray {
	//시간복잡도 : O(1)
	//공간복잡도 : O(1)
	//각 모래시계 수들 모두 비교
	public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[][] a=new int[6][6];
        for(int i=0;i<6;i++) {
        	for(int j=0;j<6;j++) {
        		a[i][j]= in.nextInt();
        	}
        }
        int ans=-63;
        for(int i=0;i<4;i++) {
        	for(int j=0;j<4;j++) {
        		int temp=a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
        		System.out.println(i+", "+j+": "+temp);
        		if(temp>ans) ans=temp;
        	}
        }
        System.out.println(ans);
    }

}
