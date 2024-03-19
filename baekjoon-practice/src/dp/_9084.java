package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9084 동전
 * https://www.acmicpc.net/problem/9084
 *
 *
 * cnt[i] = cnt[i] + cnt[i-coin[j]]
 */
public class _9084 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {


            int T = Integer.parseInt(br.readLine());
            for (int i=0; i<T ; i++) {
                int N = Integer.parseInt(br.readLine());
                String[] in = br.readLine().split(" ");
                int[] coin = new int[N+1];
                int K = Integer.parseInt(br.readLine());
                int[] dp = new int[K+1];
                dp[0] = 1;
                for(int j = 1; j<=N; j++)
                    coin[j] = Integer.parseInt(in[j-1]);

                for(int j = 1; j<=N; j++) {
                    for(int k=coin[0]; k<=K; k++){
                        if(k<coin[j])
                            continue;
                        dp[k] += dp[k-coin[j]];
                    }
                }
                System.out.println(dp[K]);

            }

        } catch (IOException e) {
            // TODO
        }
    }
}
