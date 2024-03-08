package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2467 용액
 * https://www.acmicpc.net/problem/2467
 *
 *
 9
 -100 -99 99 0 1 2 3 4 5
 5
 -8 -3  30 90 80

 5
 -5 -4 -3 -2 0
 */
public class _2467 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<arr.length ; i++)
                arr[i] = Integer.parseInt(input[i]);

            int left=0;
            int right=arr.length-1;
            int ret1=arr[left], ret2=arr[right];
            int min=Integer.MAX_VALUE;
            Arrays.sort(arr);
            boolean flag = false;
            while(true){
                flag = false;
                int temp;
                while (left < right) {
                    if (left+1 >= right) break;
                    if (arr[left] + arr[right-1] > 0) {
                        right--;
                        flag = true;
                    } else if (arr[left] + arr[right-1] == 0) {
                        ret1 = arr[left];
                        ret2 = arr[right-1];
                        break ;
                    } else break;
                }
                while (left < right) {
                    if (left+1 >= right) break;
                    if (arr[left+1] + arr[right] < 0) {
                        left++;
                        flag = true;
                    } else if (arr[left+1] + arr[right] == 0) {
                        ret1 = arr[left+1];
                        ret2 = arr[right];
                        break ;
                    } else break;
                }
                temp = Math.abs(arr[left] + arr[right]);
                if(min >= Math.abs(temp)){
                    min = Math.abs(temp);
                    ret1 = arr[left];
                    ret2 = arr[right];
                }
                if (!flag) break;
            }

            System.out.println(ret1 + " " + ret2);
        } catch (IOException e) {
            // TODO
        }
    }
}
