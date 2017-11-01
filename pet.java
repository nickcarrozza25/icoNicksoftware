/**
 * Created by nickcarrozza on 3/7/17.
 */

import java.util.Scanner;
import java.util.Arrays;

public class pet {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] totalArray = new int[5];

        int i;

        int max = totalArray[0];

        int position = 0;

        for(i = 0; i <= 4; i++) {

            int numOne = input.nextInt();

            int numTwo = input.nextInt();

            int numThree = input.nextInt();

            int numFour = input.nextInt();

            int total = numOne + numTwo + numThree + numFour;

            totalArray[i] = total;


        }

        for (int a = 0; a < totalArray.length; a++){

            if(totalArray[a] > max){

                position = a + 1;

                max = totalArray[a];

            }

        }


        for (int n = 1; n < 5; n++) {

            for (int x = 1; x < totalArray.length; x++) {

                if (totalArray[x] > totalArray[x - 1]) {

                    int place = totalArray[x - 1];

                    totalArray[x - 1] = totalArray[x];

                    totalArray[x] = place;

                }

            }
        }

        System.out.print(position + " " + totalArray[0]);

    }

}
