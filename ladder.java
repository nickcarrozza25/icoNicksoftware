/**
 * Created by nickcarrozza on 3/7/17.
 *
 *
 */


import java.util.Scanner;
import java.lang.Math;

public class ladder {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        double h = input.nextDouble();

        double v = input.nextDouble();

        double angradians = Math.toRadians(v);

        double angsin = Math.sin(angradians);;

        double x = (h / angsin) ;

        System.out.print((int)Math.ceil(x));


    }

}
