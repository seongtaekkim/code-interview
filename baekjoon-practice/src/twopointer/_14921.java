package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 14921 용액 합성하기
 * https://www.acmicpc.net/problem/14921
 */
public class _14921 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int ret1=0, ret2=0;
            int min = Integer.MAX_VALUE;

            Arrays.sort(arr);

            int left=0;
            int right=N-1;

            while(left < right) {
                int sum = arr[left] + arr[right];
                if(min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ret1 = left;
                    ret2 = right;
                }
                if(sum == 0) {
                    ret1=left; ret2=right;
                    break ;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            System.out.println(arr[ret1]+arr[ret2]);

        } catch (IOException e) {
            // TODO
        }
    }
}
