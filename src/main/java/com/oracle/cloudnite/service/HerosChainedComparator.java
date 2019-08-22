package com.oracle.cloudnite.service;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.oracle.cloudnite.model.HerosAndZeros;
 

public class HerosChainedComparator implements Comparator<HerosAndZeros> {
 
    private List<Comparator<HerosAndZeros>> listComparators;
 
    @SafeVarargs
    public HerosChainedComparator(Comparator<HerosAndZeros>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(HerosAndZeros emp1, HerosAndZeros emp2) {
        for (Comparator<HerosAndZeros> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}