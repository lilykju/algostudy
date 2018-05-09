
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int binarysearch(ArrayList<Integer> v, int len, int key) {
        int left = 0;
        int right = len - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (v.get(mid) == key) {
                return mid;
            } else {
                if (key > v.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws NullPointerException {
        ArrayList<Integer> set1 = new ArrayList<>(200000);
        ArrayList<Integer> set2 = new ArrayList<>(200000);

        Scanner sc = new Scanner(System.in);
        int numOfSet1 = sc.nextInt();
        int numOfSet2 = sc.nextInt();
        int tmp;

        for (int i = 0; i < numOfSet1; ++i) {
            set1.add(sc.nextInt());
        }

        
        Collections.sort(set1);

        for (int i = 0; i < numOfSet2; ++i) {
            set2.add(sc.nextInt());
        }
        
        Collections.sort(set2);

        int result = 0;

        for (int i = 0; i < numOfSet1; ++i) {
            if(-1 == binarysearch(set2, numOfSet2, set1.get(i))) {
                result++;
            }

        }

        for (int j = 0; j < numOfSet2; ++j) {
            if (-1 == binarysearch(set1, numOfSet1, set2.get(j))) {
                result++;
            }
        }

        System.out.println(result);
    }
}
