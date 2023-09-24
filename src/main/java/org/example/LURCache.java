package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This is written by help of the following URL
 *   https://labuladong.gitbook.io/algo-en/ii.-data-structure/lru_algorithm
 */
public class LURCache {
    Map<Integer, Node> map= new HashMap<>();

//    DoubleList linkedList= new DoubleListImpl<>();
    LinkedList<Node> linkedList= new LinkedList<>();

    int capacity;

    public LURCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * If key does not exist
     *   return -1
     * else
     *   1- move the node in the first of list
     *   2- return value
     *
     */
    public int get(int key) {
        System.out.println("#get.list: "+linkedList);
        System.out.println("#get.map: "+map);
        if(!map.containsKey(key))
            return -1;
        else{
            int value = map.get(key).val;
            put(key,value); //bring it to head
            return value;
        }
    }

    /**
     *  if key exist in map ->bring it to first
     *     1- remove it from the tail
     *     2- add it to the first
     *  else
     *     if linked list is full?
     *        remove the last of linked list
     *        remove the last.key from the map
     *     add it to the first of linked list
     *     add the node to map
     */
    public void put(int key, int val) {
        Node node= new Node(key,val);
        System.out.println("------>>put: "+node);
        // if exist -> bring it to fist, How? -> 1- remove it, bring it to the first
        if(map.containsKey(key)){
            // Delete the old node, add to the head
            //bring it to first
            //1- remove the node from the linked List
            linkedList.remove(node);
            //2- bring it to the first
            linkedList.addFirst(node);
        }
        else
        {
            //Why we need to store key-value pair in the linked list, instead of value only?
            //If linked list is full -> 1-remove the last from the linked list 2- remove the last from map
            if(linkedList.size()==capacity)
            {
                //remove the last from the list
                Node last= linkedList.removeLast();
                //remove the last from map
                map.remove(last.val);
            }
            // put it in map
            map.put(node.key, node);
            // add int in the first of list
            linkedList.addFirst(node);
        }
        System.out.println("#put.list: "+linkedList);
        System.out.println("#put.map: "+map);
    }
}
