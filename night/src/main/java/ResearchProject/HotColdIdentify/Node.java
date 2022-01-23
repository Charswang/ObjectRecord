package ResearchProject.HotColdIdentify;

public class Node {
    public Node next;
    public Node prev;
    public int key,counter,recency;
    public Node(int key,int counter,int recency){
        this.key = key;
        this.counter = counter;
        this.recency = recency;
    }
}
