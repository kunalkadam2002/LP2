//O(E logE) or O(V logV) 
import java.util.*;

public class kruskals{
    static class edge implements Comparable<edge>{
        int src;
        int dest;
        int wt;
        public edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        public int compareTo(edge p2){
            return this.wt-p2.wt; 
        }
    }
    static void create_graph(ArrayList<edge> graph[]){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,2,1));
        graph[0].add(new edge(0,1,5));

        graph[1].add(new edge(1,0,5));
        graph[1].add(new edge(1,2,6));
        graph[1].add(new edge(1,3,4));
        graph[1].add(new edge(1,4,8));
        
        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,1,6));
        graph[2].add(new edge(2,3,2));

        graph[3].add(new edge(3,1,4));
        graph[3].add(new edge(3,2,2));
        graph[3].add(new edge(3,4,7));

        graph[4].add(new edge(4,1,8));
        graph[4].add(new edge(4,3,7));

    }
   
    static int spanningTree(int v, ArrayList<edge> graph[]){
        boolean[] vis = new boolean[v];
        PriorityQueue<edge> q=new PriorityQueue<>();
        int ans = 0; 

        for(int i=0;i<v;i++){
            for(int j=0; j<graph[i].size(); j++){
                edge e = graph[i].get(j);
                int src=e.src;
                int dest=e.dest;
                int wt=e.wt;
                q.add(new edge(src,dest,wt));
            }
        }

        while(!q.isEmpty()){
            edge curr = q.remove();

            if(!vis[curr.src] || !vis[curr.dest]){
                ans+=curr.wt;
                vis[curr.src]=true;
                vis[curr.dest]=true;
                System.out.println(curr.src+"->"+curr.dest+" "+curr.wt);
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        System.out.println(spanningTree(5, graph));
    }
}