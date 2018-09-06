package b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class R323_OnceAgain {

	static int getLongest(int[] arr,int from,int to) {
		int[] longest=new int[to-from+2];
		int last=0;
		longest[0]=0;
		for (int i = from; i <= to; i++) {
			for (int j = last; j >= 0; j--) {
				if (arr[i] >= longest[j]) {
					longest[j + 1] = arr[i];
					if (j == last)
						last++;
					//System.out.println(i+" "+j+" "+longest[j+1]+" "+last);
					break;
				}
			}
		}
		//System.out.println(from+" "+to+" "+last);
		return last;
	}
	
	public static void main(String[] agrs) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int t=in.nextInt();
		int[] arr=new int[n];
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {  
            public int compare(Integer one, Integer two) {                         
                return Integer.compare(arr[one],arr[two]);  
            }      
        });  
		for(int i=0;i<n;i++) {
			arr[i]=in.nextInt();
			pq.add(i);
		}
		int[] sorted=new int[n];
		int[][] d=new int[n+1][n+1];
		int[] sum=new int[n+1];
		sum[0]=sum[1]=-1;
		int m=1;
		int p=0;
		while(!pq.isEmpty()) {
			sorted[p]=pq.poll();
			if(p!=0&&arr[sorted[p]]!=arr[sorted[p-1]]) {
				m++;
				sum[m]=sum[m-1];
			}
			d[m][m]++;
			sum[m]++;
			//System.out.println(m+" "+sorted[p]+" "+sum[m]+" "+d[m][m]);
			p++;
		}
		sum[m]=sum[m-1]+d[m][m];
		m+=1;
		//System.out.println(m);
		for(int i=1;i<m-1;i++) {
			for(int j=i+1;j<m;j++) {
				d[i][j]=getLongest(sorted,sum[i-1]+1,sum[j]);
			}
		}
		int[][] dd=new int[t][m];
		for(int i=1;i<m;i++)dd[0][i]=d[1][i];
		int longest=0;
		for(int k=1;k<t;k++) {
			for(int i=1;i<m;i++) {
				for(int j=1;j<=i;j++) {
					dd[k][i]=Math.max(dd[k][i], dd[k-1][j]+d[j][i]);
				}
				if(k==t-1) longest=Math.max(longest,dd[k][i]);
			}
		}
		
		System.out.println(longest);
		in.close();
	}
}
