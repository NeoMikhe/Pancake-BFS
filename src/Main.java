import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        
        long startTime = System.currentTimeMillis();
        //List<Character> pancakeList = Arrays.asList("A", "B", "C", "D", "E");
        ArrayList<Character> pancakeList = new ArrayList<Character>();
        ArrayList<Character> pancakeListVerify = new ArrayList<Character>();
        ArrayList<Character> pancakePart = new ArrayList<Character>();
        ArrayList<Character> pancakeListCopy = new ArrayList<Character>();
        int cont = 1, aux = 0, contAux = 0;
        // 65 == A && 91 == Z
        // CREANDO LA LISTA ABCDE...
        for(int i=65; i<69; i++){
            pancakeList.add((char)i);
            pancakeListCopy.add((char)i);
            pancakeListVerify.add((char)i);
        }
        
        System.out.println("Pancake ordenado: "+pancakeList);
        Collections.shuffle(pancakeList);
        System.out.println("Pancake desornado : "+pancakeList);
        System.out.println();
        System.out.println();
        bfs(pancakeList);
    }


    public static void bfs(ArrayList<Character> pancake){
        ArrayList<ArrayList<Character>> adj = new ArrayList<>(); // adjacency list representation
        int n; // number of nodes
        Character s; // source vertex
        LinkedList<Character> q = new LinkedList<Character>();
        boolean used[] = new boolean[n];
        int d[] = new int[n];
        int p[] = new int[n];
        q.push(s);
        used[s] = true;
        p[s] = -1;
        while (!q.isEmpty()) {
            int v = q.pop();
            for (int u : adj.get(v)) {
                if (!used[u]) {
                    used[u] = true;
                    q.push(u);
                    d[u] = d[v] + 1;
                    p[u] = v;
                }
            }
        }
    }
}
