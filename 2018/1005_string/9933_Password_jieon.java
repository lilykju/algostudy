package strings;

import java.util.Scanner;

public class N9933_Password {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String[] candi=new String[n+1];
		candi[0]=in.nextLine();
		for(int i=1;i<=n;i++) {
			candi[i]=in.nextLine();
			String re=new StringBuffer(candi[i]).reverse().toString();
			int len=re.length();
			for(int j=0;j<=i;j++) {
				if(re.equals(candi[j])) {
					System.out.println(len+" "+re.charAt(len/2));
					in.close();
					return;
				}
			}
		}
		
		in.close();
	}

}
