package Heap;

import java.util.PriorityQueue;

/*
 * Array repersentation of BT
 * Complete Binary Tree - The height will always be logN
 * Heap - 
 *       Max Heap - 1. Heap is a cpmplete binary  tree.
 *                  2. Every parent will have the value greater then or equal to all its decendents
 * 
 *      Min Heap -  1. Heap is a complete binary tree.
 *                  2. Every parent will be heaving the value lesser or equal to all its decendents
 *           
 * Insert and Delete -
 *          Insert - time - worst case logN (height of the tree)
 *          Deletion - 1. MaxHeap - Only max element that is only root element is removed or deleted and vise versa
 *               2. time - worst case logN   
 * Heap Sort - when we delete elements fron heap we get the largest element that largest element we can put at the empty place we got at the last of the heap (in array representation) if we keep doing it we will get the array sorted at last which is the concept of heap sort : -
 *  - 1. Create a heap
 *  - 2. Delete all the elements one by one from the heap.
 * Heapify - 
 * Priority Queues
 */

public class Heap {
    public static void main(String[] args) {
        // PriorityQueue<Integer> p = new PriorityQueue<>(); // By default it is a min
        // heap
        PriorityQueue<Integer> p = new PriorityQueue<>((x, y) -> y - x); // To create Max heap
        p.add(2);
        p.add(6);
        p.add(8);
        p.add(3);
        p.add(9);

        System.out.println(p.peek());
        System.out.println(p.poll()); // poll() will remove the uppermost element i.e minimun in min heap and max in
                                      // maxheap
        System.out.println(p.poll());
        System.out.println(p.poll());
        System.out.println(p.remove(2)); // if used without any argument then will work like poll and return the element
                                         // if specified an element then it will return boolean depending on if the
                                         // element was present or not
        System.out.println(p.size()); // will give the size
        System.out.println(p.offer(10)); // will work same as add and return boolen
        System.out.println(p.size()); // will give the size

    }
}
