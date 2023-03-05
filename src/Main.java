import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class Main {
    public  static void main(String args[]){
        breadthFirstTraversal("E");
    }
    static class GraphData {
        public Map<String, LinkedList<String>> adj;
    
        GraphData(HashMap<String, LinkedList<String>> m) { adj = m; }
    
        public Map<String, LinkedList<String>> getAdj() { return adj; }
    }



    static void breadthFirstTraversal(String source){

        HashMap<String,LinkedList<String>> map = new HashMap<String,LinkedList<String>>();

        map.put("A",new LinkedList<String>(){{add("B");add("C");}});
        map.put("B",new LinkedList<String>(){{add("A");add("B");add("D");}});
        map.put("C",new LinkedList<String>(){{add("A");add("E");}});
        map.put("D",new LinkedList<String>(){{add("C");add("E");;add("B");}});
        map.put("E",new LinkedList<String>(){{add("B");add("D");}});

        GraphData gd = new GraphData(map);

        HashSet<String> visted = new HashSet<String>();
        LinkedList<String> q = new LinkedList();
        Stack<String> stack = new Stack<String>();

        stack.push(source);
        q.add(source);
        visted.add(source);
        
        while(!q.isEmpty()){
            String  next = q.poll();
            for(String s: gd.getAdj().get(next)) {
                if (!visted.contains(s)) {
                    System.out.println("visted Vertex "+s);
                    q.add(s);
                    visted.add(s);
                }
            }
        }
    }
}
