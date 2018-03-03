package sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
	int a;
	int w;
	Pair(int a,int w){
		this.a = a;
		this.w = w;
	}
	
	@Override
	public int compareTo(Pair t) {
        if (this.a > t.a) {
            return 1;
        } else if (this.a < t.a) {
            return -1;
        }
        return 0;
    }
}

public class LilyHW {
	
	
	
	static void swap(int[] arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	/*
	 *timeout 
	 *시간복잡도 : O(n^2)
	 * 
	static int lilysHomework(int[] arr) {
		int[] arr2=new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
        int count=0;
        //selection sort
        for(int i=0;i<arr.length-1;i++) {
        	int min=i;
        	for(int j=i;j<arr.length;j++) {
        		if(arr[min]>arr[j]) min=j;
        	}
        	if(i!=min) {
        		swap(arr,i,min);
        		count ++;
        	}
        }
    
        
        int count2=0;
      //selection sort
        for(int i=0;i<arr2.length-1;i++) {
        	int max=i;
        	for(int j=i;j<arr2.length;j++) {
        		if(arr2[max]<arr2[j]) max=j;
        	}
        	if(i!=max) {
        		swap(arr2,i,max);
        		count2 ++;
        	}
        }
        
        return (count>count2) ? count2:count;
    }
	*/
	
	static int lilysHW(PriorityQueue<Pair> pq) {
		int n=pq.size();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=pq.poll().w;
		}
		
		int[] arr2=new int[n];
		System.arraycopy(arr, 0, arr2, 0, n);
		
		int count=0;
		int i=0;
		while(i<n) {
			if(i!=arr[i]) {
				swap(arr,i,arr[i]);
				count++;
			}else {
				i++;
			}
		}
		
		int count2=0;
		i=0;
		while(i<n) {
			if(i!=n-1-arr2[i]) {
				swap(arr2,i,n-1-arr2[i]);
				count2++;
			}else {
				i++;
			}
		}
				
		return (count>count2) ? count2:count;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            pq.add(new Pair(arr[arr_i],arr_i));
        }
        int //result = lilysHomework(arr);
        result= lilysHW(pq);
        System.out.println(result);
        in.close();
    }
}
