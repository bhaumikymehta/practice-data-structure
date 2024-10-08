package prep2024.meta.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node start = head;
        Map<Node, Node> map = new HashMap<>();

        while (start != null) {
            map.put(start, new Node(start.val));
            start = start.next; 
        }
        System.out.println(map);
        start = head;
        while (start != null) {
            map.get(start).next = map.get(start.next);
            map.get(start).random = map.get(start.random);
            start = start.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        Node copiedHead = solution.copyRandomList(head);
        System.out.println("Original List:");
        printLinkedList(head);
        System.out.println("Copied List:");
        printLinkedList(copiedHead);
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            if (current.random != null) {
                System.out.print("Random: " + current.random.val + " ");
            }
            current = current.next;
        }
        System.out.println("null");
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
