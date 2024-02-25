package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 11053 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 *
 * 2중반복문에서 배열범위를 1부터 N-1까지 늘려가며 arr[i] >arr[j] 인경우  비교해서 dp에 해당 i 값을 하나씩 ++ 해서
 * 마지막에 수열길이가 가장 긴 값을 출력함
 *
 */
public class _11053 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] arr = new int[in.length];
            for (int i=0; i<in.length; i++)
                arr[i] = Integer.parseInt(in[i]);
            int[] dp = new int[in.length];
            for (int i=0 ; i<in.length ; i++) {
                for (int j=0 ; j<i ; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            System.out.println(Arrays.stream(dp).max().getAsInt()+1);;
        } catch (IOException e) {
            // TODO
        }


    }
}
