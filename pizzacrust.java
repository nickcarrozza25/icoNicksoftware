/**
 * Created by nickcarrozza on 3/7/17.
 */


import java.util.Scanner;
import java.lang.Math;



public class pizzacrust {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double r = input.nextDouble();

        double c = input.nextDouble();

        double bigarea = Math.PI * (Math.pow(r, 2));

        double littlearea = Math.PI * (Math.pow((r - c), 2));

        double ratio = (littlearea / bigarea);

        double ans = ratio * 100;


        System.out.print(ans);



    }




}
