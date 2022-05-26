import java.util.*;
import java.util.Queue;

public class BFS{
    private int n;
    private LinkedList<Integer> adjList[];
    private Queue<Integer> queues = new LinkedList();
    public void makeGraph(int no) {
        n = no;
        adjList =  new LinkedList[no];
        int i;
        for (i= 0; i < no; i++) {
            adjList[i] = new LinkedList();
        }
    }
    public void addEdgeToGraph(int u, int v) {
        adjList[u].add(v);
    }
    public void BFtraversal(int v, boolean[] visited)
    {
        queues.add(v);
        visited[v]  =  true;
        int k;
        while( !queues.isEmpty() ) {
            k = queues.remove();
            System.out.print( k +" ");
// we are iterating through adjacency list of vertex k which has to be explored now.
// it will give the adjacent nodes of each vertex.
            Iterator<Integer> iterate = adjList[k].listIterator();
            int j;
            while(iterate.hasNext()) {
                j = iterate.next();
                if( visited[j] != true ) {
                    queues.add(j);
                    visited[j] = true;
                }
            }
        }
    }
    public void BFsearch(int v) {
        boolean wheater[] = new boolean[n];
        BFtraversal(v, wheater);
        for ( int i = 0; i < n; i++ ){
            if( wheater[i] != true ){
// if found it will call again  BFtraversal
                BFtraversal(i, wheater);
            }
        }
    }
}