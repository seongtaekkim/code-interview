package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 15989 1, 2, 3 더하기 4
 * https://www.acmicpc.net/problem/15989
 *
 * num = num-1 + 1;
 * num = (num-2) + 2 or (num-2) + (1+1);
 * num = (num-3) + 3 or (num-2) + (2+1) or (num-3) + (1+1+1);
 *
 * dp[num][1] = dp[num-1][1];
 * dp[num][2] = dp[num-2][1] + dp[num-1][2];
 * dp[num][3] = dp[num-3][1] + dp[num-3][2] + dp[num-3][3];
 */
public class _15989 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());
            int S =0;
            int[][] dp = new int[100001][4];
            dp[1][1] =1;
            dp[2][1] =1;
            dp[2][2] =1;
            dp[3][1] =1;
            dp[3][2] =1;
            dp[3][3] =1;

            for(int i=4; i<10001; i++) {
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1]+ dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }
            for (int i =0; i<T ;i++) {
                S = Integer.parseInt(br.readLine());
                    System.out.println(dp[S][1] + dp[S][2] + dp[S][3]);
            }


        } catch (IOException e) {
            // TODO
        }
    }
}
