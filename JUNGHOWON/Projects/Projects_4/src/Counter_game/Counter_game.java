package Counter_game;
import java.util.*;

public class Counter_game {

	static String counterGame(long n) {
		// Complete this function
		int count = 0;
		if(n == 1)
			return "Richard";
		else{
			while(true)
			{
				if(IsPowerOfTwo(n) == true){					
					while(n != 1)
					{
						n = n/2;
						count += 1;
					}
					break;
				}
				else{						
					n -= find_n(n);					
					//System.out.println(n);
					count += 1;				
				}
			}
		
			if(count % 2 == 0)
				return "Richard";				
			else
				return "Louise";		
		}
	}

	public static Boolean IsPowerOfTwo (long n) // distinguish whether a number is PowerofTwo or not
	{
		while (((n % 2) == 0) && n > 1) /* While x is even and > 1 */
		{	n /= 2; }
		return (n == 1);
	}
	
	public static long find_n(long prev_n)     
	{	
		long new_n = 1;		
		while(prev_n > new_n){ new_n *= 2;	}
		new_n /= 2;
		return new_n;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = input.nextLong();
			String result = counterGame(n);
			System.out.println(result);
		}
		input.close();
	}

}
