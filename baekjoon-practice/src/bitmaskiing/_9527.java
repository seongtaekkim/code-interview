package bitmaskiing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9527 1의 개수 세기
 * https://www.acmicpc.net/problem/9527
 */
public class _9527 {
    static long[] dp = new long[55];
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().split(" ");
            long A = Long.parseLong(in[0]);
            long B = Long.parseLong(in[1]);

            /**
             * n >= 3
             * dp[n] = dp[n-1] * 2 + 2^(n-1)
             */
//            dp[0] = -1;
            dp[0] = 1; // 1
//            dp[1] = 3 + 1; // 1*2 + 2
//            dp[2] = dp[1] * 2 + 2*2; // 1xx
//            dp[3] = dp[2] * 2 + 2*2*2; // 1xxx
            for (int i=1 ; i<55 ; i++) {
                dp[i] = (dp[i-1] << 1) + (1L << i);
            }

            long ret = calc(B) - calc(A-1);
            System.out.println(ret);

        } catch (IOException e) {
            //TODO
        }


    }
    private static long calc(long N) {
        long count = N & 1; // 2진법 1의자리 1이면 1 0이면 0 -> for에서 판단 안함

        int size = (int) (Math.log(N)/Math.log(2));

        for (int i=size ; i>0 ; i--) {
            if((N & (1L<<i)) != 0L) { // i만큼 비트이동하여 값이 1인 경우
                count += dp[i-1] +(N - (1L<<i) + 1); // 이전 자리 dp값 + 현재 자리 1 수
//                System.out.println(dp[i] + " " + ((N - (1L<<i)) + 1));
                N -= (1L << i);	// 비트이동
            }
        }

        return count;
    }
}
