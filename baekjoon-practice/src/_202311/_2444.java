package _202311;

import java.util.Scanner;

/**
 * 2444 별 찍기 - 7
 * https://www.acmicpc.net/problem/2444
 */
public class _2444 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int total = 2*N-1;
        int half = total / 2;
        for (int i = 0 ; i < total ; i++) {
            int k = half - i > 0 ? half - i : i - half;
            int r = total - k;
            for (int j = 0; j < total ; j++) {
                if (k == 0 ) {
                    if (r != 0)
                        System.out.print("*");
                } else {
                    k--;
                    System.out.print(" ");
                }
                if (r > 0)
                    r--;
            }
            if (i < total - 1)
                System.out.println();
        }
    }
}