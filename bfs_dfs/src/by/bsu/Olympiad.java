package by.bsu;
/*. Олимпиада.
На олимпиаду прибыло n человек.
Некоторые из них знакомы между собой.
Круг знакомств задается матрицей A размером nxn.
A[i,j]=1, если i-й человек знает j-го, A[i,j]=0 в противном случае, знакомство является симметричным.
Необходимо определить, можно ли опосредованно перезнакомить всех людей между собой
(незнакомые люди могут познакомиться только через общего знакомого).
Если нет, то какое максимальное количество людей будет знать друг друга?

Для решения задачи найдем компоненты связности
*/
import java.util.Vector;

public class Olympiad {
    int vertexNUM;
    int[][] graph;
    boolean[] used;
    Vector<Vector<Integer>> components = new Vector<Vector<Integer>>();

    void dfs(int v) {
        used[v] = true;
        components.lastElement().add(v);
        for (int nv = 0; nv < vertexNUM; nv++) {
            if (!used[nv] && (graph[v][nv]==1))
                dfs(nv);
        }
    }

    public static void main(String[] args){
        Olympiad olympiad=new Olympiad();
        olympiad.graph= new int[][]{{0,1,1,0}, {1, 0,1,0},{1,1,0,1},{0,0,1,0}};
        olympiad.vertexNUM =4;
        olympiad.used=new boolean[olympiad.vertexNUM];
        for (int i = 0; i < olympiad.vertexNUM; i++) {
            if (!olympiad.used[i]) {
                olympiad.components.add(new Vector<Integer>());
                olympiad.dfs(i);
            }
        }
        System.out.println("Can all the people on the olympiad get to know each other?");
        if(olympiad.components.size()==1) {
            System.out.println("Yes");
        }else {
            int max=0;
            for (Vector<Integer> comp: olympiad.components) {
                if(comp.size()>max)
                    max=comp.size();
            }
            System.out.println("No, max number of people that will know each other: "+max);
        }

    }



}
