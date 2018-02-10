package Fraudulent_Activity_Notifications;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Fraudulent_Activity_Notifications_1 { 

	public static final int not_possible = 0;	
	public static LinkedList<Integer> from_0_to_100 = new LinkedList<Integer>();	
	public static LinkedList<Integer> from_101_to_200 = new LinkedList<Integer>();
//	public static int from_0_to_100_size = 0;
//	public static int from_101_to_200_size = 0;
	public static int total_arr_size = 0 ;

	public static LinkedList<Integer> delete_val (LinkedList<Integer> minimum_days_data_for_noti , int deleted_val) //
	{	
		for(int i=minimum_days_data_for_noti.size()-1; i>=0; i--)
		{
			if(minimum_days_data_for_noti.get(i) == deleted_val){
				minimum_days_data_for_noti.remove(i);
			//	System.out.println("deleted_val	" +  deleted_val);
			//	System.out.println("minimum_days_data_for_noti	size " +  minimum_days_data_for_noti.size());
				break;
			}
		}		
		return minimum_days_data_for_noti;
	}

	public static LinkedList<Integer> add_val (LinkedList<Integer> minimum_days_data_for_noti , int add_val)
	{	
		if(minimum_days_data_for_noti.size() == 0)
			minimum_days_data_for_noti.add(add_val);
		else if(add_val >= minimum_days_data_for_noti.get(minimum_days_data_for_noti.size() - 1))
			minimum_days_data_for_noti.add(add_val);
		else if(add_val <= minimum_days_data_for_noti.get(0))
			minimum_days_data_for_noti.add(0 , add_val);
		else{
			for(int i=minimum_days_data_for_noti.size()-1; i>=0; i--)
			{
				if(minimum_days_data_for_noti.get(i) <= add_val){
					minimum_days_data_for_noti.add(i+1, add_val);
					
					break;
				}
			}
		}
		return minimum_days_data_for_noti;
	}


	public static int activityNotifications(int[] expenditure, int minimum_days_for_noti) {

		//LinkedList<Integer> minimum_days_data = new LinkedList<Integer>();
		//LinkedList<Integer> minimum_days_data = new LinkedList<Integer>();
		int noti_count = 0;
		int compare_index = 0;
		int deleted_val = 0;
		int median_value_index_1 = 0;
		int median_value_index_2 = 0;
		float median_value = 0;		
		int from_0_to_100_size = 0;
		int from_101_to_200_size = 0;
		Boolean odd_even_check = false; // if even is true otherwise it is false!

		if(expenditure.length < minimum_days_for_noti) 
			return not_possible;
		else{
			if(from_0_to_100.size() == 0 && from_101_to_200.size() == 0 ) // for the very first case ! 
			{
				for(int i = 0; i<minimum_days_for_noti; i++){

					if(expenditure[i] >= 0 && expenditure[i]<=100) // store the value from 0 to 100 value
					{
						from_0_to_100.add(expenditure[i]);
					//	System.out.println("ADDED VAL AT FROM_0_TO_100 ARRAY	" +  expenditure[i]);

					}
					else {								   // for the remaining !
						from_101_to_200.add(expenditure[i]);	
					//	System.out.println("ADDED VAL AT from_101_to_200 ARRAY	" +  expenditure[i]);
					}
				}

				Collections.sort(from_0_to_100);
				Collections.sort(from_101_to_200);

				from_0_to_100_size = from_0_to_100.size();
				from_101_to_200_size = from_101_to_200.size();				
				total_arr_size = from_0_to_100_size + from_101_to_200_size;
			//	System.out.println("total array size	" + total_arr_size);

				if(total_arr_size % 2 == 0){			   // Array size is an even number ! 
					median_value_index_1 = total_arr_size / 2;
					median_value_index_2 = total_arr_size / 2 - 1;

			//		System.out.println( "median_value_index_2	" + median_value_index_2 + "	median_value_index_1	" + median_value_index_1);
					if(total_arr_size <= 4){
						if(from_0_to_100_size  > median_value_index_1)
							median_value = (float) (( from_0_to_100.get(median_value_index_1 ) +  from_0_to_100.get(median_value_index_2 ) ) / 2.0);
					}

					else{
						if(from_0_to_100_size  > median_value_index_1)
							median_value = (float) (( from_0_to_100.get(median_value_index_1 -1) +  from_0_to_100.get(median_value_index_2 -1 ) ) / 2.0);
						else if(from_0_to_100_size == median_value_index_1)
							median_value = (float) (( from_0_to_100.get(from_0_to_100_size - 1) +  from_0_to_100.get(from_0_to_100_size - 2) ) / 2.0);
						else if(from_0_to_100_size == median_value_index_2)
							median_value = (float) (( from_0_to_100.get(from_0_to_100_size - 1) +  from_101_to_200.get(0) ) / 2.0);
						else
							median_value = (float) (( from_101_to_200.get(median_value_index_2 - from_0_to_100_size - 1) +  from_101_to_200.get(median_value_index_2 - from_0_to_100_size ) ) / 2.0);
			//			System.out.println( "median_value	" + median_value );
						odd_even_check = true;
					}
				}
				else{   									// Array size is an odd number ! 
					median_value_index_1 = total_arr_size / 2;
					if(from_0_to_100_size  > median_value_index_1){
						median_value = from_0_to_100.get(median_value_index_1 );
			//			System.out.println("median_value : "+ median_value);
					}
					else if(from_0_to_100_size  == median_value_index_1)
						median_value = from_0_to_100.get(from_0_to_100_size - 1);
					else
						median_value = from_101_to_200.get(median_value_index_1 - from_0_to_100_size - 1);
					odd_even_check = false;	
				}
			}

			compare_index = minimum_days_for_noti;
			int index = 0;
			for(int Compare_index=compare_index; Compare_index<expenditure.length; Compare_index++)
			{	

				deleted_val = expenditure[index];						//set the deleted val 
				//deleted_val_array.add(expenditure[compare_index]);		//add the deleted val 
				if(median_value*2 <=expenditure[compare_index])
					noti_count += 1;		
				// ============================================================================================================================
				if(odd_even_check == false)
				{	
					if(deleted_val >= 0 && deleted_val <= 100)			{		
			//			System.out.println("deleted_val	" +  deleted_val);// for deleting 
						from_0_to_100	= delete_val(from_0_to_100 , deleted_val);
			//			System.out.println("from_0_to_100 size after delete_val func	" + from_0_to_100.size());
					}
					else
						from_101_to_200	= delete_val(from_101_to_200 , deleted_val);

					if( expenditure[Compare_index] >= 0 &&  expenditure[Compare_index] <= 100){		// for adding
			//			System.out.println("ADDED VAL AT FROM_0_TO_100 ARRAY	" +  expenditure[Compare_index]);
						from_0_to_100	= add_val(from_0_to_100 , expenditure[Compare_index]);
						

					}
					else
						from_101_to_200	= add_val(from_101_to_200 , expenditure[Compare_index]);					

					total_arr_size = from_0_to_100.size() + from_101_to_200.size();  //**			// for median value **
					median_value_index_1 = total_arr_size / 2; 
			//		System.out.println("median_value_index_1	" +  median_value_index_1);
			//		System.out.println("from_0_to_100_size	" +  from_0_to_100_size);
					from_0_to_100_size = from_0_to_100.size();
					from_101_to_200_size = from_101_to_200.size();
					if(from_0_to_100_size  > median_value_index_1)
						median_value = from_0_to_100.get(median_value_index_1 );
					else if(from_0_to_100_size  == median_value_index_1)
						median_value = from_0_to_100.get(from_0_to_100_size - 1);
					else
						median_value = from_101_to_200.get(median_value_index_1 - from_0_to_100_size - 1);

				}

				else
				{	
					if(deleted_val >= 0 && deleted_val <= 100)
						from_0_to_100	= delete_val(from_0_to_100 , deleted_val);
					else
						from_101_to_200	= delete_val(from_101_to_200 , deleted_val);

					if( expenditure[Compare_index] >= 0 &&  expenditure[Compare_index] <= 100)
						from_0_to_100	= add_val(from_0_to_100 , expenditure[Compare_index]);
					else
						from_101_to_200	= add_val(from_101_to_200 , expenditure[Compare_index]);	

					total_arr_size = from_0_to_100.size() + from_101_to_200.size();  //**
					median_value_index_1 = total_arr_size / 2;
					median_value_index_2 = total_arr_size / 2 - 1;

					if(total_arr_size <= 4){
						if(from_0_to_100_size  > median_value_index_1)
							median_value = (float) (( from_0_to_100.get(median_value_index_1 ) +  from_0_to_100.get(median_value_index_2 ) ) / 2.0);
					}

					else{
						if(from_0_to_100_size  > median_value_index_1)
							median_value = (float) (( from_0_to_100.get(median_value_index_1 -1) +  from_0_to_100.get(median_value_index_2 -1 ) ) / 2.0);
						else if(from_0_to_100_size == median_value_index_1)
							median_value = (float) (( from_0_to_100.get(from_0_to_100_size - 1) +  from_0_to_100.get(from_0_to_100_size - 2) ) / 2.0);
						else if(from_0_to_100_size == median_value_index_2)
							median_value = (float) (( from_0_to_100.get(from_0_to_100_size - 1) +  from_101_to_200.get(0) ) / 2.0);
						else
							median_value = (float) (( from_101_to_200.get(median_value_index_2 - from_0_to_100_size - 1) +  from_101_to_200.get(median_value_index_2 - from_0_to_100_size ) ) / 2.0);
					}
				}

				index += 1;
				//deleted_val_array.remove(0);							// delete zero index value, it's already deleted
			}
			return noti_count;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number_of_days = input.nextInt();
		int minimum_days_for_noti = input.nextInt();
		int[] expenditure = new int[number_of_days];
		for(int expenditure_i = 0; expenditure_i < number_of_days; expenditure_i++){
			expenditure[expenditure_i] = input.nextInt();
		}
		int result = activityNotifications(expenditure, minimum_days_for_noti);
		System.out.println(result);
		input.close();
	}


}