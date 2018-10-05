package strings;

import java.util.Scanner;

public class N9996_MissKorea {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		String s=in.nextLine();
		String[] p=s.split("\\*");
		String[] ans=new String[n];
		for(int t=0;t<n;t++) {
			String target=in.nextLine();
			if(target.length()>=s.length()-1&&target.startsWith(p[0])&&target.endsWith(p[1])) ans[t]="DA";
			else ans[t]="NE";
		}
		for(int t=0;t<n;t++) {
			System.out.println(ans[t]);
		}
		in.close();

	}

}
