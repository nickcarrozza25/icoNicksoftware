/*

Lab 1 - Question 2

Created by nickcarrozza on 1/25/17.

*/


import java.util.Scanner;

public class DriverQuest2 {

    //main function
    public static void main (String[] args) {

        System.out.println("Please enter the following as percentage ...");

        Scanner input = new Scanner(System.in);

        System.out.print("midterm exam: ");

        double midVal = input.nextDouble();

        System.out.print("final exam: ");

        double finalVal = input.nextDouble();

        System.out.print("projects: ");

        double projects = input.nextDouble();

        System.out.print("homework and labs: ");

        double hwLab = input.nextDouble();


        double avg = ((midVal * .2) + (finalVal * .2) + (projects * .2) + (hwLab * .4));

        System.out.print("Your final grade is: " + avg + "%");


    }

}
