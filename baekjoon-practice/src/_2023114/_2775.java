package _2023114;

import java.io.IOException;

/**
 * 2775 부녀회장이 될테야
 * https://www.acmicpc.net/problem/2775
 */
public class _2775 {

    public static void main(String[] args) throws IOException {

        int num = readInt();
        int[][] arr = new int[15][15];
        for (int i=1 ; i<arr[0].length ; i++)
            arr[0][i] = i;

        for (int i=1 ; i<arr.length ; i++) {
            for (int j=1; j<arr[0].length ; j++) {
                for (int k=1 ; k<=j ; k++) {
                    arr[i][j] += arr[i-1][k];
                }
            }
        }

        for (int i=0 ; i<num ; i++) {
            int k = readInt();
            int n = readInt();
            System.out.println(arr[k][n]);

        }

    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
