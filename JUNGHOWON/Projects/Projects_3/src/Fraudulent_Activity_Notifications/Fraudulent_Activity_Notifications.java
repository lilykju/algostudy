package Fraudulent_Activity_Notifications;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Fraudulent_Activity_Notifications { 
	
	public static final int not_possible = 0;

	public static ArrayList<Integer> delete_val (ArrayList<Integer> minimum_days_data , int deleted_val)
	{	
		if(deleted_val > 100){
			for(int i=minimum_days_data.size()-1; i>=0; i--)
			{
				if(minimum_days_data.get(i) == deleted_val){
					minimum_days_data.remove(i);
					break;
				}
			}
		}
		else
		{
			for(int i=0; i<minimum_days_data.size(); i++)
			{
				if(minimum_days_data.get(i) == deleted_val){
					minimum_days_data.remove(i);
					break;
				}
			}
		}
		return minimum_days_data;
	}

	public static ArrayList<Integer> add_val (ArrayList<Integer> minimum_days_data , int add_val)
	{	
		if(add_val > 100){

			if(add_val >= minimum_days_data.get(minimum_days_data.size() - 1))
				minimum_days_data.add(add_val);
			else if(add_val <= minimum_days_data.get(0))
				minimum_days_data.add(0 , add_val);
			else{
				for(int i=minimum_days_data.size()-1; i>=0; i--)
				{
					if(minimum_days_data.get(i) <= add_val){
						minimum_days_data.add(i+1, add_val);
						break;
					}
				}
			}
		}
		else
		{	
			if(add_val >= minimum_days_data.get(minimum_days_data.size() - 1))
				minimum_days_data.add(add_val);
			else if(add_val <= minimum_days_data.get(0))
				minimum_days_data.add(0 , add_val);
			else{
				for(int i=0; i<minimum_days_data.size(); i++)
				{
					if(minimum_days_data.get(i) >= add_val){
						minimum_days_data.add(i-1, add_val);
						break;
					}
				}
			}
		}
		return minimum_days_data;
	}


	public static int activityNotifications(int[] expenditure, int minimum_days_for_noti) {

		ArrayList<Integer> minimum_days_data = new ArrayList<Integer>();
		int noti_count = 0;
		int compare_index = 0;
		int deleted_val = 0;
		double median_value = 0;		
		Boolean odd_even_check = false; // if even is true otherwise it is false!

		if(expenditure.length < minimum_days_for_noti) 
			return not_possible;
		else{
			if(minimum_days_data.size() == 0) // for the very first case ! 
			{
				for(int i = 0; i<minimum_days_for_noti; i++){ minimum_days_data.add( expenditure[i]); }
				deleted_val = expenditure[0]; 
				Collections.sort(minimum_days_data);

				if(minimum_days_data.size() % 2 == 0){
					median_value = ((minimum_days_data.get(minimum_days_data.size()/2) + minimum_days_data.get(minimum_days_data.size()/2 - 1))) / 2.0;
					odd_even_check = true;
				}
				else{
					median_value = (minimum_days_data.get(minimum_days_data.size()/2));
					odd_even_check = false;	
				}
			}

			//			for(int i = 0; i< minimum_days_data.size(); i++)
			//			{	
			//				System.out.println("median_value:" + median_value);				
			//				System.out.println("i val :" + i + " val: " + minimum_days_data.get(i));
			//				//System.out.println("compared_val:" +expenditure[compare_index]);	
			//			}
			compare_index = minimum_days_for_noti;
			for(int Compare_index=compare_index; Compare_index<expenditure.length; Compare_index++)
			{
				if(median_value*2 <=expenditure[compare_index])
					noti_count += 1;		

				if(odd_even_check == false)
				{						
					minimum_days_data	= delete_val(minimum_days_data , deleted_val);
					deleted_val = minimum_days_data.get(0);
					minimum_days_data	= add_val(minimum_days_data , expenditure[Compare_index]);				
					median_value = (minimum_days_data.get(minimum_days_data.size()/2));					
				}

				else
				{	
					minimum_days_data	= delete_val(minimum_days_data , deleted_val);
					deleted_val = minimum_days_data.get(0);
					minimum_days_data	= add_val(minimum_days_data , expenditure[Compare_index]);		
					median_value = ((minimum_days_data.get(minimum_days_data.size()/2) + minimum_days_data.get(minimum_days_data.size()/2 - 1))) / 2.0;
				}
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