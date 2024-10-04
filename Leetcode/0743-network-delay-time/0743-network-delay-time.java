import java.util.*;

class Edge {
    int next;
    int weight;

    public Edge(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new Edge(time[1], time[2]));
        }

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        pq.offer(new Edge(k, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.next;
            int time = edge.weight;

            if (time > dist[node]) {
                continue;
            }

            if (graph.containsKey(node)) {
                for (Edge ngb : graph.get(node)) {
                    int nextNode = ngb.next;
                    int totalTime = ngb.weight;

                    if (dist[nextNode] > dist[node] + totalTime) {
                        dist[nextNode] = dist[node] + totalTime;
                        pq.offer(new Edge(nextNode, dist[nextNode]));
                    }
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;

            result = Math.max(result, dist[i]);
        }

        return result;

    }
}