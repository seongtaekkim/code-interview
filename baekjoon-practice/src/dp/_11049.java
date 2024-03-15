package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 11049 행렬 곱셈 순서
 * https://www.acmicpc.net/problem/11049
 *
 *
 * 항상 순서대로 곱셈을 할 수 있는 크기만 입력으로 주어진다.
 * - (5 * 3) * (4 * 7) 은 행렬연산이 불가능한데, 문제입력에서 제외되었기에 고려하지 않아도 됨.
 *
 *
 * Top-Down 으로 해결
 */
public class _11049 {

    static int N;
    static int MAX_VALUE = Integer.MAX_VALUE;
    static int[] data;
    static int[][] dp;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            
            N = Integer.parseInt(br.readLine());
            data = new int[N+1];
            for (int i=0 ;i<N ; i++) {
                String[] in = br.readLine().split(" ");
                data[i] = Integer.parseInt(in[0]);
                data[i+1] = Integer.parseInt(in[1]);
            }

            dp = new int[N][N];

            for(int i=0; i<N; i++)
                Arrays.fill(dp[i], MAX_VALUE);
            System.out.println(calc(0,N-1));


        } catch (IOException e) {
            // TODO
        }

    }
    static int calc(int pos, int cur) {
        if(pos == cur) return 0;
        if(dp[pos][cur] != MAX_VALUE) return dp[pos][cur];

        for(int i=pos; i<cur; i++) {
            int value = calc(pos,i) + calc(i+1, cur) + (data[pos] * data[i+1] * data[cur+1]);
            dp[pos][cur] = Math.min(dp[pos][cur], value);
        }

        return dp[pos][cur];
    }
}
