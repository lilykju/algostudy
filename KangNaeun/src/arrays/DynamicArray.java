package arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
	//시간복잡도 : O(N+Q)
	//공간복잡도 : O(N)
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int lastans=0;
        List<Integer>[] seq=(List<Integer>[])new List[n];
        for(int i=0;i<n;i++) {
        	seq[i]= new ArrayList<Integer>();
        }
        for(int i=0;i<q;i++) {
        	int num=sc.nextInt();
        	int x=sc.nextInt();
        	int y=sc.nextInt();
        	int s=(x^lastans)%n;
        	if(num==1) {
        		seq[s].add(y);
        	}else {
        		lastans=seq[s].get(y%seq[s].size());
        		System.out.println(lastans);
        	}
        }
    }
}
