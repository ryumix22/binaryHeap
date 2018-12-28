package BinaryHeapTest;

import BinaryHeap.Heap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Test2 {

    @Test
    public void insert() {
        Heap<Integer> tmp = new Heap<Integer>();
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(6);
        tmp.insert(1);
        tmp.insert(4);
        tmp.buildHeap();
        assertEquals(("1 2 6 3 4 "), tmp.toString());
        Heap<Integer> h = new Heap<>();
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.insert(4);
        h.insert(5);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(9);
        h.insert(4);
        h.insert(1);
        h.insert(4);
        h.insert(2);
        h.insert(3);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.buildHeap();
        assertEquals(("1 1 1 1 2 3 2 3 2 6 9 4 4 5 4 6 3 6 3 "),
                h.toString());

    }
    @Test
    public void maxMin() {
        Heap<Integer> tmp = new Heap<Integer>();
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(6);
        tmp.insert(1);
        tmp.insert(4);
        tmp.buildHeap();
        int min = tmp.watchMin();
        assertEquals(1, min);
        Heap<Integer> h = new Heap<>();
        h.insert(0);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.insert(4);
        h.insert(5);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(9);
        h.insert(4);
        h.insert(1);
        h.insert(4);
        h.insert(2);
        h.insert(3);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.buildHeap();
        int min2 = h.watchMin();
        assertEquals(0, min2);
    }

    @Test
    public void delete() {
        Heap<Integer> tmp = new Heap<Integer>();
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(6);
        tmp.insert(1);
        tmp.insert(4);
        tmp.buildHeap();
        tmp.deleteMin();
        assertEquals("2 3 6 4 ", tmp.toString());

        Heap<Integer> h = new Heap<>();
        h.insert(0);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.insert(4);
        h.insert(5);
        h.insert(2);
        h.insert(3);
        h.insert(6);
        h.insert(9);
        h.insert(4);
        h.insert(1);
        h.insert(4);
        h.insert(2);
        h.insert(3);
        h.insert(3);
        h.insert(6);
        h.insert(1);
        h.buildHeap();
        h.deleteMin();
        assertEquals("1 1 1 2 2 3 2 3 3 6 9 4 4 5 4 6 3 6 ", h.toString());
    }

}