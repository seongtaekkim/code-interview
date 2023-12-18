package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9095 1, 2, 3 더하기
 * https://www.acmicpc.net/problem/9095
 */
public class _9095 {

    static Integer[] dp;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            dp = new Integer[11];
            dp[1] = 1;
            dp[2] = 2; // 2 = (1,1), (2)
            dp[3] = 4; // 3 = (1,1,1) (1,2) (2,1) (3)

            //dp[4] = dp[3] + dp[2] + dp[1]; // (1,3) (2,2) (3,1)
            // dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
            for (int i=4 ;i<=10 ; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            for (int i=1 ;i<=N ; i++) {
                System.out.println(dp[Integer.parseInt(br.readLine())]);
            }
        } catch (IOException e) {
            // TODO
        }
    }

}
