package linklist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_copy_linklist_with_random {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node p = head;

        // save node into hash map
        while(p != null) {
            Node cpNode = new Node(p.val);
            map.put(p, cpNode);
            p = p.next;
        }

        // add binding relationship for hash map
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
