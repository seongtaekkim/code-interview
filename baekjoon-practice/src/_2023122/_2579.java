package _2023122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2579 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */
public class _2579 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int[] ret = new int[N + 1];
            int[] arr = new int[N + 1];

            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(br.readLine());

            ret[1] = arr[1];
            if (N >= 2)
                ret[2] = arr[1] + arr[2];

            for (int i = 3; i <= N; i++)
                ret[i] = Math.max(ret[i - 2] , ret[i - 3] + arr[i - 1]) + arr[i];
            System.out.println(ret[N]);

        } catch (IOException e) {
            // TODO
        }
    }

}
