/**
 * Created by nickcarrozza on 5/13/17.
 */

import java.util.Scanner;
import java.lang.Math;

public class sibice {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int qty = input.nextInt();

    int width = input.nextInt();

    int length = input.nextInt();

    double A_B_squared = Math.pow(width, 2) + Math.pow(length, 2);

    for(int i = 0; i < qty; i++){

      int next = input.nextInt();

      double csquared = Math.pow(next, 2);

      if(csquared <= A_B_squared){

        System.out.println("DA");

      } else {

        System.out.println("NE");

      }

    }

  }

}
