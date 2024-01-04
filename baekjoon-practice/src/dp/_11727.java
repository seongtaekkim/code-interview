package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11727 2×n 타일링 2
 * https://www.acmicpc.net/problem/11727
 *
 * (A+B) % M = (A % M + B % M) % M
 * (A*B) % M = (A % M * B % M) % M
 *
 * 점화식
 * f(n) = f(n-1) + 2f(n-2)
 */
public class _11727 {
    private static final int MOD = 10007;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int[] DP = new int[1001];
            DP[1] = 1;
            DP[2] = 3;
            for (int i=3 ; i<=n ; i++) {
                DP[i] = (DP[i-1] + 2 * DP[i-2]) % MOD;
            }
            System.out.println(DP[n] % MOD);
        } catch (IOException e) {
            // TODO
        }
    }
}
