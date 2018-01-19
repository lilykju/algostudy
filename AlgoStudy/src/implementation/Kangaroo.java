package implementation;

import java.util.Scanner;

public class Kangaroo {

	//시간복잡도 : O(1)
	//공간복잡도 : O(1)
	//x2-x1가 v1-v2의 배수인 경우 YES
	static String kangaroo(int x1, int v1, int x2, int v2) {
		//0<x1<x2<10000
		String ans="NO";
        if(v1>v2) {
        	if((x2-x1)%(v1-v2)==0) ans="YES";
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
