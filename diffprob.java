/**
 * Created by nickcarrozza on 5/21/17.
 */


import java.math.BigInteger;
import java.util.*;
import java.lang.Math;



public class diffprob {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    while(input.hasNextBigInteger()){

      BigInteger a = input.nextBigInteger();

      BigInteger b = input.nextBigInteger();

      BigInteger diff = a.subtract(b);

      BigInteger ans = diff.abs();

      System.out.println(ans);


    }


  }

}
