/**
 *Created by nickcarrozza on 3/7/17.
 */

import java.util.Scanner;
import java.lang.Math;

public class oddities {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int qty = input.nextInt();

        int i = 0;

        while (i < qty) {

            int nextNum = input.nextInt();

            if (nextNum % 2 == 0) {

                System.out.println(nextNum + " is even");

            } else {

                System.out.println(nextNum + " is odd");
            }

            i++;

        }

    }
}
