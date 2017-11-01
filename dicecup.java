/**
 * Created by nickcarrozza on 5/29/17.
 */

import java.util.Scanner;

public class dicecup {

  public static void main(String[] args){

   Scanner input = new Scanner(System.in);

   int first = input.nextInt();

   int sec = input.nextInt();

   //create boundaries

    int lowBound = first + 1;

    int highBound = sec + 1;

    //assume lowBound is lower than highBound
    if(lowBound > highBound){

      int caputre = lowBound;

      lowBound = highBound;

      highBound = caputre;

    }


    for(int i = lowBound; i < highBound; i++){

      System.out.println(i);

    }

    System.out.println(highBound);


  }

}
