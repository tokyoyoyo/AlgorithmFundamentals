package com.jie.quickSort;

public class Test {
    public static void main(String[] args) {
        int[] a ={6,3,7,1,2,5,4,6,4,8,4,5,7,0};

        Quicksort quicksort = new Quicksort(a);

        quicksort.quickSort(0,13);
        System.out.println(quicksort.toString());

    }
}
