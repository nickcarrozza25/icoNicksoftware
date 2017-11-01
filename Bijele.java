/**
 * Created by nickcarrozza on 3/7/17.
 */


import java.util.Scanner;

public class Bijele {

    public static void main(String[] args){

        Scanner input = new Scanner (System.in);

        for (int i = 1; i <= 6; i++) {

            int hegot = input.nextInt();

            if (hegot >= 0 && hegot <= 10) {

                if (i == 1) {

                    if (hegot != 1) {

                        hegot = 1 - hegot;

                        System.out.print(hegot + " ");

                    } else {

                        System.out.print(0 + " ");
                    }


                } else if (i == 2) {

                    if (hegot != 1) {

                        hegot = 1 - hegot;

                        System.out.print(hegot + " ");

                    } else {

                        System.out.print(0 + " ");

                    }

                } else if (i == 3) {

                    if (hegot != 2) {

                        hegot = 2 - hegot;

                        System.out.print(hegot + " ");
                    } else {

                        System.out.print(0 + " ");
                    }


                } else if (i == 4) {

                    if (hegot != 2) {

                        hegot = 2 - hegot;

                        System.out.print(hegot + " ");

                    } else {

                        System.out.print(0 + " ");
                    }

                } else if (i == 5) {

                    if (hegot != 2) {

                        hegot = 2 - hegot;

                        System.out.print(hegot + " ");
                    } else {

                        System.out.print(0 + " ");
                    }


                } else {

                    if (hegot != 8) {

                        hegot = 8 - hegot;

                        System.out.print(hegot + " ");

                    } else {

                        System.out.print(0 + " ");

                    }


                }


            } else {

                break;
            }


        }


    }


}
