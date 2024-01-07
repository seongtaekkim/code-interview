package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 5430 AC
 * https://www.acmicpc.net/problem/5430
 */
public class _5430 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());
            char[] cmd;
            for (int i=0; i<T ; i++) {
                cmd = br.readLine().toCharArray();
                int N = Integer.parseInt(br.readLine());
                Deque<Integer> deque = new ArrayDeque<>();
                String line = br.readLine();
                if (N != 0) {
                    String[] data = line.substring(1, line.length() - 1).split(",");
                    for (int j = 0; j < N; j++) {
                        deque.add(Integer.parseInt(data[j]));
                    }
                }

                boolean isToggle = false;
                for (int j=0; j<cmd.length ;j++) {
                    if (cmd[j] == 'R') {
                        isToggle = isToggle == false ? true : false;
                    } else if (cmd[j] == 'D')  {
                        if (deque.size() == 0) {
                            System.out.println("error");
                            deque = null;
                            break ;
                        }
                        Integer i1 = isToggle == false ? deque.pollFirst() : deque.pollLast();
                    }
                }
                if (deque == null)
                    continue;
                StringBuilder sb = new StringBuilder();
                int size = deque.size()-1;
                if (!isToggle) {
                    for (int j=0 ;j<size ; j++) {
                        sb.append(deque.pollFirst()).append(",");
                    }
                    if (!deque.isEmpty())
                        sb.append(deque.pollFirst());
                } else {
                    for (int j=0 ;j<size ; j++) {
                        sb.append(deque.pollLast()).append(",");
                    }
                    if (!deque.isEmpty())
                        sb.append(deque.pollLast());
                }
                System.out.print("[" + sb + "]\n");
            }
        } catch (IOException e) {
            // TODO
        }
    }
}
