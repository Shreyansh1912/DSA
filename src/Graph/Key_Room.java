class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        
        visited[0] = true;
        for(int i: rooms.get(0)){
            q.add(i);
            visited[i] = true;
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i: rooms.get(temp)){
                if(visited[i] == false)
                    q.add(i);
                    visited[i] = true;
            }
        }
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == false) return false;
        
        }
        return true;
    }
}
