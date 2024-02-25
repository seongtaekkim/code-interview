package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 14003 가장 긴 증가하는 부분 수열 5
 * https://www.acmicpc.net/problem/14003
 *
 * 이분탐색을 하면서 dp배열에 해당값이 LIS의 몇번째 인덱스에 들어갔는지 저장한다.
 * Vector dp<int[i]> = (LIS index, 수열 값)
 */
// 100 50 70 90 75 87 105 78 110 60
// 100 50 70 60 80 30
public class _14003 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] arr = new int[in.length];
            for (int i=0; i<in.length; i++)
                arr[i] = Integer.parseInt(in[i]);
            Vector<Integer> lis = new Vector<>();
            Vector<int[]> dp = new Vector<>();
            for (int i=0 ; i<in.length ; i++) {
                if (!lis.isEmpty() && arr[i] > lis.lastElement()) {
                    lis.add(arr[i]);
                    dp.add(new int[]{lis.size()-1, arr[i]});
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
                    dp.add(new int[]{right, arr[i]});
                }
            }

            Vector<Integer> ret = new Vector<>();
            int lastIdx = lis.size()-1;
            for (int i=N-1; i>=0 ; i--) {
                if (dp.get(i)[0] == lastIdx) {
                    ret.add(dp.get(i)[1]);
                    lastIdx--;
                }
            }
            System.out.println(lis.size());
            for (int i=ret.size()-1; i>=0 ; i--) {
                System.out.print(ret.get(i) + " ");
            }
        } catch (IOException e) {
            // TODO
        }
    }
}
