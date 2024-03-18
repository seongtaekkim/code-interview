package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * 2565 전깃줄
 * https://www.acmicpc.net/problem/2565
 */
public class _2565 {
    public static void main(String[] args) {
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(System.in))) {

                int N = Integer.parseInt(br.readLine());
                String[] in = null;
                int[] arr = new int[501]; // 0
                for (int i=0; i<N; i++) {
                    in = br.readLine().split(" ");
                    arr[Integer.parseInt(in[0])] = Integer.parseInt(in[1]);
                }

                Vector<Integer> lis = new Vector<>();
                for (int i=0 ; i<501 ; i++) {
                    if (arr[i] == 0) continue;
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
