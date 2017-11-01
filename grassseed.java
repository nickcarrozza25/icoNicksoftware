/**
 * Created by nickcarrozza on 5/15/17.
 */

import java.util.Scanner;

public class grassseed {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    double cost = input.nextDouble();

    double amt = input.nextDouble();

    double total = 0;


    for (int i = 0; i < amt; i++) {

      double width = input.nextDouble();

      double length = input.nextDouble();

      //multiply the two to get the area
      double area = width * length;

      //keep a running total

      total += area;

    }

    double seedCost = total * cost;

    System.out.println(seedCost);

  }
}

