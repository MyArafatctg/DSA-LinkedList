public class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
    public Node findNode(int data) {
        // Start from the head node
        Node current = head;

        // Traverse the list
        while (current != null) {
            // If the current node's data matches the search value, return the node
            if (current.data == data) {
                return current;
            }
            // Move to the next node
            current = current.next;
        }

        // If no matching node was found, return null
        return null;
    }
    public void insertAfter(int position, int data) {
        // Check if the node is null
        Node currentNode = findNode(position);
        if (currentNode == null) {
            System.out.println("The given node cannot be null");
            return;
        }

        // Create a new node with the given data
        Node newNode = new Node(data);

        // Set the next of the new node to be the next of the current node
        newNode.next = currentNode.next;

        // Set the previous of the new node to be the current node
        newNode.prev = currentNode;

        // If the current node is not the last node, update the previous pointer of the next node
        if (currentNode.next != null) {
            currentNode.next.prev = newNode;
        } else {
            // If the current node is the last node, update the tail to be the new node
            tail = newNode;
        }

        // Update the next of the current node to be the new node
        currentNode.next = newNode;
    }

    //    public void insertBefore(int position, int data){
//        if (head == null){
//            System.out.println("List is empty");
//            return;
//        }
//        Node newNode = new Node(data);
//        if (head.data == position){
//            head.prev = newNode;
//            newNode.next = head;
//            head = newNode;
//        }else {
//
//        }
//    }
    public void delete(int data){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data){
            head = head.next;
            if (head != null){
                head.prev = null;
            }else {
                tail = null;
            }
            return;
        }
        Node current = head;
        while (current != null && current.data != data){
            current = current.next;
        }
        if (current != null){
            if (current.next != null){
                current.next.prev = current.prev.next;
            }else {
                tail = current.prev;
            }
            if (current.prev != null){
                current.prev.next =current.next;
            }
        }else {
            System.out.println(data + " is not in the list");
        }
    }
    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + "<->");
            current = current.next;
        }
        System.out.println("null");
    }
}
