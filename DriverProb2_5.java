/*

Lab 1 - Problem 2.5

Created by nickcarrozza on 1/24/17

*/



import java.util.Scanner;


public class DriverProb2_5 {

    //main function
    public static void main(String[] args) {

        System.out.print("Enter the subtotal and a gratuity rate :");

        Scanner input = new Scanner(System.in);

        double subtotal = input.nextDouble();

        int tipPercent = input.nextInt();

        double gMultiplier = (tipPercent * .01);

        double gratuity = gMultiplier * subtotal;

        double total = subtotal + gratuity;


        System.out.print("The gratuity is " + gratuity + " and total is " + total);

    }
}
