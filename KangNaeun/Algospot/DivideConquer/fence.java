package DivideConquer;

import java.util.Scanner;

public class fence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int n = in.nextInt();
			int[] f=new int[n];
			for(int i=0;i<n;i++) {
				f[i]= in.nextInt();
			}
			System.out.println(solve(f,0,f.length-1));
			
		}
		in.close();
	}
	
	static int solve(int[] f,int left,int right) {
	
		if(left==right) return f[left];
		
		int mid = (left+right)/2;
		
	
		int answer = Math.max(solve(f,left,mid), solve(f,mid+1,right));
		
		int lo=mid;
		int hi=mid+1;
		int height=Math.min(f[lo],f[hi]);
		answer=Math.max(answer,height*2);
		while(left<lo||hi<right) {
			if(hi<right&&(lo==left||f[lo-1]<f[hi+1])) {
				height=Math.min(f[++hi], height);
			}else {
				height=Math.min(f[--lo], height);
			}
			
			answer= Math.max(answer, height*(hi-lo+1));
		}
		return answer;
	}
}
