/**
 * Created by nickcarrozza on 3/10/17.
 */

import java.util.Scanner;

public class fizz {

    public static void main(String[] args){

        Scanner input = new Scanner (System.in);

        int first = input.nextInt();

        int sec = input.nextInt();

        int third = input.nextInt();


        for(int i = 1; i <= third; i++){

            if (i % first == 0 && i % sec == 0){

                System.out.println("FizzBuzz");

            } else if (i % sec == 0){

                System.out.println("Buzz");


            } else if (i % first == 0){

                System.out.println("Fizz");


            } else {

                System.out.println(i);
            }


        }



    }
}
