package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2225 합분해
 * https://www.acmicpc.net/problem/2225
 *
 *  dp[a][b] = dp[a-1][b] + dp[a][b-1]
 *
 */
public class _2225 {
    private static final int MODULAR = 1_000_000_000;


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int K = Integer.parseInt(in[1]);

            int[][] dp = new int[K+1][N+1];

            for (int i = 1; i <= N; i++)
                dp[1][i] = 1;
            for (int i = 1; i <= K; i++)
                dp[i][0] = 1;

            for (int i = 2; i <= K; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    dp[i][j] %= MODULAR;
                }
            }
            System.out.println(dp[K][N]);
        } catch (IOException e) {
            // TODO
        }


    }
}
