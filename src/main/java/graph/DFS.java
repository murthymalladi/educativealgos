package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dmalladi on 12/21/2019.
 */
public class DFS {

    public static String dfsTraversal(Graph g, int source) {
        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            visited[vertex] = true;
            sb.append(vertex);
            ArrayList<Integer>[] list = g.getAdjList();

            for (Integer node: list[vertex]) {
                if (!visited[node]) {
                    stack.push(node);
                }
            }
        }
        return sb.toString();

    }

    public static void dfsUtil(Graph g,int source,StringBuilder result,boolean[] visited) {
        visited[source]=true;
        result.append(source);

        for (Integer node : g.getAdjList()[source]) {
            if (!visited[node]) {
                dfsUtil(g,node,result,visited);
            }
        }
    }

    public static String dfsTraversal2(Graph g, int source) {

        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);
        StringBuilder result = new StringBuilder();
        dfsUtil(g,source,result,visited);

        return result.toString();
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1,true);
        g.addEdge(0,2,true);
        g.addEdge(1,3,true);
        g.addEdge(1,4,true);

        System.out.println(dfsTraversal(g, 0));
        System.out.println(dfsTraversal2(g, 0));
    }

}
