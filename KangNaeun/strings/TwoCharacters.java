package strings;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoCharacters {
	
	static boolean checkTwo(String s) {
 		for(int i=0;i<s.length()-1;i++) {
 			if(s.charAt(i)==s.charAt(i+1)) {
 				return false;
 			}
 		}
 		return true;
 	}
	
	static int twoCharaters(String s) {
		int maxL=0;
		ArrayList<Character> chars=new ArrayList<Character>();
		for(int i=0;i<s.length();i++) {
			if(!chars.contains(s.charAt(i)))
				chars.add(s.charAt(i));
		}
		for(int i=0;i<chars.size()-1;i++) {
			for(int j=i+1;j<chars.size();j++) {
				String rege = "[^"+chars.get(i)+chars.get(j)+"]";
				String reduced= s.replaceAll(rege, "");
				if(checkTwo(reduced)) {
					if(maxL<reduced.length()) maxL=reduced.length();
				}
			}
		}		
        return maxL;
    }	

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();	
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
	    
}
