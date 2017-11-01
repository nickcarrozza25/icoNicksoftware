/**
 * Created by nickcarrozza on 11/1/17.
 */


import java.util.Scanner;

public class quadrant {

    public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int num1 = input.nextInt();

      int num2 = input.nextInt();

      if(num1 > 0 && num2 > 0){

        System.out.print(1);

      } else if (num1 < 0 && num2 > 0){

        System.out.print(2);

      } else if (num1 < 0 && num2 < 0){

        System.out.print(3);

      } else {

        System.out.print(4);

      }



  }


}
