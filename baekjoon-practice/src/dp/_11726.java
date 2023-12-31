package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11726 2×n 타일링
 * https://www.acmicpc.net/problem/11726
 *
 * (A+B) % M = (A % M + B % M) % M
 * (A*B) % M = (A % M * B % M) % M
 */
public class _11726 {
    private static final int MOD = 10007;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int[] DP = new int[1001];
            DP[1] = 1;
            DP[2] = 2;
            DP[3] = 3;
            for (int i=4 ; i<=n ; i++) {
                DP[i] = (DP[i-1] + DP[i-2]) % MOD;
            }
            System.out.println(DP[n] % MOD);
        } catch (IOException e) {
            // TODO
        }
    }
}
