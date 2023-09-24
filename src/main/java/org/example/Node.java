package org.example;

public class Node {
    Integer key, val;
    Node next, prev;

    public Node(int k , int v){
        key=k;
        val=v;
    }

    @Override
    public boolean equals(Object o) { //IMPORTANT
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!key.equals(node.key)) return false;
        return val.equals(node.val);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + val.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" +key +
                "," + val +")";
    }
}
