import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target number: ");
        int target = sc.nextInt();

        Set<Integer> seen = new HashSet<>();

        for (int number : arr) {

            int needed = target - number;

            if (seen.contains(needed)) {
                System.out.println(needed + " + " + number + " = " + target);
            }

            seen.add(number);
        }

        sc.close();
    }
}