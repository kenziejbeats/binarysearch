/**
 * Author: McKenzie Jean-Baptiste (2512186) and Carson Frankovich (COE Tutor) (2599340)
 * Project: Binary Search
 *
 * This project implements a recursive algorithm in order to find an index representing the location of a given key.
 **/
import java.util.ArrayList;

class Homework1 {
    /*
    parse command line arguments and set a key and array value to implement the recursive function.
    @param args command line arguments
     */
    public static void main(String[] args) {

        int key = Integer.parseInt(args[0]);

        int size = args.length - 1;
        int my_array[] = new int[size];

        for (int i = 0; i < size; i++) {
            my_array[i] = Integer.parseInt(args[i+1]); // fill in "my_array" with values from "args"
        }

        System.out.println(rank(key, my_array));
    }
    /*
    calls the recursive algorithm utilizing method overloading making it simple for calls by only requiring the key and array
    @param key  value to search for in 'a'
    @param a    array to search in (assuming it is sorted)
    returns a call to the recursive algorithm with 0 and the array length as initial parameters
     */
    // This method was sourced from "Algorithms Fourth Edition" by Robert Sedgewick and Kevin Wayne (page 25)
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    /*
    recursive algorithm to return the index of an array given the value (key) to search for
    @param key  value to search for in array (target value)
    @param a    the array to search in (assuming it is sorted)
    @param lo   the first index to search from
    @param hi   the last index to search to
    returns     -1 if lo is less than than hi, otherwise a call to itself shortening the bounds of a for next iteration
     */
    // This method was sourced from "Algorithms Fourth Edition" by Robert Sedgewick and Kevin Wayne (page 25)
    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1; // not found
        }

        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1); // serach left
        }
        else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi); // search right
        }
        else {
            return mid; // element at mid index is target value (key)
        }
    }
}