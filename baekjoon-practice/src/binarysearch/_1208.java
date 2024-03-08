package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1208 부분수열의 합 2
 * https://www.acmicpc.net/problem/1208
 *
 *N개의 정수로 이루어진 수열의 부분수열을 구한 다음 모든 합을 고려해주어야 한다. 연속된 부분수열이 아님을 주의하자. 부분수열의 총 갯수는 2^N-1인데, 해당 문제는 공집합(0)도 포함하므로 총 2^N개를 고려해줘야 한다. 2^40은 13자리를 가지는 정수이므로 범위를 초과한다.
 *
 *
 *
 * 그래서 N/2, N-(N/2)를 가지는 두 수열로 나눈 다음 각 부분수열을 구하게되면 최대 2^20 = 104,8576이므로 충분히 커버가 가능하다. 이제 다음과 같이 비트마스킹을 사용하여 수열의 부분집합을 구하면 된다.
 *
 *
 *
 * 이진탐색은 upper_bound와 lower_bound를 사용하여 합이 s가 되는 구간을 구해서 카운트를 해주면 된다.
 *
 * 하나의 부분수열의 집합을 기준으로 값을 설정한다. for i:0~a.length-1  v = a[i];
 * a배열에서 v인 구간과 b배열에서 s-v인 구간을 찾는다.
 * long aTerm = upper_bound(a, av) -lower_bound(a, av);
 * long bTerm = upper_bound(b, s-av)-  lower_bound(b, s-av);
 *
 *
 * 마지막으로 a배열과 b배열에 공집합이 각각 있으므로 만약 s가 0이라면 cnt-1을 해주어야한다.
 */
public class _1208 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int S = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            int[] arr = new int[s.length];
            for (int i=0; i<arr.length; i++)
                arr[i] = Integer.parseInt(s[i]);

            int size = N / 2;
            int lSide = 1<<(N - size);
            int rSide = 1 << size;
            int[] a = new int[1<<(N - size)];
            int[] b = new int[1<<(size)];
            for(int i=0; i<(1<<N - size); i++) {
                for(int j=0; j<N - size; j++) {
                    System.out.println((1<<j) + " "  + (i&(1<<j)) + " " + i);
                    if((i&(1<<j))==(1<<j)) {
                        a[i] +=arr[j];
                    }
                }
            }
            for(int i=0; i<(1<<size); i++) {
                for(int j=0; j<size; j++) {
                    if((i&(1<<j))==(1<<j)) {
                        b[i]+= arr[j+(N - size)];
                    }
                }
            }

            Arrays.sort(a);
            Arrays.sort(b);
            long cnt=0;
            for(int i=0; i<a.length;) {
                int av = a[i];
                long aTerm = upper_bound(a, av) - lower_bound(a, av);
                long bTerm = upper_bound(b, S - av) - lower_bound(b, S - av);
                cnt+= aTerm*bTerm;
                i+=aTerm;
            }
            if(S == 0) cnt--;
            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }


    }
    static int upper_bound(int[] arr, int t) {
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

    static int lower_bound(int[] arr, int t) {
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
