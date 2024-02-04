package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 6443 애너그램
 * https://www.acmicpc.net/problem/6443
 */
public class _6443 {
    static int N;

    static char[] str;
    static int[] visit = new int[26];

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)  {
                String x = br.readLine();
                str = new char[x.length()];
                for(int j=0; j<x.length(); j++)
                    visit[x.charAt(j) - 'a']++;
                dfs(0, x.length());
                Arrays.fill(visit, 0);
            }
        } catch (IOException e) {
            //TODO
        }
    }

    static void dfs(int x, int len) {
        if(x==len) {
            System.out.println(str);
        }  else {
            for(int i=0; i<26; i++) {
                if(visit[i] > 0) {
                    visit[i]--;
                    str[x] = (char)(i + 'a');
                    dfs(x+1, len);
                    visit[i]++;
                }
            }
        }
    }
}
