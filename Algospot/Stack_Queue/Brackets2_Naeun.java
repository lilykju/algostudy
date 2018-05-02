package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class Brackets2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			char[] c=in.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			String answer="YES";
			for(int i=0;i<c.length;i++) {
				if(c[i]=='('||c[i]=='{'||c[i]=='[') {
					stack.push(c[i]);
				}else{
					if(stack.isEmpty()) {
						answer="NO";
						break;
					}
					char temp=stack.pop();
					if((temp=='('&&c[i]!=')')||(temp=='{'&&c[i]!='}')||(temp=='['&&c[i]!=']')) {
						answer="NO";
						break;
					}
				}
			}
			if(!stack.isEmpty()) {
				answer="NO";
			}
			System.out.println(answer);
		}
		in.close();
	}
}
