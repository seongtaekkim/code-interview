package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3151 합이 0
 * https://www.acmicpc.net/problem/3151
 *
 *
 6
 -2 -2 0 1 1 1
 */
public class _3151 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i=0; i<N ; i++)
                arr[i] = Integer.parseInt(input[i]);

            long cnt=0;

            Arrays.sort(arr);
            long answer=0;
            for(int i=0 ; i<N-2 ; i++) {
                int left=i+1;
                int right=N-1;
                cnt=0;
                while(left < right) {
                    int sum = arr[i] + arr[left] + arr[right];
                    if(sum == 0) {
                        if(arr[left] == arr[right]){
                            answer+= (right-left);
//                            answer+= 1;
                            cnt=0;
                        }
                        else {
                            if(cnt==0) {
                                int idx = right;
                                while (idx > left && (arr[i] + arr[left] + arr[idx--] == 0)) {
                                    cnt++;
                                }
                            }
                            answer+=cnt;
                        }
                        left++;
                    } else if(sum > 0) {
                        right--;
                        cnt=0;
                    } else {
                        left++;
                        cnt=0;
                    }
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            // TODO
        }
    }
}
