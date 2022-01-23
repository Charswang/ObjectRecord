package ResearchProject.HotColdIdentify;

public class DoubleLinkList {
    public Node head;
    public Node tail;
    public int size;

    public DoubleLinkList() {
        head = new Node(0, 0, 0);
        tail = new Node(0, 0, 0);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * 查找相应节点
     *
     * @param key
     * @return
     */
    public Node getNode(int key) {
        Node p = head.next;
        while (p.key != key) {
            p = p.next;
        }
        return p;
    }

    /**
     * 在链表头部添加节点
     *
     * @param node
     */
    public void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    /**
     * 删除链表中指定节点，该节点一定存在
     *
     * @param node
     */
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /**
     * 删除链表中最后一个节点，并返回该节点，时间o(1)
     *
     * @return
     */
    public Node removeLast() {
        if (head.next == tail) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int size() {
        return size;
    }
}
