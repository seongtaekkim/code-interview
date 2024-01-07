package divide_and_conquer;

import java.io.*;

/**
 * _2447 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 */
public class _2447 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());

            arr = new char[N][N];
            test(N, 0,0, false);

            StringBuilder sb = new StringBuilder();
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
static int N;
    static final int MIN = 3;
    static char[][] arr;
    private static void test(int n, int row, int col, boolean isSpace) {

        if (n == MIN) {
            for (int i=row ; i<row+3 ; i++) {
                for (int j=col ; j<col+3 ; j++) {
                    if (isSpace == true)
                        arr[i][j] = ' ';
                    else
                        arr[i][j] = '*';
                }
            }
            arr[row+1][col+1] = ' ';
            return;
        }
        int newN = n / 3;
        int maxidxR = row + n;
        int maxidxC = col + n;
        for (int i=row ; i<maxidxR ; i += n/3) {
            for (int j=col ; j<maxidxC ; j += n/3) {
                if ((i != row+n*1/3 || j != col+n*1/3) && isSpace == false) {
                    test(newN, i, j, false);
                } else
                    test(newN, i, j, true);
            }
        }


    }
}
