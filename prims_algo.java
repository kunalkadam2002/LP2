//O ( ( V + E ) l o g V )
import java.util.*;

public class prims_algo{
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
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,3,3));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,5));
        graph[1].add(new edge(1,2,8));

        graph[3].add(new edge(3,0,3));
        graph[3].add(new edge(3,1,5));
        graph[3].add(new edge(3,2,2));

        graph[2].add(new edge(2,3,2));
        graph[2].add(new edge(2,4,3));
        graph[2].add(new edge(2,1,8));
        
        graph[4].add(new edge(4,2,3));

    }

    static int spanningTree(int v, ArrayList<edge> graph[]){
        boolean[] vis = new boolean[v];
        PriorityQueue<edge> q=new PriorityQueue<>(); 
        q.add(new edge(0,0,0));
        int ans=0;

        while(!q.isEmpty()){
            edge cur = q.remove();
            //int u=cur.dest;
            if(!vis[cur.dest]){
                ans+=cur.wt;
                printmst(cur.src, cur.dest, cur.wt);
                vis[cur.dest] = true;
    
                //finding neighbour
                for(int i=0; i<graph[cur.dest].size(); i++){
                    edge e = graph[cur.dest].get(i);
                    int dest = e.dest;
                    int wt = e.wt;
                    int src = e.src;
                    if(vis[dest]==false){
                        q.add(new edge(src,dest,wt));
                    }
                }
            } 
        }
        return ans;
    }
    static void printmst(int src, int dest, int wt){
        int n=0, v=5;
        if(n<v && dest!=0){
            int s = src;
            int d = dest;
            int w = wt;
            System.out.println(s+"->"+d+" "+w);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        System.out.println(spanningTree(5, graph));
    }
}
