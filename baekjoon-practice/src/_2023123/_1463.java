package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 1463 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */
public class _1463 {

    static Integer[] dp;

    static int recursive(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] =Math.min(recursive(n - 1), Math.min(recursive(n / 3), recursive(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recursive(n/3), recursive(n-1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recursive(n/2), recursive(n-1)) + 1;
            } else {
                dp[n] = recursive(n-1) + 1;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            dp = new Integer[num+1];
            dp[0] = dp[1] = 0;
            System.out.println(recursive(num));
        } catch (IOException e) {
            // TODO
        }
    }

}
