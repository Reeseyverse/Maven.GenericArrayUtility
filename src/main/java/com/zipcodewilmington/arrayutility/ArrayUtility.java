package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;

    public ArrayUtility(T[] inputArray) {
        array = inputArray;
    }

    private T[] merge(T[] arrayToMerge){
        Object[] newArr = new Object[arrayToMerge.length + array.length];
        System.arraycopy(arrayToMerge,0,newArr,0,arrayToMerge.length);
        System.arraycopy(array, 0, newArr, arrayToMerge.length, array.length);

        return (T[]) newArr;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        T[] newArr = merge(arrayToMerge);
        return getNumberOfOccurrences(valueToEvaluate, newArr);
    }

    public T[] removeValue(T valueToRemove) {
        int i = 0;
        for(int j = 0; j < array.length; j++ ){
            if(!array[j].equals(valueToRemove)){
                array[i++] = array[j];
            }
        }
        array = Arrays.copyOf(array, i);
        return array;
    }

    private Integer getNumberOfOccurrences(T valueToEvaluate, T[] array){
        int total = 0;
        for(T t : array){
            if(t == valueToEvaluate){
                total += 1;
            }
        }
        return total;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return getNumberOfOccurrences(valueToEvaluate, array);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] newArray = merge(arrayToMerge);
        T mostCommon = newArray[0];
        int maxNum = Integer.MIN_VALUE;

        for(T t : newArray){
            int currentNumOccurrences = getNumberOfOccurrences(t, newArray);
            if(currentNumOccurrences > maxNum){
                mostCommon = t;
                maxNum = currentNumOccurrences;
            }
        }
        return mostCommon;
    }
}