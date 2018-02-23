package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimumLoss {
	static long MAX = 999999999999999L;
	
	//타임아웃
	//시간복잡도 : O(n)+ 정렬 시간
	//공간복잡도 : O(n)
	static long minimumLoss(long[] price) {
        ArrayList<Long> a = new ArrayList<>();
        for(int i=0;i<price.length;i++) {
        	a.add(price[i]);
        }
        Collections.sort(a);
        
        long min = a.get(0);
        for(int i=0;i<price.length-1;i++) {
        	long p = price[i];
        	int index= a.indexOf(p);
        	if(index ==0) continue;
        	long sub = p- a.get(index-1);
        	if(min>sub) min = sub;
        	a.remove(index);
        }
		
		return min;
    }
	
		
	//재귀
	//시간복잡도 : O(n^2)			머지소트 시간,공간 복잡도는?
	//공간복잡도 : O(n^2)
	static long reLoss(ArrayList<Long> a) {
		if(a.isEmpty()) return MAX;
		ArrayList<Long> high = new ArrayList<>();
		ArrayList<Long> low = new ArrayList<>();
		long first=a.get(0);
		long min= MAX;
		for(int i=1;i<a.size();i++) {
			long k = a.get(i);
			if(k>first) high.add(k);
			else {
				low.add(k);
				if(min>first-k) min = first-k;
			}
		}
		
		long lossH = reLoss(high);
		long lossL = reLoss(low);
		if(lossH<min) min = lossH;
		if(lossL<min) min = lossL;
		
		return min;
	}
	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        for(int price_i = 0; price_i < n; price_i++){
        	a.add(in.nextLong());
        }
        long result = reLoss(a);
        System.out.println(result);
        in.close();
    }
}
