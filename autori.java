/**
 * Created by nickcarrozza on 5/13/17.
 */


import java.util.Scanner;

public class autori {

  public static void main(String[] args){

   Scanner input = new Scanner(System.in);

   String name = input.nextLine();

   //automatically output first letter
    System.out.print(name.charAt(0));

   for(int i = 0; i < name.length(); i++){

    if (name.charAt(i) == '-'){

      System.out.print(name.charAt(i + 1));


    }


   }

  }

}
