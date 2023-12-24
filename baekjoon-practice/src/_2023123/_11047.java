package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11047 동전 0
 * https://www.acmicpc.net/problem/11047
 */
public class _11047 {


    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            int[] arr = new int[N];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(br.readLine());

            int sum = 0;
            int cnt = 0;
            for (int i=N-1 ; i>=0 ; i--) {
                if (arr[i] > K) continue;
                if (arr[i] + sum > K) continue;
                sum += arr[i];
                cnt++;
                i++;
                if (sum == K) break ;
            }
            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }
    }

}
