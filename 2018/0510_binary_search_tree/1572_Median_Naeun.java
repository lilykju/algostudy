package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1572_Median {
	
	static ArrayList<Integer> subset;
	
	static int search(int low, int high, int target) {
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(subset.get(mid)==target) return mid;
			else if(subset.get(mid)>target) high=mid-1;
			else low=mid+1;
			
		}
		return low;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int m = (k - 1) / 2;
		int[] value = new int[n];
		subset = new ArrayList<>();
		long answer = 0;
		
		for (int i = 0; i < n; i++) {
			value[i] = in.nextInt();
			if (i < k) {
				subset.add(value[i]);
				if (i + 1 == k) {
					Collections.sort(subset);
					answer += subset.get(m);
				}
			} else {
				subset.remove((Integer)value[i-k]);
				subset.add(search(0,k-2,value[i]), value[i]);
				answer += subset.get(m);
			}
		}
		System.out.println(answer);
		in.close();
	}
}
