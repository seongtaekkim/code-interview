package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1806 부분합
 * https://www.acmicpc.net/problem/1806
 *
 * 투포인터 활용
 */
public class _1806 {
    static int N,S;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            S = Integer.parseInt(s[1]);

            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length+1];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int sum=0;
            int left=0;
            int right=0;
            int ans = Integer.MAX_VALUE;
            int size;
            while(right <= N) {
                if(sum >= S) {
                    sum -= arr[left++];
                    size = right - left + 1; // 길이를 구하기
                    if(ans > size) ans = size; // 길이의 최솟값
                }else if(sum < S) {
                    sum += arr[right++];
                }
            }
            System.out.println((ans) == Integer.MAX_VALUE ? 0 : ans);

        } catch (IOException e) {
            // TODO
        }


    }
}
