package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 1238 파티
 * https://www.acmicpc.net/problem/1238
 */
public class _1238 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 간선개수
        start = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        int[] dist = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node curNode = q.poll();

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


        int[][] dist2 = new int[V + 1][V + 1];
        for (int i = 0; i < V + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                dist2[i][j] = Integer.MAX_VALUE;
            }
        }
        int end = start;
        int[] ret = new int[V+1];
        for (int i=1 ; i<=V ; i++) {
            q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            q.offer(new Node(i, 0));
            dist2[i][i] = 0;
            while (!q.isEmpty()) {
                Node curNode = q.poll();

                if (curNode.idx == end) {
//                    System.out.println(dist2[i][curNode.idx]);
                    ret[i] = curNode.cost;
                    break;
                }
                if (dist2[i][curNode.idx] < curNode.cost) {
                    continue;
                }

                for (int j = 0; j < graph.get(curNode.idx).size(); j++) {
                    Node nxtNode = graph.get(curNode.idx).get(j);
                    if (dist2[i][nxtNode.idx] > curNode.cost + nxtNode.cost) {
                        dist2[i][nxtNode.idx] = curNode.cost + nxtNode.cost;
                        q.offer(new Node(nxtNode.idx, dist2[i][nxtNode.idx]));
                    }
                }
            }
        }

        int max = 0;
        for (int i=1 ; i< dist.length ; i++) {
            if (max < dist[i] + ret[i]) {
                max = dist[i] + ret[i];
            }
        }
        System.out.println(max);
//        for (int i=1 ; i< dist.length ; i++) {
//            if (dist[i] == 2147483647)
//                System.out.println("INF");
//            else
//                System.out.println(dist[i]);
//        }
//        System.out.println();
//        for (int i=1 ; i< ret.length ; i++) {
//            System.out.println(ret[i]);
//        }
//        System.out.println();
//        for (int i=1 ; i< dist2.length ; i++) {
//            for (int j=1 ; j< dist2[0].length ; j++) {
//                System.out.print(dist2[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
