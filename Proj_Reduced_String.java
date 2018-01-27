package proj_1;

import java.io.*;
import java.util.*;


public class Proj_Reduced_String {

	public static String Super_reduced_string(String s)
	{			
		char letter;
		char pre_del_letter = 0 ;	
		String res = "";
		int j=0;
		int k = 0;
		ArrayList<Character> char_arr = new ArrayList<Character>();
		
		if(s.length() >= 100 )// if input is over 100 
			return "str_length is over 100  ";

		else if(s.length() == 1) // if input is just one character 
			return s;

		else // for the remaining cases , from front to back 
		{
			for(int i = 0; i<s.length(); i++) // storing at Arraylist for each character
			{				
				char_arr.add(i, s.charAt(i)); 
			}			

			for(; j<char_arr.size(); j=k)
			{			
				letter = char_arr.get(j);		
				if( j + 1 != char_arr.size())
				{
					if(char_arr.get(j+1) == letter)
					{					
						k = j;
						pre_del_letter = letter;					
						char_arr.remove(j+1);
						char_arr.remove(j);					
					}
					
					else					
						k += 1;					
				}		
				
				else // for the last one !
				{						
					if(char_arr.size() >=2 && char_arr.get(char_arr.size()-1) == char_arr.get(char_arr.size()-2))  // from back to front 
					{
						char_arr.remove(char_arr.size() - 2);
						char_arr.remove(char_arr.size() - 1);
					}
					if(pre_del_letter == letter && char_arr.size() == 1)// only one letter left which is the same as pre_del_letter
						char_arr.remove(j);	
					else
						break;					
				}
			}							
		}

		for(int m=0; m<char_arr.size(); m++){
			res  += char_arr.get(m); 
		}

		if(res.length() == 0)
			return "Empty String";
		else
			return res;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner input;
		String  s;
		String result;
		
		while(true)
		{	
			System.out.println("Type the string  without space : (wanna quit, press 'q')");
			input = new Scanner(System.in);
			s = input.next();
			
			if(s.equals("q")){
				System.out.println("end");
				break;
			}
			else{
				result = Super_reduced_string(s);
				System.out.println("Result :" + " " + result);
			}
		}
		input.close();
	}


}
