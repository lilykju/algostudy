package array2D;

import java.util.Scanner;

public class Array2D {
	
	public static int arr[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		arr = new int[6][6];
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int result[] = new int[16];	
		int count=0;
		int ans=-100;
		int tempX=0, tempY=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				result[count] = hourglass(i,j);
				if(result[count]>ans) {
					ans=result[count++];
					tempX=i; tempY=j;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	public static int hourglass(int startX, int startY) {
		int sum =0;
		sum = arr[startX][startY] + arr[startX][startY+1] + arr[startX][startY+2] + 
				arr[startX+2][startY] + arr[startX+2][startY+1] + arr[startX+2][startY+2] + 
				arr[startX+1][startY+1];
		return sum;
	}

}
