/**
 * Created by nickcarrozza on 5/13/17.
 */


import java.util.Scanner;

public class filip {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int firstNum = input.nextInt();

    String firstString = Integer.toString(firstNum);

    String revFirst = new StringBuilder(firstString).reverse().toString();

    int revFirstInt = Integer.parseInt(revFirst);

    //handle second int
    int secNum = input.nextInt();

    String secString = Integer.toString(secNum);

    String revSec = new StringBuilder(secString).reverse().toString();

    int revSecInt = Integer.parseInt(revSec);

    //compare and output highest
    if(revFirstInt > revSecInt){

      System.out.print(revFirstInt);

    } else {

      System.out.print(revSecInt);

    }


    }

  }

