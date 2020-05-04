package Graphs;
//This example demonstrates Adjacency List in Graph Theory
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Each Node will have list ( linked list here) which has adjacent vertices
class List{
    int node;
    List next;
}

//Maintaining Nodes in Graph
class Node {
    int node;
    List adjList;
    boolean visit;
}

public class Graphs {
    void insertVertices() throws IOException
    {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of nodes in a graph: ");
        int n=(Integer.parseInt(br.readLine()));
        Node g[]=new Node[n];
        for (int i = 0; i < n; i++) {
            g[i]=new Node();
            g[i].node=i+1;
            g[i].visit=false;
            while(true)
            {
                System.out.println("Enter zero to stop");
                System.out.println("Enter adjacent nodes to node "+(i+1)+" :");
                 int adjVertex=Integer.parseInt((br.readLine()));
                 if(adjVertex==0)
                     break;
                 else
                 {
                        List l=new List();
                        l.node=adjVertex;
                        l.next=null;
                        if(g[i].adjList==null)
                        {
                            g[i].adjList=l;
                        }
                        else
                        {
                            List p=g[i].adjList;
                            while(p.next!=null){
                                p=p.next;
                            }
                            p.next=l;
                        }
                 }
            }
        }
        System.out.println("Adjacency matrix representation");
        for (int i = 0; i < n; i++) {
            System.out.print(g[i].node+" --> ");
            List l=g[i].adjList;
            while(l!=null)
            {
                System.out.print(l.node+" --> ");
                l=l.next;
            }
            System.out.println("");
        }
        
        getAdjacentVertices(g[0]);
    }

    public static void main(String[] args) throws IOException {
             new Graphs().insertVertices();
    }
    
    private void getAdjacentVertices(Node node)
    {
    	List list = node.adjList;
    	System.out.println(" Adjacent vertices of " + node.node);
    	while(list != null)
    	{
    		System.out.print(" ---> " + list.node);
    		list = list.next;
    	}
    	
    }

}
