import java.util.*;

public class DFS_BFS {
    static class edge{
        int src;
        int dest;
        edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void create_graph(ArrayList<edge> graph[]){
        for(int i=0; i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,3));

        graph[2].add(new edge(2,1));
        graph[2].add(new edge(2,4));

        graph[3].add(new edge(3,1));
        graph[3].add(new edge(3,4));
        graph[3].add(new edge(3,5));

        graph[4].add(new edge(4,2));
        graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));

        graph[5].add(new edge(5,3));
        graph[5].add(new edge(5,4));
        graph[5].add(new edge(5,6));

        graph[6].add(new edge(6,5));
    }

    public static void DFS(ArrayList<edge> graph[], int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                DFS(graph,e.dest,vis);
            }
        }
    }

    static void BFS(ArrayList<edge> graph[], boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+ " ");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size(); i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v=7;
        ArrayList<edge> graph[] = new ArrayList[v];
        create_graph(graph);

        System.out.println("Dfs traversal is ");
        DFS(graph,0,new boolean[v]);

        System.out.println("\nBfs traversal is ");
        BFS(graph, new boolean[v]);
    }
}
