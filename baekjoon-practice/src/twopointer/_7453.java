package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 7453 합이 0인 네 정수
 * https://www.acmicpc.net/problem/7453
 *
 *
 * left = 0, right = N*N - 1에서 시작하여, AB[left] + CD[right]의 합에 따라 투 포인터방식 처리.
 * 동등한 두 집합으로 나누어 시간복잡도를 대략 root로 줄이는 알고리즘
 *  (브루트포스 O(N^4) -> O(N^2logN))을 'meet in the middle' 알고리즘이라 명명한다.
 * 정답은 최대 16000000^2까지 가능(각 배열 4000개). => long
 *
 */

public class _7453 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[4][N];
            for (int i=0; i<N ; i++) {
                String[] input = br.readLine().split(" ");
                arr[0][i] = Integer.parseInt(input[0]);
                arr[1][i] = Integer.parseInt(input[1]);
                arr[2][i] = Integer.parseInt(input[2]);
                arr[3][i] = Integer.parseInt(input[3]);
            }

//            Arrays.sort(arr[0]);
//            Arrays.sort(arr[1]);
//            Arrays.sort(arr[2]);
//            Arrays.sort(arr[3]);

            int[] AB = new int[N*N];
            int[] CD = new int[N*N];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    AB[idx] = arr[0][i] + arr[1][j];
                    CD[idx++] = arr[2][i] + arr[3][j];
                }
            }

            Arrays.sort(AB);
            Arrays.sort(CD);

            long ans = 0;
            int left = 0;
            int right = N*N-1;
            while (left <= N*N-1 && right >= 0) {
                if (AB[left] + CD[right] > 0) {
                    right--;
                } else if (AB[left] + CD[right] < 0) {
                    left++;
                } else {
                    long leftCount = 1, rightCount = 1;
                    while (left + 1 < N*N && (AB[left] == AB[left+1])) {
                        leftCount++;
                        left++;
                    }
                    while (right > 0 && (CD[right] == CD[right-1])) {
                        rightCount++;
                        right--;
                    }
                    ans += leftCount * rightCount; // 경우의수를 구하기위해 곱하여 더한다.
                    left++;
                }
            }

            System.out.println(ans);

//            int sum=0;
//            long cnt=0;
//            long answer=0;
//            for (int i=0; i<N; i++) {
//                for (int j=0; j<N; j++) {
//
////                    cnt=0;
//                    int left=0;
//                    int right=N-1;
//                    while(left <= N-1 && right >= 0) {
//                        sum = arr[0][i] + arr[1][j] + arr[2][left] + arr[3][right];
//                        if(sum == 0) {
//                            cnt++;
////                            System.out.println( arr[0][i] + " " + arr[1][j] + " " +  arr[2][left] + " " +  arr[3][right]);
////                            cnt++;
//                            while (left < N-1 && (arr[0][i] + arr[1][j] + arr[2][left+1] + arr[3][right] == 0)) {
//                                left++;
//                                cnt++;
//                            }
//                            while (right > 0 && (arr[0][i] + arr[1][j] + arr[2][left] + arr[3][right-1] == 0)) {
//                                right--;
//                                cnt++;
//                            }
////                            answer+=cnt;
//                            left++;
////                            break nest;u
//                        } else if(sum > 0) {
//                            right--;
////                            cnt=0;
//                        } else {
//                            left++;
////                            cnt=0;
//                        }
//                }
//            }
//            }
//            System.out.println(answer);
//            System.out.println(cnt);
        } catch (IOException e) {
            // TODO
        }
    }
}
