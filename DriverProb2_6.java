/*

Lab 1 - Problem 2.6

Created by nickcarrozza on 1/26/17.

*/

import java.util.Scanner;


public class DriverProb2_6 {

    public static void main(String[] args) {

        System.out.println("Enter a number between 0 and 1000: ");

        Scanner input = new Scanner(System.in);

        int userNumber = input.nextInt();


        if (userNumber > 1000 || userNumber < 0) {

            System.out.println("Sorry, please enter a number above or equal to 0 and below or equal to 1000.");


        } else {

            int ans = 0;

            while (userNumber > 0) {

                ans = ans + userNumber % 10;

                userNumber = userNumber / 10;

            }

            System.out.println("The sum of the digits is: " + ans);

        }
    }
}