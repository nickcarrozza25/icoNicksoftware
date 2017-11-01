/**
 * Created by nickcarrozza on 5/14/17.
 */

import java.util.Scanner;

public class tarifa {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int x = input.nextInt();

    int n = input.nextInt();

    int months = n + 1;


    int total = 0;

    for (int i = 0; i < n; i++){

      //Scanner read = new Scanner(System.in);

      int nextVal = input.nextInt();

      total += nextVal;

    }

    //months times x minus total is whats left

    int left = (months * x) - total;

    System.out.println(left);

  }

}
