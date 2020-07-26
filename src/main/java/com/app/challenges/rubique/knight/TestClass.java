package com.app.challenges.rubique.knight;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class TestClass {

    static Set<Square> covered = new HashSet<Square>();
    static int steps = 0;

    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i = 0; i < T; i++) {

            int n = s.nextInt();
            int m = s.nextInt();

            int x = s.nextInt();
            int y = s.nextInt();

            move(x, y, n, m, 1);

            System.out.println(steps);

            covered.clear();
            steps = 0;
        }
    }

    public static void move(int x, int y, int n, int m, int pSteps) {

        if (covered.size() == n * m) {
            steps = pSteps;
            return;
        }

        if (x < 0) {
            x = n - 1;
        }
        if (x >= n) {
            x = 0;
        }
        if (y < 0) {
            y = m - 1;
        }
        if (y >= m) {
            y = 0;
        }

        if (covered.contains(new Square(x,y)))
        {
            return;
        }

        covered.add(new Square(x, y));

        move(x - 1, y - 1, n, m, pSteps+1);
        move(x - 1, y, n, m, pSteps+1);
        move(x - 1, y + 1, n, m, pSteps+1);
        move(x, y - 1, n, m, pSteps+1);
        move(x, y + 1, n, m, pSteps+1);
        move(x + 1, y - 1, n, m, pSteps+1);
        move(x + 1, y, n, m, pSteps+1);
        move(x + 1, y + 1, n, m, pSteps+1);
    }
}

