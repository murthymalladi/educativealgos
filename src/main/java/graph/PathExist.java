package graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by dmalladi on 12/23/2019.
 */
public class PathExist {

    public static boolean checkPath(Graph g, int source, int destination) {
        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);


        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            visited[vertex] = true;
            for (Integer node : g.getAdjList()[vertex]) {
                if (node == destination)
                    return true;
                if (!visited[node])
                    stack.push(node);
            }
        }
        return false;
    }



    public static void main(String args[]) {

        Graph g1 = new Graph(9);
        g1.addEdge(0,2,true);
        g1.addEdge(0,5,true);
        g1.addEdge(2,3,true);
        g1.addEdge(2,4,true);
        g1.addEdge(5,3,true);
        g1.addEdge(5,6,true);
        g1.addEdge(3,6,true);
        g1.addEdge(6,7,true);
        g1.addEdge(6,8,true);
        g1.addEdge(6,4,true);
        g1.addEdge(7,8,true);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1,true);
        g2.addEdge(1,2,true);
        g2.addEdge(1,3,true);
        g2.addEdge(2,3,true);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }
}
