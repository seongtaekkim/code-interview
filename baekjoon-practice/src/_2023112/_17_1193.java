package _2023112;

import java.util.Scanner;

/**
 * 1193 분수찾기
 * https://www.acmicpc.net/problem/1193
 */
public class _17_1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int n = 0;
        int s = 0;
        while(true) {
            n++;
            s = n * (2 + (n - 1)) / 2; // 등차수열 합공식
            if (s >= num) break;
        }

        int start = s - n + 1; // 새로운 분수시작 위치
        int bToT = 1; // 분수 최저 수치
        int tToB = n; // 분수 최고 수치

        for (int i=0; i < num-start ; i++) {
            bToT++;
            tToB--;
        }
        if (n % 2 == 1) {
            System.out.println(tToB + "/" + bToT);
        } else {
            System.out.println(bToT + "/" + tToB);
        }
    }
}
