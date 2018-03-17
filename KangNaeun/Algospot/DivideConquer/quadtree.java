package DivideConquer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class quadtree {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		in.nextLine();
		while(t-->0){
			String s= in.nextLine();
			StringBuffer sb= new StringBuffer(s);
			//iterator 
			System.out.println(reverse(sb,0));
			
			//iterator 사용
			List<Character> listS=new ArrayList<Character>();
			for(int i=0;i<s.length();i++) {
				listS.add(s.charAt(i));
			}
			Iterator<Character> iterator= listS.iterator();
			System.out.println(reverseIt(iterator));
			
		}
		in.close();
	}
	
	//Iterator 사용 함수
	static String reverseIt(Iterator<Character> iterator) {
		char head = iterator.next();
		if(head!='x') return Character.toString(head);
		
		String upperLeft=reverseIt(iterator);
		String upperRight=reverseIt(iterator);
		String lowerLeft=reverseIt(iterator);
		String lowerRight=reverseIt(iterator);
		
		return "x"+lowerLeft+lowerRight+upperLeft+upperRight;
			
	}

	
	static String reverse(StringBuffer s,int index) {
		String reversed = s.substring(0,1);
		if(s.length()==1) return reversed;
		int start=++index;
		int cut=0;
		int cnt=0;
		while(cnt++<4&&index<s.length()) {
			if(cnt==3) cut=index;
			if(s.charAt(index)=='x') {
				String xs=reverse(s,index);
				s.replace(index, index+xs.length(), xs);
				index += xs.length()-1;
			}
			index++;
		}
		
		reversed += s.substring(cut, index);
		reversed += s.substring(start, cut);
		
		return reversed;
	}
	
	
}
