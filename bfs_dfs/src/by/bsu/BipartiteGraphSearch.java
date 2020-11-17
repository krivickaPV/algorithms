package by.bsu;

import java.util.*;
/*Проверить граф на двудольность
*
* проверяем с помощью bfs*/

class BipartiteGraphSearch
{

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int vertex, int N)
    {
        boolean[] used = new boolean[N+1];
        int[] level = new int[N+1];
        used[vertex] = true;
        level[vertex] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        while (!queue.isEmpty())
        {
            vertex = queue.poll();
            for (int u : graph.get(vertex))
            {
                if (!used[u])
                {
                    used[u] = true;
                    level[u] = level[vertex] + 1;
                    queue.add(u);
                }
                else if (level[vertex] == level[u])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        final int N = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N + 1);
        for(int i = 0; i <= N; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);
        addEdge(adj, 7, 1);

        if (BFS(adj, 1, N))
            System.out.println("Bipartite Graph");
        else
            System.out.println("Not a Bipartite Graph");
    }
}