package com.app.challenges.barcley;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


class TestClass {
    public static void main(String args[]) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger len = null;

        //Scanner s = new Scanner(System.in);

        long testCases = Long.parseLong(br.readLine().trim());

        for (int i = 0; i < testCases; i++) {
            len = new BigInteger(br.readLine().trim());

            decideWinner(len);
        }

    }

    private static void decideWinner(BigInteger lengthOfChoco) {

        boolean status = true; //A= true, B=false;

        BigInteger counter = new BigInteger("0");
        BigInteger inc =new BigInteger("1");

        while (true){
            counter = counter.add(inc);

            if(status)
            {
                //do for A
                lengthOfChoco = lengthOfChoco.subtract(counter);
                if(lengthOfChoco.longValue()<0)
                {
                    System.out.println("B");
                    break;
                }
                status = false;
            }
            else
            {
                //do for B
                lengthOfChoco = lengthOfChoco.subtract(counter);
                if(lengthOfChoco.longValue()<0)
                {
                    System.out.println("A");
                    break;
                }
                status = true;
            }
        }
    }
}
