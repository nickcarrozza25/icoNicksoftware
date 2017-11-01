/**
 * Created by nickcarrozza on 5/14/17.
 */

import java.util.Scanner;


public class trik {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String letters = input.nextLine();

    int qty = letters.length();

    //the number of iteratrions counted
    int count = 0;

    //track the current position of the ball, initialize to 1
    int curPos = 1;

    while(count < qty){

      char curLetter = letters.charAt(count);

      if (curPos == 1 ){

        if (curLetter == 'A'){

          curPos = 2;

        } else if (curLetter == 'C'){

          curPos = 3;

        }


      } else if (curPos == 2){

        if(curLetter == 'A'){

          curPos = 1;

        } else if (curLetter == 'B'){

          curPos = 3;


        }

      } else if (curPos == 3){

        if (curLetter == 'B'){

          curPos = 2;

        } else if (curLetter == 'C'){

         curPos = 1;

        }


      }

      count++;

    }

    System.out.println(curPos);

    }

  }

//}
