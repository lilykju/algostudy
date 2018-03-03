package dynamic;

//import java.util.ArrayList;
import java.util.Scanner;

public class Candies {
	
	
	/*
	static long candies(int n, int[] arr) {
        ArrayList<Integer> a=new ArrayList<>();
        boolean temp_up=false;
        boolean same=false;
        int temp_size=1;
        for(int i=1;i<n;i++) {
        	if(arr[i-1]<arr[i]) {
        		if(temp_up) {
        			temp_size++;
        		}else {
        			System.out.println(i+" "+temp_size);
        			//감소하는 크기가 더 클 경우
        			if(!a.isEmpty()&&a.get(a.size()-1)<=temp_size&&!same) {
        				
        				int t=a.get(a.size()-1)-1;
        				a.remove(a.size()-1);
        				if(t!=0) a.add(t);
        				temp_size++;
        			}
        			a.add(-temp_size);
        			temp_up=true;
        			temp_size=1;
        			same=false;
        		}
        	}else if(arr[i-1]>arr[i]){
        		if(temp_up) {
        			a.add(temp_size);
        			temp_up=false;
        			temp_size=1;
        			same=false;
        		}else {
        			temp_size++;
        		}
        	}else {
        		if(temp_up) {
        			a.add(temp_size);
        		}else {
        			//감소하는 크기가 더 클 경우
        			if(!a.isEmpty()&&a.get(a.size()-1)<=temp_size&&!same) {
        				
        				int t=a.get(a.size()-1)-1;
        				a.remove(a.size()-1);
        				if(t!=0) a.add(t);
        				temp_size++;
        			}
        			a.add(-temp_size);
        		}
        		temp_up=false;
        		temp_size=1;
        		same=true;
        	}
        }
        //마지막
        if(temp_up) {
        	a.add(temp_size);
        }else {
        	if(!a.isEmpty()&&a.get(a.size()-1)<=temp_size&&!same) {
				int t=a.get(a.size()-1)-1;
				a.remove(a.size()-1);
				if(t!=0) a.add(t);
				temp_size++;
			}
			a.add(-temp_size);
        }
        long answer=0;
        for(int i:a) {
        	System.out.println("i : "+i);
        	if(i<0) {
        		answer += ((long)i*i-i)/2;
        	}else {
        		answer += (i+3)*i/2;
        	}
        	System.out.println(answer);
        }
        return answer;
    }
*/
	
	static long d_candies(int n, int[] arr) {
		
		int[] d=new int[n];
		d[0]=1;
		for(int i=1;i<n;i++) {
			if(arr[i-1]<arr[i]) {
        		d[i]=d[i-1]+1;
        	}else if(arr[i-1]>arr[i]){
        		int temp=i;
        		while(arr[temp-1]>arr[temp]) {
        			temp++;
        			if(temp>=n||arr[temp-1]<=arr[temp]) {
        				temp--;
        				break;
        			}
        		}
        		d[temp]=1;
        		for(int k=temp-1;k>=i;k--) d[k]=d[k+1]+1;
        		if(d[i-1]<d[i]+1) d[i-1]=d[i]+1;
        		i=temp;
        	}else {
        		d[i]=1;
        	}
		}
		long answer=0;
		for(int i=0;i<n;i++) {
			answer += d[i];
		}
		return answer;
	}
	
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = d_candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
