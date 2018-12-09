package com.app.challenges.rubique.cibilScore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Scanner s = new Scanner(System.in);

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine().trim());

            List<Customer> list = new ArrayList<Customer>(N);

            for (int j = 0; j < N; j++) {
                String[] strSplit = br.readLine().trim().split(" ");

                String name = strSplit[0].trim();
                int cibilScore = Integer.parseInt(strSplit[1].trim());
                int riskScore = Integer.parseInt(strSplit[2].trim());

                list.add(new Customer(name, cibilScore, riskScore));
            }

            int k = Integer.parseInt(br.readLine().trim());

            Collections.sort(list);

            if (k-1 >= 0 && k-1 < list.size())
                System.out.println(list.get(k-1).getName() + " " + list.get(k-1).getCibilScore());

        }
    }
}
