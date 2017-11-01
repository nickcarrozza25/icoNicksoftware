/**
 * Created by nickcarrozza on 8/13/17.
 */


import java.util.Scanner;
import java.lang.Math;

public class sjecista {

  public static void main (String[] args){

    Scanner input = new Scanner(System.in);

    int v = input.nextInt();

    int ans = (v * (v - 1) * (v - 2) * (v - 3)) / 24;

    System.out.println(ans);


  }

}
