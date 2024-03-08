package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1561 놀이 공원
 * https://www.acmicpc.net/problem/1561
 */
public class _1561 {

    static long N;
    static int M;
    static int[] time;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().split(" ");
            N = Long.parseLong(in[0]);
            M = Integer.parseInt(in[1]);
            time = new int[M];
            if(N <= M) {
                System.out.println(N);
                return;
            }
            in = br.readLine().split(" ");
            for (int i=0 ;i<M ; i++)
                time[i] = Integer.parseInt(in[i]);

            long result = binarySearch();
            long child = getChildNumInTime(result-1);

            for(int i=0; i<M; i++) {
                if(result%time[i]==0) {
                    child++;
                }
                if(child == N) {
                    System.out.println(i+1);
                    break;
                }
            }
        } catch (IOException e) {
            // TODO
        }
    }
    private static long getChildNumInTime(long t) {
        long childNum = M;
        for(int i=0; i<M; i++)
            childNum += t/time[i];
        return childNum;
    }

    private static long binarySearch() {
        long l = 0;
        long r = N*30;
        while(l <= r) {
            long mid = (l+r) / 2;
            long childNum = getChildNumInTime(mid);

            if(childNum < N)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
