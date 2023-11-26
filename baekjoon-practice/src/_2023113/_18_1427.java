package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1427 소트인사이드
 * https://www.acmicpc.net/problem/1427
 */
public class _18_1427 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] arr = br.readLine().toCharArray();

            char tmp = 0;
            int minIdx = 0;
            for (int i=0 ; i<arr.length-1 ; i++) {
                minIdx = i;
                for (int j=i+1 ; j<arr.length ; j++) {
                    if (arr[minIdx] < arr[j])
                        minIdx = j;
                }
                tmp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = tmp;
            }
            for (int i=0 ; i<arr.length ; i++)
                System.out.print(arr[i]);
        }
    }
}
