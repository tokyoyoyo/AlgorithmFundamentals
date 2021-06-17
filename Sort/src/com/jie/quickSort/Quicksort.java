package com.jie.quickSort;

import java.util.Arrays;

public class Quicksort {

    private int[] array;



    public Quicksort(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Quicksort{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

     public void quickSort(int low, int high) {
        //递归的调用position方法完成排序

        if(low<high){
            int pos = position(low,high);
            quickSort( low,pos-1);
            quickSort(pos+1,high);
        }
    }

    private int position( int low ,int high ){
        //将枢纽值放在应当的位置，并且将大于枢纽值的的放右边，小于的放左边
        int temp = array[low];
        int left = low;
        int right = high;

        while(left < right){

            while (left < right && array[right] >= temp){
                right--;
            }

            if(left<right){
                array[left] = array[right];
            }

            while( left < right && array[left] <= temp){
                left++;
            }
            if(left<right){
                array[right] = array[left];
            }

        }

        array[left] = temp;

        return left;
    }
}
