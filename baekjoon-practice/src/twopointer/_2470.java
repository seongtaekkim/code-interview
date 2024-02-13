package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2470 두 용액
 * https://www.acmicpc.net/problem/2470
 *
 * 2467 -> 두포인터
 * 2470 -> 이분탐색
 */
public class _2470 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int ret1=0, ret2=0;
            int min=Integer.MAX_VALUE;

            Arrays.sort(arr);

            for (int i=0; i<N; i++) {
                int start = i+1;
                int end = N-1;
                while (start <= end) {
                    int mid = (start+end)/2;

                    int sum = arr[i] + arr[mid];

                    if (Math.abs(sum) < min) {
                        ret1 = arr[i];
                        ret2 = arr[mid];
                        min = Math.abs(sum);
                    }

                    if (sum < 0) {
                        start = mid+1;
                    } else {
                        end = mid-1;
                    }
                }
            }
            System.out.println(ret1 + " " + ret2);

        } catch (IOException e) {
            // TODO
        }
    }
}
