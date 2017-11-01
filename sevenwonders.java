/**
 * Created by nickcarrozza on 5/19/17.
 */


import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;


public class sevenwonders {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    String line = input.nextLine();

    String user = line.toUpperCase();

    //declare variables for running total
    int grandTotal = 0;
    int ttotal = 0;
    int ctotal = 0;
    int gtotal = 0;


    for(int i = 0; i < line.length(); i++){

    if(user.charAt(i) == 'T'){

       ttotal++;


    } else if(user.charAt(i) == 'C'){


       ctotal++;

    } else if(user.charAt(i) == 'G'){


      gtotal++;

    }

    }


    int list[] = new int[3];

    list[0] = ttotal;
    list[1] = ctotal;
    list[2] = gtotal;

    if(ttotal != 0 && ctotal != 0 && gtotal != 0){

      Arrays.sort(list);

      grandTotal = list[0] * 7;

    }

    grandTotal += Math.pow(ttotal, 2) + Math.pow(ctotal, 2) + Math.pow(gtotal, 2);

    System.out.println(grandTotal);


  }
}
