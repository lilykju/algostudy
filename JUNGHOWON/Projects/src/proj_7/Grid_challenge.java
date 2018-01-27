package proj_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grid_challenge {

	public static String grid_Challenge(String[] string_arr)
	{	
		char[] char_arr = new char[string_arr.length * string_arr.length];
		String temp_str;
		int char_index = 0;
		int    fisrt_index_sorting = 0;
		int    last_index_sorting = string_arr.length;

		int    first_char_val;
		int    second_char_val;
		int    first_val_index=0;
		boolean Check = true;

		int    count = string_arr.length;
		int    index_limit = string_arr.length ;		

		for(int i = 0; i<string_arr.length; i++)
		{
			temp_str = string_arr[i];
			for(int j=0; j<temp_str.length(); j++){
				char_arr[char_index] = temp_str.charAt(j);
				char_index += 1;
			}

			Arrays.sort(char_arr, fisrt_index_sorting, last_index_sorting); // every string_arr length, it is sorted
			fisrt_index_sorting += string_arr.length;
			last_index_sorting += string_arr.length;
		}

		//		System.out.printf("char_arr_size : %d\n" ,char_arr.length); // Sorting result check
		//		for(int i =0; i<char_arr.length; i++)
		//		{
		//			System.out.print("	" + char_arr[i]);
		//		}

		int up = 1;
		while(count > 0)
		{	
			if(Check == false)
				break;
			else
			{			
				for(int j=0; j<string_arr.length -1; j++)
				{
					first_char_val = (int)char_arr[first_val_index];
					second_char_val = (int)char_arr[first_val_index + string_arr.length];

					if(first_char_val <= second_char_val)
						first_val_index += string_arr.length;

					else
					{
						Check = false;
						break;
					}					
				}
				
				first_val_index = 0;
				first_val_index = first_val_index + up;
				up += 1;
				count = count - 1;
			}
		}
		if(Check == true)
			return "YES";
		else
			return "NO";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		int 	N_testcases;
		int 	N_Elements;
		String		result;

		input = new Scanner(System.in);
		System.out.println("Type the number of testcases  : ");
		N_testcases = input.nextInt();
		System.out.println("Type the number of elements  : ");
		N_Elements = input.nextInt();

		if((N_Elements >= 1 && N_Elements <= 100) && (N_testcases >= 1 && N_testcases <= 100))
		{				
			String[] String_arr = new String[N_Elements];
			System.out.println("Type the elements  : " + N_Elements + " (lines)");			
			for(int i = 0; i<N_Elements; i++ ){ String_arr[i] = input.next();}		
			result = grid_Challenge( String_arr );
			System.out.println(result);
		}
		else
			System.out.println("The number of N_testcases or N_testcases are not bounded between 1 to 100");

		input.close();

	}

}
