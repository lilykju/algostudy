package DivideConquer;

import java.util.Scanner;

public class fanmeeting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		while (t-- > 0) {
			String m = in.nextLine();
			String n = in.nextLine();

			smallcase(m,n);
		}
		in.close();
	}
	
	static void smallcase(String m,String n) {
		//너무 큰수
		long member = 0;
		long fan = 0;
		for (int i = 0; i < m.length(); i++) {
			if (m.charAt(i) == 'M')
				member += 1 << i;
			if (n.charAt(i) == 'M')
				fan += 1 << i;
		}
		int answer = 0;
		if ((member & fan) == 0)
			answer++;
		
		if (m.length() != n.length()) {
			long last= 1 << (m.length()-1);
			for (int i = m.length(); i < n.length(); i++) {			
				fan /=2 ;
				if (n.charAt(i) == 'M')
					fan += last;
				if ((member & fan) == 0)
					answer++;
			}
		}
		System.out.println(answer);
	}
}
