package _2023122;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 1003 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 */
public class _1003 {

    static int[] arr = new int[1000];
    static int[] arr_one = new int[1000];
    static int[] arr_zero = new int[1000];
    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (arr[n] == 0) {
                return fibonacci(n - 1) + fibonacci(n - 2);
            } else
                return arr[n];
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            int n = 0;
            arr[1] = 1;
            arr_one[0] =0;
            arr_one[1] =1;
            arr_zero[0] =1;
            arr_zero[1] =0;
            for (int i=0 ; i<N ; i++) {
                n = Integer.parseInt(br.readLine());
                for (int j=2; j<=n ; j++) {
                    arr[j] = fibonacci(j);
                    arr_one[j] = arr_one[j-1] + arr_one[j-2];
                    arr_zero[j] = arr_zero[j-1] + arr_zero[j-2];
                }
                System.out.println(arr_zero[n] + " " + arr_one[n]);
            }


        } catch (IOException e) {
            // TODO
        }
    }
}
