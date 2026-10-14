import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

/**
 * DSA@
 */
public class DSA2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target number: ");
        int target = sc.nextInt();

        Set<Integer> seen = new HashSet<>();

        for (int number : arr) {
            int need = target - number;
            if (seen.contains(need)) {
                System.out.println(need + " + " + number + " = " + target);
            } else {
                seen.add(number);
            }
        }

    }
}