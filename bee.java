/**
 * Created by nickcarrozza on 3/12/17.
 */

import java.util.Scanner;


public class bee {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean go = true;

        int i = 1;

        while (go && i <= 15) {

            int first = input.nextInt();

            int second = input.nextInt();

            if (first >= 0 && first <= 1000 && second >= 0 && second <= 1000) {

                if (first == 0 && second == 0) {

                    go = false;

                    break;

                } else {


                    if (first + second != 13) {

                        if (first > second) {

                            System.out.println("To the convention.");

                        } else if (second > first) {

                            System.out.println("Left beehind.");

                        } else {

                            System.out.println("Undecided.");
                        }

                    } else {

                        System.out.println("Never speak again.");
                    }

                }

                i++;

            }
        }
    }

}

