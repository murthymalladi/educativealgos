package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dmalladi on 12/20/2019.
 */
public class Graph {

    private int v;
    ArrayList<Integer> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.v = vertices;
        adjList = new ArrayList[vertices];

        for (int i = 0; i < vertices;i ++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public int getV() {
        return this.v;
    }

    public ArrayList<Integer>[] getAdjList() {
        return this.adjList;
    }
    public void addEdge(int source,int destination,boolean isDirected) {
        adjList[source].add(destination);
        if (!isDirected) {
            adjList[destination].add(source);
        }

    }

    public void printGraph() {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < this.v; i++)
        {
            if(adjList[i]!=null){
                System.out.print("|" + i + "| => ");

               Iterator<Integer> iter = adjList[i].iterator();
                while (iter.hasNext())
                {
                    System.out.print("[" + iter.next() + "] -> ");

                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1,true);
        g.addEdge(0,2,true);
        g.addEdge(1,3,true);
        g.addEdge(1,4,true);


       g.printGraph();
    }

}
