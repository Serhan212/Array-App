import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        boolean begin = true;

        while (begin) {
            System.out.println("---- Menu ----");
            System.out.println("1. Create a random array");
            System.out.println("2. Find array's maximum and minimum");
            System.out.println("3. Find array's average and difference from average");
            System.out.println("4. Find the sum of elements with odd and even numbered indexes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                // Create a random array
                System.out.print("Enter the size of the array: ");
                int size = scanner.nextInt();
                array = createRandomArray(size);
            } else if (choice == 2) {
                // Find array's maximum and minimum
                if (array == null) {
                    System.out.println("Please create an array first.");
                } else {
                    // Find maximum and minimum
                    int max = findMax(array);
                    int min = findMin(array);
                    System.out.println("Maximum: " + max);
                    System.out.println("Minimum: " + min);

                }
            } else if (choice == 3) {
                // Find array's average and difference from average
                if (array == null) {
                    System.out.println("Please create an array first.");
                } else {
                    // Find average and difference from average
                    double average = findAverage(array);
                    double[] differences = findDifferences(array, average);
                    System.out.println("Average: " + average);
                    System.out.println("Differences from average:");
                    for (double diff : differences) {
                        System.out.println(diff);
                    }
                }
            } else if (choice == 4) {
                // Find the sum of elements with odd and even numbered indexes
                if (array == null) {
                    System.out.println("Please create an array first.");
                } else {
                    // Find the sum of elements with odd and even numbered indexes
                    int oddSum = findOddSum(array);
                    int evenSum = findEvenSum(array);
                    System.out.println("Sum of elements with odd indexes: " + oddSum);
                    System.out.println("Sum of elements with even indexes: " + evenSum);
                }
            } else if (choice == 5) {
                // Exit
                begin = false;
                System.out.println("Exiting the program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static int[] createRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }
    
    //Average of array
    public static double findAverage(int[] arr) {
        double sum = 0;
        for(int num: arr) {
            sum += num;
        }
        //Average
        return sum / arr.length;
    }
    //find the array's min
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //find the array's max
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Difference between number in array and average
    public static double[] findDifferences(int[] arr, double avg) {
        double[] differenceArr =  new double[arr.length];
        for(int i = 0; i < arr.length; i++) {
            differenceArr[i] = Math.round((arr[i] - avg) * 10) /10 ;
        }
        return differenceArr;
    }
}
