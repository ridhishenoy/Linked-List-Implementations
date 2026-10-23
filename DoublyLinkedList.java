
import java.util.Scanner;

class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    public void addBtw(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addFirst(data);
            return;
        }

        if (position == size) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        size++;
    }

    public void removeBtw(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            removeFirst();
            return;
        }

        if (position == size - 1) {
            removeLast();
            return;
        }

        Node temp = head;

        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        Node temp = head;

        System.out.print("null <- ");

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println(" -> null");
    }

    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        Node temp = tail;

        System.out.print("null <- ");

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println(" -> null");
    }

    public int search(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    public void reverse() {
        Node current = head;
        Node temp;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        int choice;

        do {
            System.out.println("\n--- Doubly Linked List ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert At Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete At Position");
            System.out.println("7. Display");
            System.out.println("8. Display Reverse");
            System.out.println("9. Size");
            System.out.println("10. Check Empty");
            System.out.println("11. Search");
            System.out.println("12. Reverse");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.addFirst(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.addLast(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value and position: ");
                    int value = sc.nextInt();
                    int position = sc.nextInt();
                    list.addBtw(value, position);
                    break;

                case 4:
                    list.removeFirst();
                    break;

                case 5:
                    list.removeLast();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    list.removeBtw(sc.nextInt());
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    list.displayReverse();
                    break;

                case 9:
                    System.out.println("Size: " + list.size());
                    break;

                case 10:
                    System.out.println("Is empty: " + list.isEmpty());
                    break;

                case 11:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    int index = list.search(key);

                    if (index == -1) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Found at index " + index);
                    }
                    break;

                case 12:
                    list.reverse();
                    System.out.println("List reversed");
                    break;

                case 0:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
