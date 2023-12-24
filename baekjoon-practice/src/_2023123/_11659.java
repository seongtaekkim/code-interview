package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 11659 구간 합 구하기 4
 * https://www.acmicpc.net/problem/11659
 */
public class _11659 {


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int[] arr = new int[N+1];
            int[] accumulate = new int[N+1];
            String[] data = br.readLine().split(" ");
            for (int i=1; i<=N ; i++) {
                arr[i] = Integer.parseInt(data[i-1]);
            }
            accumulate[1] = arr[1];
            for (int i=2 ; i<=N ; i++) {
                accumulate[i] = accumulate[i-1] + arr[i];
            }
            for (int i=0 ; i<M ; i++) {
                String[] range = br.readLine().split(" ");
                int strt = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                int sum = accumulate[end] - accumulate[strt-1];
                sb.append(sum).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO
        }
    }

}
