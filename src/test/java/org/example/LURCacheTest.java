package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LURCacheTest {

    @Test
    void get() {
        LURCache cache= new LURCache(2);
        cache.put(1,1);
        // cache = [(1, 1)]
        cache.put(2,2);
        // cache = [(2, 2), (1, 1)]
        cache.get(1); // return 1
        // cache = [(1, 1), (2, 2)]
        // Remarks: because key 1 is visited, move it to the head
        // Return the value, 1, associated with key 1
        cache.put(3, 3);
        // cache = [(3, 3), (1, 1)]
        // Remarks: the memory capacity is full
        // We need to remove some contents to free up space
        // Removal will prioritize longest unused data, which is at the tail
        // Afterwards, insert the new data at the head
        Assertions.assertEquals(cache.get(2),-1);   // return -1 (not found)
        // cache = [(3, 3), (1, 1)]
        // Remarks: key 2 does not exist in the cache
        cache.put(1, 4);
        // cache = [(1, 4), (3, 3)]
        // Remarks: key 1 exists
        // Overwrite with new value 4
        // Don't forget to bring the key to the head
    }

    @Test
    void put() {
    }
}