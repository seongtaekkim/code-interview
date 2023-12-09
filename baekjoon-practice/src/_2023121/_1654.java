package _2023121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1654 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 */
public class _1654 {


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int K = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            int[] arr = new int[K];
            long max = 0;
            for (int i=0 ;i<K ; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                if (max < arr[i])
                    max = arr[i];
            }

            long low = 0;
            long len = max + 1;
            int numOfLine = 0;

            long mid = 0;
            while (low < len) {
                mid = (low + len) >>> 1;
                numOfLine = 0;
                for (int i=0 ;i<K ; i++) {
                    numOfLine += (arr[i] / mid);
                }
                if (numOfLine < N) {
                    len = mid;
                } else {
                    low = mid + 1;
                }

            }
            System.out.println(low-1);

        } catch (IOException e) {
            // TODO
        }
    }
}
