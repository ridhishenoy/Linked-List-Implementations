
import java.util.Scanner;

class CircularLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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

    // Insert at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }

        size++;
    }

    // Insert at end
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        size++;
    }

    // Delete from beginning
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        size--;
    }

    // Delete from end
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;

            while (temp.next != tail) {
                temp = temp.next;
            }

            tail = temp;
            tail.next = head;
        }

        size--;
    }

    // Insert at a specified position
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
        temp.next = newNode;
        size++;
    }

    // Delete from a specified position
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

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    // Display the circular linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // Search for a value and return its index
    public int search(int key) {
        if (isEmpty()) {
            return -1;
        }

        Node temp = head;
        int index = 0;

        do {
            if (temp.data == key) {
                return index;
            }

            temp = temp.next;
            index++;
        } while (temp != head);

        return -1;
    }

    // Reverse the circular linked list
    public void reverse() {
        if (head == null || head == tail) {
            return;
        }

        Node prev = tail;
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        tail = head;
        head = prev;
        tail.next = head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        int choice;

        do {
            System.out.println("\n--- Circular Linked List ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert At Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete At Position");
            System.out.println("7. Display");
            System.out.println("8. Size");
            System.out.println("9. Check Empty");
            System.out.println("10. Search");
            System.out.println("11. Reverse");
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
                    System.out.println("Size: " + list.size());
                    break;

                case 9:
                    System.out.println("Is empty: " + list.isEmpty());
                    break;

                case 10:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    int index = list.search(key);

                    if (index == -1) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Found at index " + index);
                    }
                    break;

                case 11:
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
