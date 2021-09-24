/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.ArraysGenerator;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();
        for(int i = from + 1; i<to; i++){
            int j = i -1;
            while(j >= from && helper.compare(xs[j],xs[j+1]) > 0) {
                helper.swap(xs,j,j+1);
                j--;
            }
        }
        // TO BE IMPLEMENTED
    }

    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
    public static <Y extends Comparable<Y>> void mutatingInsertionSort(Y[] ys) {
        new InsertionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Insertion sort";

    public static void main(String[] args) {
        /*
        ordered
        * */
        InsertionSort is = new InsertionSort();
        ArraysGenerator AG = new ArraysGenerator();
        long starttime;
        long time;
        for(int i = 1; i <= 128; i = i*2) {
            Integer[] A = AG.generateOrderedArray(i * 1000);
            starttime = System.nanoTime();
            is.sort(A, 0, A.length);
            time = System.nanoTime() - starttime;
            System.out.println( time);
            /////////////////////////////////////////////////////////////////
        }
        /*
        reverse-ordered
        * */
        for(int i = 1; i <= 128; i = i*2) {
            Integer[] B = AG.generateInversedArray(i * 1000);
            starttime = System.nanoTime();
            is.sort(B, 0, B.length);
            time = System.nanoTime() - starttime;
            System.out.println(time);
        }
            /////////////////////////////////////////////////////////////////
        /*
        random
        * */
        for(int i = 1; i <= 128; i = i*2) {
            Integer[] C = AG.generateRandomArray(i * 1000, 1, i * 100);
            starttime = System.nanoTime();
            is.sort(C, 0, C.length);
            time = System.nanoTime() - starttime;
            System.out.println(time );
        }
            /////////////////////////////////////////////
         /*
        partially-ordered
        * */
        for(int i = 1; i <= 128; i = i*2) {
            Integer[] D = AG.generateNearlyOrderedArray(i * 1000, i * 100);
            starttime = System.nanoTime();
            is.sort(D, 0, D.length);
            time = System.nanoTime() - starttime;
            System.out.println( time );
        }

    }
}
