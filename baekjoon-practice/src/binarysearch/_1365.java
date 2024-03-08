package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 1365 꼬인 전깃줄
 * https://www.acmicpc.net/problem/1365
 *
 */
public class _1365 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] arr = new int[in.length];
            for (int i=0; i<in.length; i++)
                arr[i] = Integer.parseInt(in[i]);
            Vector<Integer> lis = new Vector<>();
            for (int i=0 ; i<in.length ; i++) {
                if (!lis.isEmpty() && arr[i] > lis.lastElement()) {
                    lis.add(arr[i]);
                } else {
                    int left=0;
                    int right=lis.size();
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (lis.get(mid) < arr[i])
                            left = mid+1;
                        else
                            right = mid;
                    }
                    if (lis.size() <= right)
                        lis.add(arr[i]);
                    else
                        lis.set(right, arr[i]);
                }
            }
            System.out.println(N - lis.size());
        } catch (IOException e) {
            // TODO
        }


    }
}
