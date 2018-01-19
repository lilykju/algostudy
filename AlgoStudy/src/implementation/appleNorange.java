package implementation;

import java.util.Scanner;

public class appleNorange {
	//시간복잡도 : O(A+B)
	//공간복잡도 : O(A+B)
	static int[] appleAndOrange(int s, int t, int a, int b, int[] apple, int[] orange) {
        int[] ans= new int[2];
		int a_s=s-a, a_t=t-a, b_s=s-b, b_t=t-b;
		for(int i=0;i<apple.length;i++) {
			if(a_s<=apple[i]&&apple[i]<=a_t) ans[0]++;
		}
		for(int i=0;i<orange.length;i++) {
			if(b_s<=orange[i]&&orange[i]<=b_t) ans[1]++;
		}
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        int[] result = appleAndOrange(s, t, a, b, apple, orange);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
