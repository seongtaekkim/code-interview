package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2295 세 수의 합
 * https://www.acmicpc.net/problem/2295
 */
public class _2295 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
// 2 3 5 10 18
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i=0; i<arr.length ; i++)
                arr[i] = Integer.parseInt(br.readLine());

//            int m = (n * n +1 /2);
            int[] arrN = new int[n * (n+1)/2];
            int idx=0;
            for (int i=0; i < n ; i++)
                for (int j=i; j < n ; j++)
                    arrN[idx++] = arr[i] + arr[j];

            Arrays.sort(arrN);
            int ans = Integer.MIN_VALUE;
            for (int i=0 ;i<arr.length; i++) {
                for (int j=0; j<arr.length ; j++) {
                    if (bs(arrN, arr[i] - arr[j])) {
                        ans = Math.max(ans, arr[i]);
                    }
                }
            }

            System.out.println(ans);

        } catch (IOException e) {
            // TODO
        }
    }

    private static boolean bs(int[] arr, int data) {
        int left=0;
        int right=arr.length-1;

        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid] > data)
                right = mid - 1;
            else if (arr[mid] < data)
                left = mid +1;
            else
                return true;
        }
        return false;
    }

    static int upper_bound(long[] arr, long t) {
        int left = 0;
        int right = arr.length;

        while(left < right) {
            int mid = (left + right)/2;

            if(t >= arr[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    static int lower_bound(long[] arr, long t) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right)/2;

            if (t <= arr[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}
