package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 15666 N과 M (12)
 * https://www.acmicpc.net/problem/15666
 */
public class _15666 {
    public static int[] arr;
    public static int[] NArr;
    public static StringBuilder sb;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String[] line = br.readLine().split(" ");
            NArr = new int[line.length];
            for (int i=0 ;i<line.length ; i++) {
                NArr[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(NArr);
            sb = new StringBuilder();
            arr = new int[M];
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

        int before=0;
        for (int i=at ; i < n ; i++) {
            if ( before != NArr[i]) {
                arr[depth] = NArr[i];
                before = NArr[i];
                dfs(n, m, depth + 1, i);
            }
        }
    }
}
