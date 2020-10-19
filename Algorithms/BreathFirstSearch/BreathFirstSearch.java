
package breathfirstsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

class Graph{
    ArrayList<ArrayList<Integer>>graph;
    int V;
    
    Graph(int nodes){
        V=nodes;
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    
    public void addEdge(int first,int second){
        graph.get(first).add(second);
         graph.get(second).add(first);
    }
    
    public void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print("Node"+i);
            for(int x:graph.get(i))System.out.print(" -> "+x);
            System.out.println();
        }
    }
    
    public void BFS(int start,int goal){
        boolean visited[]=new boolean[V];
        Queue<Integer>q=new LinkedList<Integer>();
        
        q.add(start);
        System.out.println("BFS Traversal");
        visited[start]=true;
        while(q.isEmpty()==false){
            int node=q.poll();
            System.out.print(node+" ");
            if(node==goal){
              break;
        }
            for(int x:graph.get(node)){
                if(visited[x]==false){
                    visited[x]=true;
                    q.add(x);
                }
            }
           
        }
        
    }
}
public class BreathFirstSearch {

    
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Nodes You Want in a graph");
        int nodes=sc.nextInt();
        Graph g=new Graph(nodes);
        System.out.println("Enter the number of Edges you want in a graph");
        int edges=sc.nextInt();
        sc.nextLine();
        System.out.println();
        for(int i=1;i<=edges;i++){
            System.out.println("Enter First Node for EDGE:-"+i);
            int first=sc.nextInt();
            System.out.println("Enter Second Node for EDGE:-"+i);
            int second=sc.nextInt();
            g.addEdge(first, second);
        }
        System.out.println("Enter the Starting Node You Want to traverse");
        int start=sc.nextInt();
        System.out.println("Enter the Goal Node");
        int goal=sc.nextInt();
        g.BFS(start,goal);
        
    }
    
}
