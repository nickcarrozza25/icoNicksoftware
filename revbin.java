/**
 * Created by nickcarrozza on 5/13/17.
 */

import java.util.Scanner;


public class revbin {

  public static void main(String[] args){

   Scanner input = new Scanner(System.in);

   int user = input.nextInt();

   //convert int to a binary number
   String bin = Integer.toBinaryString(user);

   //reverse the binary string
   String revUser = new StringBuilder(bin).reverse().toString();

   //convert the reverse to int
    int revbinInt = Integer.parseInt(revUser, 2);

    System.out.print(revbinInt);


  }

}
