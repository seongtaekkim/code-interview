package _2023112;

import java.util.Scanner;

/**
 * 2738 행렬덧셈
 * https://www.acmicpc.net/problem/2738
 */
public class _2738 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] matA = new int[N*M];
        for (int i = 0 ; i < N*M ; i++) {
            matA[i] = scanner.nextInt();
        }
        for (int i = 0 ; i < N*M ; i++) {
            matA[i] += scanner.nextInt();
        }
        for (int i = 0 ; i < N * M ; i++) {
            System.out.print(matA[i] + " ");
            if (i != 0 && (i+1) % M == 0 && i != matA.length - 1)
                System.out.println();
        }
    }
}
