
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sree ram charan
 */
public class DFS2 {
     int V;
     int graph[][];
    DFS2(int v){
        V=v;
        graph=new int[v][v];
    }
    
public void depthFirstSearch(int s,int visited[],int parent[]){
    visited[s]=1;
    System.out.print(s+" ");
        for(int v=0;v<graph.length;v++){
            if(graph[s][v]!=0 &&visited[v]!=1){
                parent[v]=s;
                depthFirstSearch(v,visited,parent);
            }
        }
    }

public static void main(String ar[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the no of Vertices: ");
    int V=sc.nextInt();
    DFS2 G=new DFS2(V);
    int visited[]=new int[V];
    int parent[]=new int[V];
    
    System.out.println("Enter the adjacency matrix of graph: " );
    for(int u=0;u<V;u++)
    for(int v=0;v<V;v++)
        G.graph[u][v]=sc.nextInt();
    
    System.out.println("Enter the source vertex: ");
    int source=sc.nextInt();
    parent[source]=-1;

    System.out.println("The order in which vertices are visted are");        
    G.depthFirstSearch(source,visited,parent);
    
    System.out.println("");
    System.out.println("The parentn of each node is ");
    
    for(int t=0;t<parent.length;t++)
        System.out.println("Paretn of " +t+ " is "+parent[t]);
}
}

