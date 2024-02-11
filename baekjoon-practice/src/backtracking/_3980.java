package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3980 선발 명단
 * https://www.acmicpc.net/problem/3980
 */
public class _3980 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            mat = new int[11][11];
            for (int k=0; k<N ; k++) {
                for (int i = 0; i < 11; i++) {
                    String[] in = br.readLine().split(" ");
                    for (int j = 0; j < in.length; j++) {
                        mat[i][j] = Integer.parseInt(in[j]);
                    }
                }
                bt(0,0);
                System.out.println(max);
                max=0;
                valid = new boolean[11];
            }
        } catch (IOException e) {
            // TODO
        }
    }
    static int[][] mat;
    static int max;
    static boolean[] valid = new boolean[11];
    private static void bt(int cnt, int sum) {
        if (cnt == 11) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 11; i++) {
            if(!valid[i] && mat[cnt][i] != 0) {
                valid[i] = true;
                bt(cnt + 1, sum + mat[cnt][i]);
                valid[i] = false;
            }
        }

    }


}
