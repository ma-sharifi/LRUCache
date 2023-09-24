package org.example;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public interface DoubleList extends Deque<Node> {
    // Add x at the head, time complexity O(1)
    public void addFirst(Node x);

    // Delete node x in the linked list (x is guaranteed to exist)
    // Given a node in a doubly linked list, time complexity O(1)
    public boolean remove(Object o);

    // Delete and return the last node in the linked list, time complexity O(1)
    public Node removeLast();

    // Return the length of the linked list, time complexity O(1)
    public int size();

}
