package strings;

import java.util.Scanner;


//	시간복잡도: O(n^2)
//	공간복잡도: O(n)
//  설명: 문자가 중복되지 않으면 새 String변수에 더하고, 중복되면 2번째 뒤의 문자를 검사함
//       StringBuilder 또는 StringBuffer 이용해 중복문자를 delete하는 방법이 시간이 더 줄어들 것 같다. 
public class SuperReduced {
	static String super_reduced_string(String s){
		String reduced="";
		int p=0;
		while(p<s.length()){
			if(p==s.length()-1||s.charAt(p)!=s.charAt(p+1)) {
				reduced+=Character.toString(s.charAt(p++));
			}else {
				p+=2;
			}
		}		
		return reduced;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String s = in.next();
         while(true) {
        	String reduced=super_reduced_string(s);
        	if(!s.equals(reduced)) s=reduced;
        	else break;
        }           
        if(s=="") s="Empty String";
        System.out.println(s);
        in.close();
    }
}
