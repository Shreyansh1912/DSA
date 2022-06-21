class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, Clone Graph) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
         Map<Node, Node> map = new HashMap<>();
         Queue<Node> queue = new LinkedList<>();
         queue.add(node);
         map.put(node, new Node(node.val, new ArrayList<>()));
         while(!queue.isEmpty()){
              Node h = queue.remove();
            
            for(Node neigh: h.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val, new ArrayList<>()));
                    queue.add(neigh);
                   }
            map.get(h).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);
    }
}
