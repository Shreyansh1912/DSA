class MyHashMap {
LinkedList<Entry>[] map; 
    public static int size = 1000000;
    public MyHashMap() {
        map = new  LinkedList[size];  
    }
    
    public void put(int key, int value) {
      int i = key%size; 
      if(map[i] == null){
         map[i] = new LinkedList<Entry>();
         map[i].add(new Entry(key, value));
      }
      else{
          for(Entry entry: map[i]){
              if(entry.key == key){
                  entry.val = value;
                  return;
              }
          }
          map[i].add(new Entry(key, value));
      }
    }
    
    public int get(int key) {
        int index = key%size;
        LinkedList<Entry> entries = map[index]; 
        
        if(entries == null) return -1;
        
        for(Entry i:entries){
            if(i.key == key) return i.val; 
        }
        return -1;
    }
    
    public void remove(int key) {
        int i = key%size;
        Entry toRemove = null;
        if(map[i] == null) return;
        else{
            for(Entry entry:map[i]){
                if(entry.key == key){
                 toRemove  = entry;
                }
            }
            if(toRemove == null) return;
            map[i].remove(toRemove);
        }
    }
}
class Entry{
    public int key;
    public int val;
    
    Entry(int key, int val){
        this.key = key;
        this.val = val; 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
