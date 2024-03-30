package graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 9466 텀 프로젝트
 * https://www.acmicpc.net/problem/9466
 */
public class _9466 {
    static int[] arr;
    static boolean[] visit, done;
    static int count;

    public static void main(String[] args) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(bf.readLine());

            StringTokenizer st;
            for (int p = 0; p < T; p++) {
                int n = Integer.parseInt(bf.readLine());
                arr = new int[n + 1];
                visit = new boolean[n + 1];
                done = new boolean[n + 1];
                count = 0;

                st = new StringTokenizer(bf.readLine());

                for (int i = 1; i <= n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }

                for (int i = 1; i <= n; i++) {
                    if (!done[i]) {
                        dfs(i);
                    }
                }
                bw.write((n - count) + "\n");
            }
        }
    }

    public static void dfs(int n){
        if(visit[n]){
            done[n] = true;
            count++;
        }else{
            visit[n] = true;
        }

        if(!done[arr[n]]){
            dfs(arr[n]);
        }

        visit[n] = false;
        done[n] = true;
    }
}
