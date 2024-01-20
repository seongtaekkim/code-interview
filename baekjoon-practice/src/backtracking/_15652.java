package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 15652 N과 M (4)
 * https://www.acmicpc.net/problem/15652
 */
public class _15652 {
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
            dfs(N, M, 0, 0);
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

    private static void dfs(int n, int m, int depth, int at) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=at ; i < n ; i++) {
            arr[depth] = i + 1;
            dfs(n,m,depth+1, i);
        }
    }
}
