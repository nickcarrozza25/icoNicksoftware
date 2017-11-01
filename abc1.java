/**
 * Created by nickcarrozza on 5/18/17.
 */

import java.util.Arrays;
import java.util.Scanner;

public class abc1 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    int first = input.nextInt();

    int sec = input.nextInt();

    int third = input.nextInt();

    //create array with the three values
    int[] list = new int[3];

    list[0] = first;

    list[1] = sec;

    list[2] = third;

    Arrays.sort(list);

    //Scanner readVal = new Scanner(System.in);

    String line = input.next();

    if (line.equals("ABC")){

      System.out.print(list[0] + " ");
      System.out.print(list[1] + " ");
      System.out.print(list[2]);

    } else if(line.equals("ACB")){


      System.out.print(list[0]+ " ");
      System.out.print(list[2]+ " ");
      System.out.print(list[1]);


    } else if(line.equals("BAC")){


      System.out.print(list[1]+ " ");
      System.out.print(list[0]+ " ");
      System.out.print(list[2]);


    } else if(line.equals("BCA")){


      System.out.print(list[1]+ " ");
      System.out.print(list[2]+ " ");
      System.out.print(list[0]);

    } else if(line.equals("CAB")){


      System.out.print(list[2]+ " ");
      System.out.print(list[0]+ " ");
      System.out.print(list[1]);


    } else if(line.equals("CBA")){


      System.out.print(list[2]+ " ");
      System.out.print(list[1]+ " ");
      System.out.print(list[0]);


    }


  }

}
