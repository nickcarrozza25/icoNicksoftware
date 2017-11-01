/**
 * Created by nickcarrozza on 8/5/17.
 */

import java.util.Scanner;


public class mixedfrac {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    boolean go = true;

    while (go) {

      int first = input.nextInt();

      int sec = input.nextInt();

      if (first == 0 && sec == 0) {

        break;

      } else {


        int remain = first % sec;


        double value = first / sec;

        double lead = Math.floor(value);

        System.out.println((int) lead + " " + remain + " / " + sec);
      }

    }


    }

  }

