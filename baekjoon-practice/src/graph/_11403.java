package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11403 경로 찾기
 * https://www.acmicpc.net/problem/11403
 *
 * 플로이드 와샬 (Floyd Warshall)
 */
public class _11403 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];
            for (int i=0; i<N ; i++) {
                String[] s = br.readLine().split(" ");
                for (int j=0; j<s.length ; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            for (int k=0; k<N ; k++) {
                for (int i=0; i<N ; i++) {
                    for (int j=0; j<N ; j++) {
                        if (arr[i][k] == 1 && arr[k][j] ==1)
                            arr[i][j] = 1;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<N ; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            // TODO
        }
    }
}
