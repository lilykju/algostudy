package Journey_to_the_moon;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Journey_to_the_moon {

	static long journeyToMoon(int number, int[][] astronaut) {
		int[] grouping_arr = new int[number];
		Arrays.fill(grouping_arr, -1);
		ArrayList <Integer> count_num_of_possible_pair = new ArrayList<Integer>();
		int first_val = -1;
		int second_val = -1;
		int different_value_count = 0;
		int minus_one_val_count = 0;
		long possible_num = 0;

		for(int i = 0; i < astronaut.length; i++){
			for(int j = 0; j < 2; j++){
				// System.out.println(" val " + astronaut[i][j]  );
				first_val = astronaut[i][0];
				second_val = astronaut[i][1];
			//	System.out.println(" first_val " + first_val + " second_val " + second_val  );
			}
			if(grouping_arr[first_val] == -1){
				if(grouping_arr[second_val] == -1 ){
					grouping_arr[first_val] = first_val;
					grouping_arr[second_val] = first_val;
			//System.out.println(" first_val " + first_val + " second_val " + second_val  );
				}
				else
					grouping_arr[first_val] = grouping_arr[second_val]; 
			}
			else{
				if(grouping_arr[second_val] == -1 )
					grouping_arr[second_val] =	grouping_arr[first_val];
				else{ // for re_organizing , first array value is the reference !
					for(int re_organize = 0; re_organize < grouping_arr.length; re_organize++ ){
						if(grouping_arr[re_organize] == grouping_arr[second_val]){
							grouping_arr[re_organize] = grouping_arr[first_val];
						System.out.println(" re_organize val  " + re_organize  );
						}
					}
				}					
			}
		}
		
		Arrays.sort(grouping_arr);  
//		for(int aa = 0; aa<grouping_arr.length; aa++)
//		{
//			System.out.println(aa + "	" + grouping_arr[aa]);
//		}
		int initial_val = grouping_arr[0];

		for(int k = 0; k<grouping_arr.length; k++)
		{	
			if(initial_val == grouping_arr[k]){
				if(k == grouping_arr.length -1){ // exception handle 
					different_value_count += 1;
					count_num_of_possible_pair.add(different_value_count);
				}
				else
					different_value_count += 1;
			}

			else
			{	
				if(k == grouping_arr.length -1){ // exception handle 
					different_value_count += 1;
					count_num_of_possible_pair.add(different_value_count);
				}

				count_num_of_possible_pair.add(different_value_count);
				different_value_count = 1;
				initial_val =  grouping_arr[k];
				//System.out.println("initial value	" + initial_val);
			}
			if(grouping_arr[k] == -1)
				minus_one_val_count += 1;

		
		}
		int count = count_num_of_possible_pair.size() * (count_num_of_possible_pair.size() - 1) / 2;
		//System.out.println("count" + "	" + count);
		int first_index = 0 ;
		while(count > 0)
		{
			for(int n = first_index+1; n<count_num_of_possible_pair.size(); n++)
			{
				possible_num += count_num_of_possible_pair.get(first_index) *count_num_of_possible_pair.get(n);
				//System.out.println("first_Val " + count_num_of_possible_pair.get(first_index) + " second val" + count_num_of_possible_pair.get(n));
			}
			first_index += 1;
			count -= 1;
		}
//		System.out.println("possible_num" + minus_one_val_count);
		if(minus_one_val_count >= 2 ){
//			System.out.println("minus_one_val_count" + minus_one_val_count);
//			System.out.println("minus_one_val_count val" + (minus_one_val_count -1) * (minus_one_val_count) / 2 );
			possible_num = possible_num  + (long)(minus_one_val_count -1) * (minus_one_val_count) / 2 ;
//			System.out.println("possible_num" + possible_num);
			
		}
//				for(int k = 0; k<grouping_arr.length; k++)
//				{
//					System.out.println("last res" + "	" + grouping_arr[k]);
//				}
	
		return possible_num;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int pair = input.nextInt();
		int[][] astronaut = new int[pair][2];
		for(int astronaut_i = 0; astronaut_i < pair; astronaut_i++){
			for(int astronaut_j = 0; astronaut_j < 2; astronaut_j++){
				astronaut[astronaut_i][astronaut_j] = input.nextInt();
			}
		}
		long result = journeyToMoon(number, astronaut);
		System.out.println(result);
		input.close();
	}



}
