package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2143 두 배열의 합
 * https://www.acmicpc.net/problem/2143
 *
 *
 * 이분탐색으로 품.
 * (투포인터로도 풀수 있다.)
 *
 * 배열 n,m의 부 배열의 합 모든 경우를 구한 다음 T와 비교해 구한다
 * n개의 원소를 갖는 배열의 부 배열의 크기는 n*(n-1)/2
 *
 */
public class _2143 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] arrN = new int[n];
            String[] in = br.readLine().split(" ");
            for (int i=0; i < n ; i++)
                arrN[i] = Integer.parseInt(in[i]);
            int m = Integer.parseInt(br.readLine());
            int[] arrM = new int[m];
            in = br.readLine().split(" ");
            for (int i=0; i < m ; i++)
                arrM[i] = Integer.parseInt(in[i]);

            int aSize = n*(n+1)/2; // num of 1~n sum
            int bSize = m*(m+1)/2; // sum of 1~m sum
            long[] aSum = new long[aSize];
            int idx=0;
            for(int i=0; i<n; i++) {
                int av=0;
                for(int j=i; j<n; j++) {
                    av += arrN[j];
                    aSum[idx++] = av;
                }
            }

            long[] bSum = new long[bSize];
            idx=0;
            for(int i=0; i<m; i++) {
                int bv = 0;
                for(int j=i; j<m; j++) {
                    bv += arrM[j];
                    bSum[idx++] = bv;
                }
            }

            Arrays.sort(aSum);
            Arrays.sort(bSum);

            long cnt=0;
            for(int i=0; i<aSize;) {
                long av = aSum[i];
                long aTerm = upper_bound(aSum, av) - lower_bound(aSum, av);
                long bTerm = upper_bound(bSum, T-av) - lower_bound(bSum, T - av);
                cnt += (aTerm * bTerm);
                i += aTerm;
            }
            System.out.println(cnt);

        } catch (IOException e) {
            // TODO
        }
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
