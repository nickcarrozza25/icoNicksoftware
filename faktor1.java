/**
 * Created by nickcarrozza on 5/29/17.
 */

import java.util.Scanner;

public class faktor1 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int first = input.nextInt();

    int sec = input.nextInt();

    int ans = (first * (sec - 1)) + 1;

    System.out.println(ans);

  }

}
