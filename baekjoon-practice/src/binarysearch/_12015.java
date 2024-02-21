package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 12015 가장 긴 증가하는 부분 수열 2
 * https://www.acmicpc.net/problem/12015
 *
 * dp로 구한다면 n^2이다.
 * 이분탐색을 활용하면 nlog(n)가 가능하다
 *
 * 배열을 반복하면서
 * arr[i] > vector.last 이면 vector에 추가하고
 * 그렇지 않으면
 * vector를 arr[i] 타겟으로 이분탐색하며 찾은 곳에 set 해준다.
 */
public class _12015 {
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
            System.out.println(lis.size());
            for (Integer i : lis)
                System.out.println(i + " ");
        } catch (IOException e) {
            // TODO
        }


    }
}
