package math;

import java.util.Scanner;

/**
 * 2749 피보나치 수 3
 * https://www.acmicpc.net/problem/2749
 *
 * 분할정복으로 풀라고 되어있는데
 * 일반 공식으로 풀림..
 */
public class _2749 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int pisano = 1500000;
        long size = Long.parseLong(scanner.next()) % pisano;

        long[] num = new long[pisano + 1];

        num[0] = 0;
        num[1] = 1;

        for(int i = 2; i <= pisano; i++)
            num[i] = (num[i - 1] + num[i - 2]) % 1_000_000;

        System.out.print(num[(int)size]);

    }
}
