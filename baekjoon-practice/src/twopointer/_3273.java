package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3273 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
public class _3273 {
    static int[] arr;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            arr = new int[input.length];
            for (int i=0; i<n ; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            int x = Integer.parseInt(br.readLine());

            int left=0, right = n-1;
            int cnt=0;
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == x) {
                    cnt++;
                    left++;
                    right--;
                } else if(sum > x) {
                    right--;
                } else {
                    left++;
                }
            }

            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }
    }
}
