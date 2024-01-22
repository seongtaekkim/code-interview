package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1629 곱셈
 * https://www.acmicpc.net/problem/1629
 */
public class _1629 {

    public static long func(int a, int b, int c) {
        if (b > 1) {
            long ret = func(a, b / 2, c);
            if (b % 2 != 0) return ((ret * ret % c) * a) % c ;
            else return ret * ret % c ;
        }
        return a;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            System.out.println(func(A,B,C) % C);
        } catch (IOException e) {
            // TODO
        }
    }
}
