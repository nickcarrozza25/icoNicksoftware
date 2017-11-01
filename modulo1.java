/**
 * Created by nickcarrozza on 8/11/17.
 */


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class modulo1 {

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    ArrayList arr = new ArrayList();

    for(int i = 0; i < 10; i++){

     int target = input.nextInt();

     int remain = target % 42;

     //System.out.println(remain);

     arr.add(remain);


    }

    Set<String> uniqueValues = new HashSet<String>(arr);
    System.out.println(uniqueValues.size());

  }

}
