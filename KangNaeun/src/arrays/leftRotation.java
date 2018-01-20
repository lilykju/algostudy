package arrays;

import java.util.Scanner;

public class leftRotation {
	//시간복잡도 : O(n)
	//공간복잡도 : O(n)
	//새로운 배열에 rotate된 만큼 앞당겨 저장하고 그 앞의 수들은 뒤에 저장
	static int[] LR(int[] a, int d) {
		int size = a.length;
        int[] r=new int[size];
        for(int i=0;i<d;i++) {
        	r[size-d+i]=a[i];
        }
        for(int i=d;i<size;i++) {
        	r[i-d]=a[i];
        }
		return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = LR(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
