package dynamic;

import java.util.Scanner;
import java.math.*;

public class FibonacciModified {
	//시간복잡도 : O(N)
	//공간복잡도 : O(N)
	static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] d=new BigInteger[n];
        d[0]=BigInteger.valueOf(t1);
        d[1]=BigInteger.valueOf(t2);
        for(int k=2;k<n;k++) {
        	d[k]=d[k-1].multiply(d[k-1]).add(d[k-2]);
        }
        return d[n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);
        in.close();
    }
}
