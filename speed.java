/**
 * Created by nickcarrozza on 3/11/17.
 */

import java.util.Scanner;

public class speed {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        boolean go = true;

        while (go) {

            int test = input.nextInt();

            if (test != -1) {

                int ans = 0;

                int i = 0;

                int checker = 0;

                int mph = 0;

                int hrs = 0;

                int total = 0;

                while (i <= test) {

                    checker = hrs;

                    mph = input.nextInt();

                    hrs = input.nextInt();


                    if (ans == 0) {

                        ans = mph * hrs;

                        i++;

                    } else {

                        ans = mph * (hrs - checker);

                    }

                    total = total + ans;

                    i++;

                }

                System.out.println(total + " miles");


            } else {

                go = false;
            }
        }
    }
}





