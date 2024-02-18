package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2473 세 용액
 * https://www.acmicpc.net/problem/2473
 *
 */
public class _2473 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int ret1=0, ret2=0, ret3=0;
            Long min = Long.MAX_VALUE;

            Arrays.sort(arr);

            // left,right 판정 while에 반복문을 하나 더 덮어서 세용액을 판정
            nest : for(int i=0 ; i<N-2 ; i++) {
                int left=i+1; // ret1에 i삽입을위해
                int right=N-1;

                while(left < right) {
                    long sum = (long)arr[i]+ (long)arr[left] + (long)arr[right];
                    if(min > Math.abs(sum)) {
                        min = Math.abs(sum);
                        ret1 = i;
                        ret2 = left;
                        ret3 = right;
                    }
                    if(sum == 0) {
                        ret1 =i; ret2=left; ret3=right;
                        break nest;
                    } else if(sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            System.out.println(arr[ret1]+" " + arr[ret2] + " " + arr[ret3]);

        } catch (IOException e) {
            // TODO
        }
    }
}
