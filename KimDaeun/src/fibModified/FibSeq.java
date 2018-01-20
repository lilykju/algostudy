package fibModified;

import java.math.BigInteger;
import java.util.Scanner;

public class FibSeq {
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Complete this function
    	
    	BigInteger arr2[] = new BigInteger[n];
    	arr2[0]=BigInteger.valueOf(t1);
    	arr2[1]=BigInteger.valueOf(t2);
    	
    	for(int i=2;i<n;i++)
    	{
    		arr2[i] = arr2[i-1].multiply(arr2[i-1]);
    		arr2[i] = arr2[i].add(arr2[i-2]);
    	}
//    	
//    	int arr[]= new int[n];
//    	arr[0]=t1;
//    	arr[1]=t2;
//    	for(int i=2;i<n;i++)
//    	{
//    		arr[i]=arr[i-1]*arr[i-1]+arr[i-2];
//    	}
    	return arr2[n-1];
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
