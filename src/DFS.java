/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sree ram charan
 */
import java.util.*;
public class DFS {
    int V;
    LinkedList<Edge> adjList[];
    class Edge{
        int endVertex;
        int weight;
        Edge(int v,int w){
        endVertex=v;
        weight=w;
        }
        }
    DFS(int V){
        this.V=V;
        adjList=new LinkedList[V];
        for(int t=0;t<V;t++)
        adjList[t]=new LinkedList();
    }
    
public void addEdge(int u,int v,int edge){
    adjList[u].add(new Edge(v,edge));
        }
public void depthFirstSearch(int s,int visited[],int parent[]){
    visited[s]=1;
    System.out.print(s+" ");
    Iterator i=adjList[s].iterator();
    Edge edge;
    for(int t=0;t<adjList[s].size();t++){
        edge=(Edge)i.next();
        if(visited[edge.endVertex]!=1){
            parent[edge.endVertex]=s;
            depthFirstSearch(edge.endVertex,visited,parent);
        }
    }
}
 
public static void main(String ar[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no of Vertices: ");
    int V=sc.nextInt();
    DFS G=new DFS(V);
    G.addEdge(0,1,4);
    G.addEdge(0,2,5);
    G.addEdge(1,2,5);
    G.addEdge(2,0,1);
    G.addEdge(2,3,4);
    G.addEdge(3,3,0);
    int visited[]=new int[V];
    int parent[]=new int[V];
    int source=2;
    Arrays.fill(parent,-1);
 
    System.out.println("The order in which vertices are visted are");        
    G.depthFirstSearch(source,visited,parent);
    System.out.println("");
    System.out.println("The parentn of each node is ");
    for(int t=0;t<parent.length;t++)
        System.out.println("Paretn of " +t+ " is "+parent[t]);
}
}
