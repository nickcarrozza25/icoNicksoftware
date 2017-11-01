/**
 * Created by nickcarrozza on 8/13/17.
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class oktalni {

  public static void main (String[] args){

   Scanner input = new Scanner(System.in);

   String user = input.nextLine();


   while(user.length() % 3 != 0){

     user = "0" + user;


   }

   int freq = user.length() / 3;

    String[] bits = new String[freq];

    int start = 0;

    int end = 3;

    for(int i = 0; i < freq; i++){

     String temp = user.substring(start, end);

     bits[i] = temp;

     start += 3;

     end += 3;


   }

   Map m1 = new HashMap();

    m1.put("000", 0);
    m1.put("001", 1);
    m1.put("010", 2);
    m1.put("011", 3);
    m1.put("100", 4);
    m1.put("101", 5);
    m1.put("110", 6);
    m1.put("111", 7);

    String ans = "";

    for(int j = 0; j < bits.length; j++){

      ans += m1.get(bits[j]);


    }


    System.out.println(ans);



  }

}
