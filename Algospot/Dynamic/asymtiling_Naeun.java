package Dynamic;

import java.util.Scanner;
import java.math.BigDecimal;

public class asymtiling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int A=1000000007;
		int test_case = in.nextInt();
		while (test_case-- > 0) {
			int n=in.nextInt();
			int[] d=new int[n/2+1];
			
			d[0]=1;
			d[1]=1;
			for(int i=2;i<=n/2;i++) {
				d[i]=(d[i-1]%A+d[i-2]%A)%A;
				
			}

			BigDecimal a=new BigDecimal(d[n/2]);
			BigDecimal answer=new BigDecimal(0);
			BigDecimal AA=new BigDecimal(A);
			BigDecimal one=new BigDecimal(1);
			answer=a.multiply(a.subtract(one));
			answer=answer.remainder(AA);
			
			if(n%2==0) {
				BigDecimal temp=new BigDecimal(d[n/2-1]);
				temp=temp.multiply(temp.subtract(one));
				temp=temp.remainder(AA);
				answer=answer.add(temp);
				answer=answer.remainder(AA);
			}else {
				BigDecimal temp=new BigDecimal(d[n/2-1]);
				temp=temp.multiply(a);
				temp=temp.remainder(AA);
				temp=temp.add(temp);
				temp=temp.remainder(AA);
				answer=answer.add(temp);
				answer=answer.remainder(AA);
			}
			System.out.println(answer);
		}
		in.close();
	}
}
