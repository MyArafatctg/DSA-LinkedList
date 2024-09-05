public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
//        list.insertAtEnd(30);
        System.out.println("The currect link list is : ");
        list.display();
        list.insertAfter(20,15);
        list.display();
    }
}