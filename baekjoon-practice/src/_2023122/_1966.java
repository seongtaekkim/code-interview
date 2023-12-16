package _2023122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1966 프린터 큐
 * https://www.acmicpc.net/problem/1966
 */
public class _1966 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            Queue<QueueData> pq = null;
            for (int i=0 ; i<num; i++) {
                String[] line = br.readLine().split(" ");
                int N = Integer.parseInt(line[0]);
                int M = Integer.parseInt(line[1]);
                boolean flag = false;
                int cnt = 0;
                String[] data = br.readLine().split(" ");
                pq = new LinkedList<>();
                for (int j=0 ; j<N ; j++)
                    pq.add(new QueueData(Integer.parseInt(data[j]), j));
                while (true) {
                    Optional<QueueData> max = pq.stream().max(Comparator.comparing(f -> f.getPreority()));
                    for (int j = 0; j < N; j++) {
                        if (pq.peek() == max.get()) {
                            cnt++;
                            if (pq.peek().getIndex() == M) {
                                pq.poll();
                                System.out.println(cnt);
                                flag = true;
                                break;
                            } else
                                pq.poll();
                            break ;
                        } else {
                            pq.add(pq.poll());
                        }
                    }
                    if (flag == true)
                        break;
                }

            }
        } catch (IOException e) {
            // TODO
        }
    }
}

class QueueData implements Comparable<QueueData> {
    private int preority;
    private int index;

    public int getPreority() {
        return preority;
    }

    public int getIndex() {
        return index;
    }

    public QueueData(int preority, int index) {
        this.preority = preority;
        this.index = index;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        QueueData queueData = (QueueData) object;
        return preority == queueData.preority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(preority);
    }

    @Override
    public int compareTo(QueueData o) {
        return this.preority - o.preority;
    }

    @Override
    public String toString() {
        return "QueueData{" +
                "preority=" + preority +
                ", index=" + index +
                '}';
    }
}
