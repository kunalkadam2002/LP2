//O ( V + E l o g V )
import java.util.*;

public class Dijestra{
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static void create_graph(ArrayList<edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,2,4));
        graph[0].add(new edge(0,1,2));
        
        graph[1].add(new edge(1,0,2));
        graph[1].add(new edge(1,2,3));
        graph[1].add(new edge(1,3,1));
        
        graph[2].add(new edge(2,0,4));
        graph[2].add(new edge(2,1,3));
        graph[2].add(new edge(2,3,1));
        graph[2].add(new edge(2,4,9));
        
        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,2,1));
        graph[3].add(new edge(3,5,2));

        graph[4].add(new edge(4,2,9));
        graph[4].add(new edge(4,5,1));
        
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,3,2));


    }

    static class pair implements Comparable<pair>{
        int dest;
        int wt;
        public pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
        public int compareTo(pair p2){
            return this.wt-p2.wt;
        }
    }


    static int[] spanningTree(int v, int s, ArrayList<edge> graph[]){
        boolean vis[] = new boolean[v];
        PriorityQueue<pair> q = new PriorityQueue<>();

        q.add(new pair(0,0));
        int ans[] =new int[v];
        Arrays.fill(ans,100000);
        ans[s]=0;

        while(q.size()!=0){
            pair curr = q.remove();
            if(!vis[curr.dest]){
                int u = curr.dest;
                vis[u]=true;
                for(int i=0; i<graph[u].size(); i++){
                    edge e = graph[u].get(i);
                    int dest = e.dest;
                    int wt = e.wt;
                    if(ans[dest] > ans[u]+wt){
                        ans[dest] = ans[u]+wt;
                        q.add(new pair(dest,ans[dest]));
                    }
                }
            }
        }
        for(int i=0; i<v; i++){
            System.out.println(s+"->"+i+" "+ans[i]);
        }
        return ans;
    } 


    public static void main(String[] args) {
        int v=6,s=0;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);
        spanningTree(v, s, graph);
        
    }
}