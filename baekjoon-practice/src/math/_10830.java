package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10830 행렬 제곱
 * https://www.acmicpc.net/problem/10830
 */
public class _10830 {

    final static int MOD = 1000;
    public static int N;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {


            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());

            int[][] origin = new int[N][N];
            int[][] result = new int[N][N];

            long B = Long.parseLong(st.nextToken());


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    origin[i][j] = Integer.parseInt(st.nextToken());
                }
                result[i][i] = 1;
            }


            while (B > 0) {

                if (B % 2 == 1)
                    result = multiply(result, origin);
                origin = multiply(origin, origin);

                B /= 2;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(result[i][j]).append(' ');
                }
                sb.append('\n');
            }

            System.out.println(sb);
        }
    }


    public static int[][] multiply(int[][] o1, int[][] o2) {

        int[][] ret = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
