package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 20366 같이 눈사람 만들래?
 * https://www.acmicpc.net/problem/20366
 */
public class _20366 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int min = Integer.MAX_VALUE;

            Arrays.sort(arr);


            int sum=0;
            int sum0=0;
            nest: for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {

                    int left=0;
                    int right=N-1;
                    sum0= arr[i] + arr[j];
                    while(left < right) {
                        if (left == i || left == j) {
                            left++;
                            continue;
                        }
                        if (right == i || right == j) {
                            right--;
                            continue;
                        }
                        sum = arr[left] + arr[right];
                        if(min > Math.abs(sum-sum0)) {
                            min = Math.abs(sum-sum0);
                        }
                        if(sum == sum0) {
                            break nest;
                        } else if(sum > sum0) {
                            right--;
                        } else {
                            left++;
                        }
                }
            }
            }
            System.out.println(min);

        } catch (IOException e) {
            // TODO
        }
    }
}
