package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dmalladi on 12/21/2019.
 */
public class BFS {

    public static String bfsTraversal(Graph g,int source) {
        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;


        while(!queue.isEmpty()) {

            int vertex = queue.poll();
            sb.append(vertex);
            ArrayList<Integer>[] list = g.getAdjList();
            for (Integer node:list[vertex]) {
                if (!visited[node]) {
                    visited[node]=true;
                    queue.add(node);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1,true);
        g.addEdge(0,2,true);
        g.addEdge(1,3,true);
        g.addEdge(1,4,true);


        System.out.println(bfsTraversal(g, 0));
    }
}
