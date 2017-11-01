/**
 * Created by nickcarrozza on 3/12/17.
 */

import java.util.Scanner;
import java.util.Arrays;


public class rijeci {

    public static void main(String[] args){

        Scanner input = new Scanner (System.in);

        int times = input.nextInt();

        int a = 1;

        int b = 2;

        int acount = 4;

        int bcount = 4;

        //create array of a

        int[] alist = new int[46];

        alist[0] = 1;

        alist[1] = 0;

        alist[2] = 1;

        alist[3] = 1;

        while (acount <= 45) {

            alist[acount] = alist[acount - 1] + alist[acount - 2];

            acount++;

        }

        //create array for b

        int[] blist = new int[46];

        blist[0] = 0;

        blist[1] = 1;

        blist[2] = 1;

        blist[3] = 2;

        while (bcount <= 45) {

            blist[bcount] = alist[bcount - 1] + blist[bcount - 1];

            bcount++;

        }

        if (times == 1){

            System.out.print(0 + " " + 1);

        } else if (times == 2){

            System.out.print(1 + " " + 1);


        } else if (times == 3){

            System.out.print(1 + " " + 2);

        } else {

            System.out.print(alist[times] + " " + blist[times]);


        }

    }

}
