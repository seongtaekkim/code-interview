package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 27172 수 나누기 게임
 * https://www.acmicpc.net/problem/27172
 */
public class _27172 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            boolean[] cards = new boolean[1000001];
            int[] players = new int[N];
            int[] scores = new int[1000001];
            String[] in = br.readLine().split(" ");
            for (int i=0; i<N ; i++)
                players[i] = Integer.parseInt(in[i]);
            for (int i=0; i<N ; i++) {
                cards[players[i]] = true;
            }
            for (int i : players) {
                for (int j=i*2 ; j<cards.length ; j+=i) {
                    if (cards[j]) {
                        scores[i]++;
                        scores[j]--;
                    }
                }
            }
            for (Integer i : players) {
                System.out.print(scores[i] + " ");
            }

        } catch (IOException e) {
            //TODO
        }
    }
}
