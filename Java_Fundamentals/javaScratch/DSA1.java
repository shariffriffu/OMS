
import java.util.Arrays;

public class DSA1 {
    public static void main(String[] args) {
        // problem1();
        problem2();
        problem3();
        problem4();
    }

    public static void problem1() {
        System.out.println("====================Problem 1============");
        int[] numbers = { 12, 5, 27, 9, 18 };
        int largest = numbers[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            System.out.println("number is " + numbers[i]);
            if (largest < numbers[i]) {
                secondLargest = largest;
                largest = numbers[i];
                System.out.println("largest number is " + largest);
            } else if (numbers[i] < largest && numbers[i] > secondLargest) {
                secondLargest = numbers[i];
            }
        }
        System.out.println("largest number is " + largest + " and second largest number is " + secondLargest);
        System.out.println("====================Problem 1 end ============");
    }

    public static void problem2() {
        System.out.println("====================Problem 2============");
        int[] numbers = { 2, 3, 2, 5, 3, 2 };
        int target = 3;
        int count = 0;

        //
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {
                count++;
            }

        }
        System.out.println(
                target + " appears " + count + " times in the array");
        System.out.println("====================Problem 2 end ============");
    }

    public static void problem3() {
        System.out.println("====================Problem 3 Reverse an Array============");
        int[] numbers = { 10, 20, 30, 40, 50 };
        int[] reversed = new int[numbers.length];

       reverseInPlace(numbers, reversed);

        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Reversed array: " + Arrays.toString(reversed));
        System.out.println("====================Problem 3 end ============");
    }

    private static void reverseInPlace(int[] numbers, int[] reversed) {
        // TODO Auto-generated method stub
        for (int i = 0; i < numbers.length; i++) {
            reversed[numbers.length - 1 - i] = numbers[i];
        }
        throw new UnsupportedOperationException("Unimplemented method 'reverseInPlace'");
    }

    public static void problem4() {
        System.out.println("====================Problem 4 second smallest number============");
        int[] numbers = { 12, 5, 27, 9, 18 };
        int smallest = numbers[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            System.out.println("number is " + numbers[i]);
            if (smallest > numbers[i]) {
                System.out.println("smallest number is " + smallest);
                secondSmallest = smallest;
                smallest = numbers[i];
            }else if (numbers[i] > smallest && numbers[i] < secondSmallest) {
                secondSmallest = numbers[i];
            }
            // else if(){

            // }

        }
        System.out.println("second smallest number is " + secondSmallest + " and smallest number is " + smallest);
        System.out.println("====================Problem 4 end ============");

    }
}
