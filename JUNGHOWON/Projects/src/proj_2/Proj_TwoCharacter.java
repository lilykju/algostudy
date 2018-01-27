package proj_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Proj_TwoCharacter {

	private static final int OVER_1000_CHAR  = -1;
	private static final int CONVER_NOT_POSSIBLE  =  0;
	private static final int ONLY_ONE_CHAR  =  1;
	private static final int ONLY_ONE_CHAR_DUP  =  7;

	public static int Convert_Check(ArrayList<Character> Char_arr)
	{	
		boolean duplicate_check = false; 

		for(int j=0; j<Char_arr.size(); j++)
		{	
			if(j != Char_arr.size() -1 )
			{
				if(Char_arr.get(j) == Char_arr.get(j+1)){
					duplicate_check = true;
					break;
				}	
			}

			else // for the last character 
			{
				if(Char_arr.get(j-1) == Char_arr.get(j)){
					duplicate_check = true;	
					break;
				}
			}

		}
		if(duplicate_check == true)
			return CONVER_NOT_POSSIBLE;
		else if(duplicate_check == false && Char_arr.size() == 2)
			return Char_arr.size();
		else
			return Char_arr.size();
	}

	public static int TwoCharacters(String input_str)
	{	
		int char_diff_count = 0;
		char temp_char = 'A';		
		ArrayList<Character> char_arr = new ArrayList<Character>();
		ArrayList<Character> char_copied_arr = new ArrayList<Character>();
		ArrayList<Character> char_return_arr = new ArrayList<Character>();
		ArrayList<Integer>   compare_value = new ArrayList<Integer>(); // for getting a max value 

		ArrayList<Character> unique_char_arr = new ArrayList<Character>();
		//HashSet<Character> char_hash_set = new HashSet<Character>();

		if(input_str.length() > 1000 )// if input is over 100 
			return OVER_1000_CHAR;

		else if(input_str.length() == ONLY_ONE_CHAR) // if input is just one character 
			return ONLY_ONE_CHAR;

		else
		{	
			for(int i = 0; i<input_str.length(); i++) // storing at Arraylist for each character 
			{				
				char_arr.add(i, input_str.charAt(i));				//char_hash_set.add(input_str.charAt(i));				
			}

			unique_char_arr = new ArrayList<Character>(new HashSet<Character>(char_arr)); // hashset 형태의 unique_array create
//			System.out.println("size :" + unique_char_arr.size());

			if(unique_char_arr.size() == 1)
				return ONLY_ONE_CHAR_DUP;

			else if(unique_char_arr.size() == 2) // two different charachters exist , no need to delete 
				return Convert_Check(char_arr);				

			else //more two different charachters exist
			{					
				int count = (unique_char_arr.size()) * (unique_char_arr.size() - 1) / 2; // the number of cases 					
				int k=0;
				int index=0;

				while(count > 0)
				{			
					int count_2 = 0;		
					count = count -1; // considering all cases 
					char_diff_count = unique_char_arr.size(); // for checking the number of different character is 2 or not				

					for(int a = 0; a< char_arr.size(); a++){ char_copied_arr.add(char_arr.get(a));}	 // for copying and calculating combination 				
					Combination c = new Combination(unique_char_arr); 
					c.doCombination(unique_char_arr.size() , unique_char_arr.size() - 2 , 0);
					char_return_arr = c.Get_Store_Return_charArr();
					
//					System.out.println("k values  "+ k );	
//					for(int a = 0; a< char_copied_arr.size(); a++){System.out.println("first arr_size "+ char_copied_arr.size() + " " + "values " + char_copied_arr.get(a));				}	
//					System.out.println("returned arr_size "+ char_return_arr.size() );				
					
					index = k;
					for(; k < char_return_arr.size(); k++) // for deleting element 
					{	
						temp_char = char_return_arr.get(k);
//						System.out.println("temp_char values  "+ temp_char );	
//						for(int m=0; m<char_copied_arr.size(); m++)
//						{
//							System.out.println("char_copied_arr values  " +"[" + m + "]" + char_copied_arr.get(m));							
//						}	
						for(int m=char_copied_arr.size()-1; m>=0 ; m--)
						{					
							if(temp_char == char_copied_arr.get(m))
								char_copied_arr.remove(m);	        // if a letter is repeated in a row , it can't be deleted.						
						}	
						count_2 += 1; // count for internal case 
						if(count_2 == unique_char_arr.size() - 2){
							k = index + unique_char_arr.size() - 2;
							break;
						}
					}	
//					System.out.println("k values  "+ k );	
//					for(int a = 0; a< char_copied_arr.size(); a++){System.out.println(" second arr_size "+ char_copied_arr.size() + " " + "values " + char_copied_arr.get(a));				}	
//					System.out.println("returned arr_size "+ char_return_arr.size() );	
					
					char_diff_count = char_diff_count - count_2 ;

					if(char_diff_count == 2)
					{	
						if(Convert_Check(char_copied_arr) != CONVER_NOT_POSSIBLE)
							compare_value.add(Convert_Check(char_copied_arr));
						else
							compare_value.add(CONVER_NOT_POSSIBLE);
					}
					
					char_copied_arr.clear(); //important
				}
				return Collections.max(compare_value);
			}

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		String  s;
		int		result;
		int 	Length;

		while(true)
		{	
			System.out.println("Type the string without space : (wanna quit, press 'q')");
			input = new Scanner(System.in);
			s = input.next();
			Length = s.length();

			if(s.equals("q"))
			{
				System.out.println("end");					
				break;
			}
			else{
				System.out.println("Typed String : "+ s );
				System.out.println("String length: "+ Length );

				result = TwoCharacters(s);
				if(result == OVER_1000_CHAR )
					System.out.println("Result : " + CONVER_NOT_POSSIBLE + "\n" + "Input string length is over 1000 (should be less than that)" + "\n" );
				else if(result == ONLY_ONE_CHAR )
					System.out.println("Result : " + CONVER_NOT_POSSIBLE + "\n" + "There is only one character after conversion (should be at least more than 2 )" + "\n" );	
				else if(result == ONLY_ONE_CHAR_DUP )
					System.out.println("Result : " + CONVER_NOT_POSSIBLE + "\n" + "There is only one character after conversion(DUP) (should be at least more than 2 )" + "\n" );		
				else if(result == CONVER_NOT_POSSIBLE)
					System.out.println("Result : " + CONVER_NOT_POSSIBLE + "\n" + "Conversion is not possible " + "\n" );
				else 
					System.out.println("Result(Conversion_possible) :" + " " + result + "\n");
			}
		}
		input.close();
	}

}
