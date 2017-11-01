/**
 * Created by nickcarrozza on 3/9/17.
 */



import java.util.Scanner;
import java.lang.Math;


public class tri {

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        int firstDigit = input.nextInt();

        int secondDigit = input.nextInt();

        int thirdDigit = input.nextInt();

        if (firstDigit + secondDigit == thirdDigit) {

            System.out.print(firstDigit + "+" + secondDigit + "=" + thirdDigit);

        } else if (secondDigit + thirdDigit == firstDigit){

            System.out.print(firstDigit + "=" + secondDigit + "+" + thirdDigit);

        } else if (firstDigit - secondDigit == thirdDigit) {

            System.out.print(firstDigit + "-" + secondDigit + "=" + thirdDigit);


        } else if (secondDigit - thirdDigit == firstDigit) {

            System.out.print(firstDigit + "=" + secondDigit + "-" + thirdDigit);

        } else if (firstDigit * secondDigit == thirdDigit) {

            System.out.print(firstDigit + "*" + secondDigit + "=" + thirdDigit);

        } else if (secondDigit * thirdDigit == firstDigit) {

            System.out.print(firstDigit + "=" + secondDigit + "*" + thirdDigit);

        } else if (firstDigit / secondDigit == thirdDigit) {

            System.out.print(firstDigit + "/" + secondDigit + "=" + thirdDigit);

        } else if (secondDigit / thirdDigit == firstDigit) {

            System.out.print(firstDigit + "=" + secondDigit + "/" + thirdDigit);

        }

    }

}
