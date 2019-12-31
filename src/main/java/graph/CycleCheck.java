package graph;

/**
 * Created by dmalladi on 12/23/2019.
 */
public class CycleCheck {

    public static boolean detectCycle(Graph g){

        int vertices = g.getV();
        boolean[] visited = new boolean[vertices];
        boolean[] stackRec = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (cycleDetectUtil(i,g,visited,stackRec)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(int source,Graph g,boolean[] visited,boolean[] stackRec) {

        if (stackRec[source])
            return true;
        if (visited[source])
            return false;

        visited[source] = true;
        stackRec[source] = true;

        for (Integer vertex : g.getAdjList()[source]) {
            if (cycleDetectUtil(vertex,g,visited,stackRec)) {
                return true;
            }
        }
        stackRec[source] = false;
        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1,true);
        g1.addEdge(1,2,true);
        g1.addEdge(1,3,true);
        g1.addEdge(3,0,true);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1,true);
        g2.addEdge(1,2,true);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}
