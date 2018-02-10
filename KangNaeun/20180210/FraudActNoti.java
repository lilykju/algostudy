package sorting;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


public class FraudActNoti {
	
	//크기 d만큼 정렬된 배열 sorted에 값을 넣어주며 진행
	static int activityNotifications(int[] ex, int n, int d) {
        int answer=0;
        
        ArrayList<Integer> sorted=new ArrayList<>();	//정렬된 배열
        for(int k=0;k<d;k++) {
        	sorted.add(ex[k]);
        }
        Collections.sort(sorted);
        
        
        int mid=d/2;

        
        //시간복잡도 O(n*d)
        for(int i=d;i<n;i++) {
        	if(d%2==0) {
        		if(ex[i]>=(sorted.get(mid)+sorted.get(mid-1))) answer++;
        	}else {
        		if(ex[i]>=sorted.get(mid)*2) answer++;
        	}
        	
        	sorted.remove((Integer)ex[i-d]);
        	int s=0;
        	while(s<d-1) {
        		if(sorted.get(s)>ex[i]) break;
        		s++;
        	}
        	sorted.add(s, ex[i]);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, n, d);
        System.out.println(result);
        in.close();
    }
}
