/**
 * Created by nickcarrozza on 3/10/17.
 */

import java.util.Scanner;
import java.lang.Math;


public class soylent {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int test = input.nextInt();

        for (int k = 1; k <= test; k++){

            int cal = input.nextInt();

            int j = 0;

            while (j < cal) {

                j += 400;

            }

            System.out.println(j / 400);

         }

    }

}

