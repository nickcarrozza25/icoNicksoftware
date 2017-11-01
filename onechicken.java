/**
 * Created by nickcarrozza on 5/13/17.
 */

import java.util.Scanner;

public class onechicken {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int people = input.nextInt();

    int pieces = input.nextInt();

    int morepieces = pieces - people;

    int morepeople = people - pieces;

    if(pieces > people && morepieces != 1){

      System.out.print("Dr. Chaz will have " + morepieces + " pieces of chicken left over!" );

    } else if(pieces < people && morepeople != 1){

      System.out.print("Dr. Chaz needs " + morepeople + " more pieces of chicken!" );

    } else if(morepieces == 1){

      System.out.print("Dr. Chaz will have " + morepieces + " piece of chicken left over!" );

    } else if(morepeople == 1){

      System.out.print("Dr. Chaz needs " + morepeople + " more piece of chicken!" );

    }


  }

}
