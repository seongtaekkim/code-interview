package divide_and_conquer;

import java.io.*;
import java.util.Arrays;

/**
 * _2448 별 찍기 - 11
 * https://www.acmicpc.net/problem/2448
 */
public class _2448 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            int M = N * 2 -1;
            arr = new char[N][M];
            for (int i = 0; i < N; i++)
                Arrays.fill(arr[i], ' ');

            test(0, N-1, N);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (char[] c2 : arr) {
                for (char c : c2) {
                    bw.write(c);
                }
                bw.write('\n');
            }
            bw.flush();
        } catch (IOException e) {
            // TODO
        }
    }
    static final int MIN = 3;
    static char[][] arr;
    private static void test(int r, int c, int n) {

        if (n == MIN) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 2] = arr[r + 2][c - 1] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
            return;
        }
        int half = n / 2;
        test(r, c, half);
        test(r + half, c - half, half);
        test(r + half, c + half, half);

    }
}
