/*

Lab 1 - Problem 2.1

Created by nickcarrozza on 1/24/17.

*/

;

import java.util.Scanner;

public class DriverProb2_1 {

    //main function
    public static void main(String[] args) {

        System.out.print("Enter a value in degrees celcius:");

        Scanner input = new Scanner(System.in);

        double celcius = input.nextDouble();

        double farenheit = (1.8 * celcius) + 32;

        System.out.println(celcius + " Celcius is "+ farenheit + " degrees farenheit");

    }
}