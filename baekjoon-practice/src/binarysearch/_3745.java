package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 3745 오름세
 * https://www.acmicpc.net/problem/3745
 */
public class _3745 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String read = null;
            while((read = br.readLine()) != null) {
                int N = Integer.parseInt(read.trim());
                String[] in = br.readLine().split(" ");
                int[] arr = new int[in.length];
                for (int i = 0; i < in.length; i++)
                    arr[i] = Integer.parseInt(in[i]);
                Vector<Integer> lis = new Vector<>();
                for (int i = 0; i < in.length; i++) {
                    if (!lis.isEmpty() && arr[i] > lis.lastElement()) {
                        lis.add(arr[i]);
                    } else {
                        int left = 0;
                        int right = lis.size();
                        while (left < right) {
                            int mid = (left + right) / 2;
                            if (lis.get(mid) >= arr[i])
                                right = mid;
                            else
                                left = mid+1;
//                            if (lis.get(mid) < arr[i])
//                                left = mid + 1;
//                            else
//                                right = mid;
                        }
                        if (lis.size() <= right)
                            lis.add(arr[i]);
                        else
                            lis.set(right, arr[i]);
                    }
                }
                sb.append(lis.size() + "\n");
            }
        } catch (Exception e) {
            // TODO
        } finally {
            System.out.println(sb.toString());
        }

    }
//    static int lowerbound(int s, int e, int key) {
//        while(s < e) {
//            int mid = (s+e)/2;
//
//            if(dp[mid] >= key) {
//                e = mid;
//            }else {
//                s = mid+1;
//            }
//        }
//        return e;
//    }
}
