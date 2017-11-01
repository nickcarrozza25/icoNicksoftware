/**
 * Created by nickcarrozza on 5/18/17.
 */

import java.math.BigInteger;
import java.util.*;
import java.lang.Math;

public class oldmac {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    double value = input.nextDouble();

    double thesqrt = Math.sqrt(value);

    double ans = thesqrt * 4;

    System.out.println(ans);

  }

}
