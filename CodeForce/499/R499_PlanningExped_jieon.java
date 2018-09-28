package b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class R499_PlanningExped {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		if (n > m) {
			System.out.println(0);
			in.close();
			return;
		}
		int[] food = new int[m];
		for (int i = 0; i < m; i++)
			food[i] = in.nextInt();
		Arrays.sort(food);
		ArrayList<Integer> pack = new ArrayList<>();
		int size = 1;
		for (int i = 1; i < m; i++) {
			if (food[i] == food[i - 1])
				size++;
			else {
				pack.add(size);
				size = 1;
			}
		}
		pack.add(size);
		pack.sort(new Comparator<Integer>() {
			public int compare(Integer one, Integer two) {
				return Integer.compare(two, one);
			}
		});
		int day = m / n;
		int answer=0;
		while (day > 1) {
			int count=0;
			for (int i = 0; i < pack.size(); i++) {
				if (pack.get(i) < day || count>=n)
					break;
				count+=pack.get(i)/day;
			}
			if(count>=n) {
				answer=day;
				break;
			}
			day--;
		}
		System.out.println(answer!=0?answer:1);
		in.close();
	}
}
