public class Node {
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}