package graph;

import java.util.Arrays;

/**
 * Created by dmalladi on 12/23/2019.
 */
public class MotherVertex {

    public static int findMotherVertex(Graph g) {
        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);
        int lastV = -1;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(g,visited,i);
            }
            lastV = i;
        }

        Arrays.fill(visited,false);

        dfs(g,visited,lastV);
        for (int i = 0; i < vertices;i++) {
            if (!visited[i])
                return -1;
        }
        return lastV;
    }

    public static void dfs(Graph g,boolean[] visited,int source) {
        visited[source] = true;

        for (Integer vertex : g.getAdjList()[source]) {
            if (!visited[vertex]) {

                dfs(g,visited,vertex);
            }
        }

    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1,true);
        g.addEdge(1,2,true);
        g.addEdge(3,0,true);
        g.addEdge(3,1,true);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }
}
