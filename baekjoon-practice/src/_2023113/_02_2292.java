package _2023113;

import java.util.Scanner;

/**
 * 2292 벌집
 * https://www.acmicpc.net/problem/2292
 */
public class _02_2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int n = 1;
        while (true) {

            if (((n -1) * (12 + (n - 2) * 6) / 2) + 1 >= num)
                break;
            n++;
        }
        System.out.println(n);
    }
}
