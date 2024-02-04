package backtracking;

import java.util.*;

/**
 * 17255 N으로 만들기
 * https://www.acmicpc.net/problem/17255
 *
 * 1. 만드려하는 N을 right, left 관점으로 1씩 줄여서 재귀한다.
 * 2. 줄이는 데이터를 String 변수에 append한다.
 * 3. 횟수를 만족하면, append한 String변수를 HashSet에 추가한다.
 */
public class _17255 {
    static String N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.next();

        bt(0, N.length());
        System.out.println(set.size());
    }

    static Set<String> set = new HashSet<>();
    static String data = "";
    private static void bt(int left, int right) {
        if (left == right-1) {
            set.add(data);
            return;
        }

        String tmp = N.substring(left + 1, right);
        data += tmp;
        bt(left + 1, right);
        data = data.substring(0, data.length()-tmp.length());

        tmp = N.substring(left, right-1);
        data += tmp;
        bt(left, right-1);
        data = data.substring(0, data.length()-tmp.length());

    }
}
