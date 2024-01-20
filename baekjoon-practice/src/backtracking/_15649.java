package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 15649 N과 M (1)
 * https://www.acmicpc.net/problem/15649
 */
public class _15649 {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            sb = new StringBuilder();
            arr = new int[M];
            visit = new boolean[N];
            dfs(N, M, 0);
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0 ; i < n ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(n,m,depth+1);
                visit[i] = false;
             }
        }
    }
}
