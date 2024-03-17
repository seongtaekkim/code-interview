package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 7579 앱
 * https://www.acmicpc.net/problem/7579
 */
public class _7579 {

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] dp = new int[10001];
            int[] memory = new int[N];
            int[] cost = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                memory[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                cost[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++)
                for (int j = 10000; j >= cost[i]; j--)
                    dp[j] = Math.max(dp[j-cost[i]] + memory[i], dp[j]);

            for (int i = 0; i < 10001; i++) {
                if (dp[i] >= M) {
                    System.out.println(i);
                    return;
                }
            }

        } catch (IOException e) {
            // TODO
        }
    }
}
