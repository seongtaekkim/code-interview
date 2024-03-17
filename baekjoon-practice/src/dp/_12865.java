package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 12865 평범한 배낭
 * https://www.acmicpc.net/problem/12865
 */
public class _12865 {

    static Integer[][] dp;
    static int[] W; // weight
    static int[] V; // value

    public static void main(String[] args) throws IOException {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            W = new int[N];
            V = new int[N];

            dp = new Integer[N][K + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                W[i] = Integer.parseInt(st.nextToken());
                V[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(calc(N - 1, K));
        }

    }

    static int calc(int i, int k) {
        // i가 0미만, 즉 범위 밖이 된다면
        if (i < 0)
            return 0;

        // 탐색하지 않은 위치라면?
        if (dp[i][k] == null) {

            // 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
            if(W[i] > k) {
                dp[i][k] = calc(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else {
                // 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
                dp[i][k] = Math.max(calc(i - 1, k), calc(i - 1, k - W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }
}
