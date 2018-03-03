package search;

import java.util.Arrays;
import java.util.Scanner;

public class RadioTrans {
	static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int count=0;
        int index;
        for(int i=0;i<x.length;i++) {
        	index=i;
        	while(index+1<x.length) {
        		if(x[index+1]-x[i]<=k) {
        			index++;
        		}else break;
        	}
        	i=index;
        	count ++;
        	while(index+1<x.length) {
        		if(x[index+1]-x[i]<=k) {
        			index++;
        		}else break;
        	}
        	i=index;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);
        in.close();
    }
}
