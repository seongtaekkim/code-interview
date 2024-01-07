package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1916 최소비용 구하기
 * https://www.acmicpc.net/problem/1916
 */
public class _1916 {
    static int V, E, start;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine()); // 간선개수
        E = Integer.parseInt(br.readLine()); // 노드개수
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        StringTokenizer st = null;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node curNode = q.poll();

			if (curNode.idx == end) {
				System.out.println(dist[curNode.idx]);
				return;
			}
            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);
                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
