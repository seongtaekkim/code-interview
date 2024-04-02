package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 17425  약수의 합
 * https://www.acmicpc.net/problem/17425
 */
public class _17425 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuffer sb = new StringBuffer();
            int t = Integer.parseInt(br.readLine());
            long fx[] = new long[1000001];
            long dp[] = new long[1000001];

            // 1은 모든 수의 약수니까 전부 넣어준다.
            Arrays.fill(fx, 1);

            for (int i = 2; i < fx.length; i++) {
                for (int j = 1; i * j < fx.length; j++) {
                    fx[i * j] += i;
                }
            }
            for (int i = 1; i < dp.length; i++) {
                dp[i] += dp[i - 1] + fx[i];
            }
            for (int i = 0; i < t; i++) {
                int input = Integer.parseInt(br.readLine());
                sb.append(dp[input]).append("\n");
            }
            System.out.println(sb);
        }
    }

}
