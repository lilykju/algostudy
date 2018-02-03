package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {
	
	
	static ArrayList<Integer> attempted(String[] pass, String next, boolean[] d) {
		ArrayList<Integer> ss=new ArrayList<>();
		int nl=next.length();
		for(int i=0;i<pass.length;i++) {		
			int l=pass[i].length();
			if(nl<l) continue;
			if(next.startsWith(pass[i])&&!d[nl-l]) {				
				if(nl==l) {
					ss.add(i);
					break;
				}
				ArrayList<Integer> temp=attempted(pass, next.substring(l),d);
				if(!temp.isEmpty()) {
					ss.add(i);
					ss.addAll(temp);
					break;
				}else {
					d[nl-l]=true;
				}
			}
		}
		return ss;
	}
	
	static String passwordCracker(String[] pass, String attempt) {
        String answer="";
        boolean[] d=new boolean[2000];
        ArrayList<Integer> a= attempted(pass, attempt,d);
        
        if(a.isEmpty()) {
        	answer="WRONG PASSWORD";
        }else {
        	for(int i=0;i<a.size();i++) {
        		answer += pass[a.get(i)]+" ";
        	}
        }       
        return answer;
    }

	
	public static String[] makePass(String[] pass) {
		ArrayList<String> a=new ArrayList<>();
		for(int i=0;i<pass.length;i++) {
			boolean[] d= new boolean[10];
			String temp=pass[i];
			pass[i]="0";
			if(attempted(pass,temp,d).isEmpty()) {
				pass[i]=temp;
				a.add(pass[i]);
				//System.out.println(pass[i]);
			}
		}
		String[] p=new String[a.size()];
		for(int i=0;i<a.size();i++) {
			p[i]=a.get(i);
		}
		return p;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            String[] pass = new String[n];
            for(int pass_i = 0; pass_i < n; pass_i++){
                pass[pass_i] = in.next();
            }
            String attempt = in.next();
            String result = passwordCracker(makePass(pass), attempt);
            System.out.println(result);
        }
        in.close();
    }

}
