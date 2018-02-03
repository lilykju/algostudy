package greedy;

import java.util.Scanner;

public class GoodlandElectricity {
	
	static int pylons(int n,int k, int[] arr) {
		k -=1;
        int ans=0;
        boolean check=true;
        int w=0;
        while(w<n&&check) {
        	check = false;
    		for(int i=w+k;i>=w;i--) {
    			if(i>=n) i=n-1;
    			if(arr[i]==1) {
    				w = i+k+1;
    				check = true;
    				ans++;
    				break;
    			}
    		}
    		if(!check) {
    			for(int i=w-1;i>=w-k;i--) {
    				if(i<0) break;
    				if(arr[i]==1) {
        				w = i+k+1;
        				check = true;
        				ans++;
        				break;
        			}
    				
    			}
    		}
        }
        if(!check) ans=-1;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pylons(n, k, arr);
        System.out.println(result);
        in.close();
    }

}
