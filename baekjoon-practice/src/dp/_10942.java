package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10942 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */
public class _10942 {

    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    public static void main(String[] args) {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            arr = new int[N+1];
            dp = new boolean[N+1][N+1];

            for (int i=0 ;i<N ; i++)
                arr[i+1] = Integer.parseInt(in[i]);
            for(int i = 1; i<=N; i++)
                dp[i][i] = true;
            for(int i=1; i<=N-1; i++) {
                if(arr[i] == arr[i+1])
                    dp[i][i+1] = true;
            }
            makePalin(N);
            M = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                in = br.readLine().split(" ");
                if(dp[Integer.parseInt(in[0])][Integer.parseInt(in[1])])
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            //TOdO
        }

    }
    static void makePalin(int n) {

        for(int i=2; i<n; i++) {
            for(int j=1; j<=n-i; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                }
            }
        }

    }
}
