package a;

import java.util.Scanner;

public class Ed51_Password {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			StringBuffer s = new StringBuffer(in.nextLine());
			int lower = 0, upper = 0, digit = 0;
			for (int j = 0; j < s.length(); j++)
				if (s.charAt(j) <= '9')
					digit++;
				else if (s.charAt(j) <= 'Z')
					upper++;
				else
					lower++;
			int type = (digit==0)?0:4;
			type +=(upper==0)?0:2;
			type +=(lower==0)?0:1;
			if(type==1) {
				s.replace(0, 2, "S2");
			}else if(type==2) {
				s.replace(0, 2, "s2");
			}else if(type==4) {
				s.replace(0, 2, "qP");
			}else if(type==3) {
				if(upper>lower) {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) <= 'Z') {
							s.replace(j, j+1, "2");
							break;
						}
				}else {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) >= 'a') {
							s.replace(j, j+1, "2");
							break;
						}
				}
			}else if(type==5) {
				if(digit>lower) {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) <= '9') {
							s.replace(j, j+1, "P");
							break;
						}
				}else {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) >= 'a') {
							s.replace(j, j+1, "P");
							break;
						}
				}
				
			}else if(type==6) {
				if(digit>upper) {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) <= '9') {
							s.replace(j, j+1, "q");
							break;
						}
				}else {
					for(int j = 0; j < s.length(); j++)
						if(s.charAt(j) >= 'A') {
							s.replace(j, j+1, "q");
							break;
						}
				}
			}
			System.out.println(s);
		}

		in.close();
	}

}
