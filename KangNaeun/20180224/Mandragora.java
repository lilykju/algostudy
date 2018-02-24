package dynamic;

import java.util.Arrays;
import java.util.Scanner;

/*
public class Mandragora {
	
	//만약 순서가 고정이라면
	static long mandragora(int n, int[] H) {
		
		//d[i][j] : i번째 만드라고라까지, j번 먹었을 때 P의 최댓값  
		//d[i][0] : d[i-1][0]+H[i]
		//d[i][j]=max(d[i-1][j]+H[i]*(j+1),d[i-i][j-1])
		long[][] d = new long[n][n+1];
		d[0][0]=H[0];	
		d[0][1]=0;
		for(int i=1;i<n;i++) {
			d[i][0]= d[i-1][0]+H[i];
			for(int j=1;j<=i;j++) {
				d[i][j]= Math.max(d[i-1][j]+H[i]*(j+1),d[i-1][j-1]);
			}
			d[i][i+1]=0;
		}		
		
		long max=0;
		for(int i=0;i<n;i++) {
			if(max<d[n-1][i]) max = d[n-1][i];
		}		
		
		return max;
    }
*/
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] H = new int[n];
            long sum=0;
            for(int H_i = 0; H_i < n; H_i++){
                H[H_i] = in.nextInt();
                sum += H[H_i];
            }
           
            Arrays.sort(H);  
            
            long answer =0;        
            for(int i=0;i<n;i++) {
            	long a=sum*(i+1);
            	if(answer<a) answer = a;
            	sum -= H[i];
            }
            System.out.println(answer);
        }
        in.close();
    }
}
