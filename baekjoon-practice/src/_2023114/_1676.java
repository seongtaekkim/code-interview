package _2023114;

import java.util.Scanner;

/**
 * 1676 팩토리얼 0의 개수
 * https://www.acmicpc.net/problem/1676
 */
public class _1676 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int cnt = 0;
        for (int i=1 ; i<=num ; i++) {
            if (i % 5 == 0)
                cnt++;
            if (i % 25 == 0)
                cnt++;
            if (i % 125 == 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}