package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2293 동전 1
 * https://www.acmicpc.net/problem/2293
 *
 *
 * cnt[i] = cnt[i] + cnt[i-coin[j]]
 */
public class _2293 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int K = Integer.parseInt(in[1]);
            int[] coin = new int[N+1];
            int[] dp = new int[K+1];
            dp[0] = 1;

            for(int i = 1; i<=N; i++)
                coin[i] = Integer.parseInt(br.readLine());

            for(int i = 1; i<=N; i++) {
                for(int j = coin[0]; j<=K; j++){
                    if(j<coin[i])
                        continue;
                    dp[j] += dp[j-coin[i]];
                }
            }

            System.out.println(dp[K]);

        } catch (IOException e) {
            // TODO
        }
    }
}
