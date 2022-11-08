class DLL{
    String url;
    DLL next;
    DLL prev;
    
    DLL(String url){
        this.url = url;
    }
}
class BrowserHistory {
      
    DLL head = null;
    DLL iterator = null;
    
    public BrowserHistory(String homepage) {
        head = new DLL(homepage);
        iterator = head;
    }
    
    public void visit(String url) {
        DLL newNode = new DLL(url);
        iterator.next = newNode;
        newNode.prev = iterator;
        iterator = newNode;
        return;
    }
    
    public String back(int steps) {
        while(iterator.prev != null && steps > 0){
            iterator = iterator.prev;
            steps--;
        }
        return iterator.url;
    }
    
    public String forward(int steps) {
        while(iterator.next != null && steps > 0){
            iterator = iterator.next;
            steps--;
        }
        return iterator.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
