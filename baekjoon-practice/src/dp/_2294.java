package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2294 동전 2
 * https://www.acmicpc.net/problem/2294
 *
 *
 * cnt[i] = cnt[i] + cnt[i-coin[j]]
 */
public class _2294 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");
            int N = Integer.parseInt(in[0]);
            int K = Integer.parseInt(in[1]);
            int[] dp = new int[K+1];
            boolean[] bdp = new boolean[N+1];
            dp[0] = 1;

            int[] coin = new int[N];
            int[] cnt = new int[K+1];

            for(int i = 1; i<=K; i++)
                cnt[i] = 100_001;

            for(int i = 0; i<N; i++)
                coin[i] = Integer.parseInt(br.readLine());

            Arrays.sort(coin);

            for(int i = 0; i<N; i++) {
                for (int j = coin[0]; j <= K; j++) {
                    if (j < coin[i])
                        continue;

                    cnt[j] = Math.min(cnt[j], cnt[j-coin[i]] + 1);
                }
            }

            for(int i = 1; i<=K; i++)
                if(cnt[i]==100_001)
                    cnt[i] = -1;

            System.out.println(cnt[K]);

        } catch (IOException e) {
            // TODO
        }
    }
}
