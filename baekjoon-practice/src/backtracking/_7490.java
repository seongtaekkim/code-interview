package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  7390 0 만들기
 *  https://www.acmicpc.net/problem/7490
 *
 *
 *  1. 1부터 operator를 append하면서 N만큼 재귀한다.
 *  2. 재귀를 완료하면 연산해서 0인지 확인하고 맞다면 list에 추가한다.
 */
public class _7490 {
    static int N;
    static int[] arr;
    static char[] ops = new char[] {'+','-',' '};
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int i=0; i<T ; i++) {
                N = Integer.parseInt(br.readLine());
                list = new ArrayList<>();
                bt("1",1);
                Collections.sort(list);
                for (String s : list)
                    System.out.println(s);
                System.out.println();
            }

        } catch (IOException e) {
            // TODO
        }
    }
static List<String> list;
    private static void bt(String str, int cnt) {
        if (cnt == N) {
            String s = str.replaceAll(" ", "");
            if (calc(s))
                list.add(str);
            return ;
        }
        for (int i=0;i<3;i++) {
            bt(str+ops[i]+ (cnt + 1), cnt+1);
        }
    }

    private static boolean calc(String s) {
        StringTokenizer st = new StringTokenizer(s,"+|-", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            if ("+".equals(op)) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        if (sum == 0)
            return true;
        return false;
    }
}
