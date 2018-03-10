package bitmanipulation;

import java.util.Scanner;

public class CounterGame {
	static String counterGame(long n) {
        int count=0;
        while(n>0)
        {
        	n &= (n-1);
        	count++;
        }
        return (count%2==1)? "Louise":"Richard";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(counterGame(n-1));
        }
        in.close();
    }
}
