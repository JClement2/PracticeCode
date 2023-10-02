/**
 * @author Jonathan Clement
 * @version 1.0
 * @since September 11th, 2023
 * 
 * This program asks the user for a number(integer)
 * and factorializes it.
 * 
 */

 import java.util.Scanner;

 public class Accumulator {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in); // Scanner to capture input
        int n;                                  // Int to hold user input

        System.out.println("Please input a number: ");
        n = input.nextInt();

        System.out.println("If you were to add all the numbers up to " + 
        n + ". You would get " + Factorial(n) + ".");     // Print result
        input.close();

    }

    /**
     * @param number to measure i against so it continues to loop until i =< n
     * @return sum of loop
     */
    public static int Factorial(int n) {
        int sum = 0;
        
        for(int i = 0; i <= n; i++) {
            sum = i + sum;
        }
        return sum;
    } 
 }