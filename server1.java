/**
 * Created by nickcarrozza on 5/18/17.
 */


import java.util.Scanner;

public class server1 {

  public static void main(String[] args){

  Scanner input = new Scanner(System.in);

  int qty = input.nextInt();

  int max = input.nextInt();

  //declare total to keep track
    int total = 0;

    int i;

  for(i = 0; i < qty; i++){

   int nextVal = input.nextInt();

   total += nextVal;

   if(total > max){

     break;

   }

  }

  System.out.println(i);

  }

}
