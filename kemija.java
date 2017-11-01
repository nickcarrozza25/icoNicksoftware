/**
 * Created by nickcarrozza on 5/19/17.
 */

import java.util.Scanner;


public class kemija {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    String line = input.nextLine();

    String wtf1 = line.replace("apa", "a");

    String wtf2 = wtf1.replace("epe", "e");

    String wtf3 = wtf2.replace("ipi", "i");

    String wtf4 = wtf3.replace("opo", "o");

    String wtf5 = wtf4.replace("upu", "u");



    System.out.println(wtf5);


  }

}
