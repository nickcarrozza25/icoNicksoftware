/**
 * Created by nickcarrozza on 3/10/17.
 */

import java.util.Scanner;
import java.lang.Math;


public class cetvrta {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int first = input.nextInt();

        int second = input.nextInt();

        int third = input.nextInt();

        int fourth = input.nextInt();

        int fifth = input.nextInt();

        int sixth = input.nextInt();

        if (third - first == 0) {

            System.out.print(fifth);

        } else if (third - fifth == 0) {

            System.out.print(first);

        } else if (first - fifth == 0) {

            System.out.print(third);

        }

        if (fourth - second == 0) {

            System.out.print(" " + sixth);

        } else if (fourth - sixth == 0) {

            System.out.print(" " + second);

        } else if (second - sixth == 0) {

            System.out.print(" " + fourth);

        }


    }

}
