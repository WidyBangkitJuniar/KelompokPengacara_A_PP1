public class Node {
    private Barang data;
    private Node next;

    public Node(Barang data) {
        this.data = data;
        this.next = null;
    }

    public Barang getData() { return data; }
    public Node getNext() { return next; }
    public void setNext(Node next) { this.next = next; }
}