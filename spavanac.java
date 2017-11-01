/**
 * Created by nickcarrozza on 3/10/17.
 */

import java.util.Scanner;
import java.lang.Math;

public class spavanac {

    public static void main (String[] args){

        Scanner input = new Scanner (System.in);

        int minAns;

        int hourAns;


        int hour = input.nextInt();

        int min = input.nextInt();

        boolean flipHour = false;


        if (min - 45 < 0){

            minAns = 60 + (min - 45);

            flipHour = true;

        } else {

            minAns = min - 45;
        }

        if (flipHour) {

            hour -= 1;

            if (hour < 0) {

                hour += 24;
            }

        }

        System.out.print(hour + " " + minAns);



    }
}
