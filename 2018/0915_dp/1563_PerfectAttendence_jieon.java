package dynamic;

import java.util.Scanner;

public class N1563_PerfectAttendence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.close();
		int mod=1000000;
		long[][] d=new long[n+1][2];
		d[0][0]=d[0][1]=1;
		d[1][0]=d[1][1]=2;
		for(int i=2;i<n;i++) {
			d[i][0]=(d[i-1][0]+d[i-1][1])%mod;
			d[i][1]=(d[i-1][0]+d[i-2][0])%mod;
		}
		
		long answer = d[n-1][0]+d[n-1][1];
		for(int i=0;i<n;i++) {
			answer +=(d[i][0]*d[n-1-i][0])%mod;
			answer%=mod;
		}
		System.out.println(answer);
	}
	
	static void s1(int n) {
		long sum = 0;
	    long[][] jigak0 = new long[n+1][2] ; // 지각이 없는 경우, 0은 출석 1은 결석
	    long[] jigak1 = new long[n+1]; // 지각이 1번인 경우, n번째에 지각이 들어가는 경우를 저장
	   
	    jigak0[0][0]=1;
	    //Arrays.fill(jigak0[0], 1);
	    jigak0[1][0] = jigak0[1][1] = 1;
	    jigak0[2][0] = jigak0[2][1] = 2;
	    
	    int i;
	    for(i = 3 ; i <= n; i++){
	      jigak0[i][0] = jigak0[i-1][0] + jigak0[i-1][1];
	      jigak0[i][1] = jigak0[i-1][0] + jigak0[i-2][0];
	      if(jigak0[i][0] >= 1000000)
	        jigak0[i][0] %= 1000000;
	      if(jigak0[i][1] >= 1000000)
	        jigak0[i][1] %= 1000000;
	    }
	    
	    sum = jigak0[n][0] + jigak0[n][1];
	    
	    for(i = 1; i <= n; i++){
	    
	      jigak1[i] = (jigak0[i-1][0] + jigak0[i-1][1]) * (jigak0[n-i][0] + jigak0[n-i][1]);
	      sum += jigak1[i];
	      if(sum >= 1000000)
	        sum %= 1000000;
	    }
	    
	    System.out.println(sum%1000000);
	}
	
	static void s2(int n) {
		int mod=1000000;
		long[][] d=new long[n+1][2];
		d[0][0]=d[0][1]=1;
		d[1][0]=d[1][1]=2;
		for(int i=3;i<n;i++) {
			d[i][0]=(d[i-1][0]+d[i-1][1])%mod;
			d[i][1]=(d[i-1][0]+d[i-2][0])%mod;
		}
		
		long answer = d[n-1][0]+d[n-1][1];
		for(int i=0;i<n;i++) {
			answer+=(d[i][0]*d[n-1-i][0])%mod;
			answer%=mod;
		}
		
		
		System.out.println(answer);
	}
	
	
}
