/**
 * Created by nickcarrozza on 3/13/17.
 */

import java.util.Scanner;

public class aaah {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String first = input.nextLine();

        String second = input.nextLine();

        int firstAmt = first.length();

        int secondAmt = second.length();

        if (firstAmt >= secondAmt){

            System.out.print("go");

        } else {

            System.out.print("no");

        }



    }

}
