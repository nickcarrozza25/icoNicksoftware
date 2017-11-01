/**
 * Created by nickcarrozza on 7/23/17.
 */

import java.util.Scanner;
import java.lang.Math;

public class planina {

  public static void main(String[] args){

   Scanner input = new Scanner(System.in);

   int iter = input.nextInt();

   double val = (Math.pow(2, iter) + 1);

   double ans = Math.pow(val, 2);

   int print = ((int) ans);

    System.out.println(print);


  }

}
