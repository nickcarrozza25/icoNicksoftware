/**
 * Created by nickcarrozza on 5/18/17.
 */

import java.math.BigInteger;
import java.util.*;

public class largeadd {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    BigInteger a = input.nextBigInteger();

    BigInteger b = input.nextBigInteger();

    BigInteger result = a.add(b);

    System.out.println(result);


  }

}
