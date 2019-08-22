package com.oracle.cloudnite.service;
import java.util.Comparator;

import com.oracle.cloudnite.model.HerosAndZeros;
 

public class DealsComparator implements Comparator<HerosAndZeros> {
 
    @Override
    public int compare(HerosAndZeros emp1, HerosAndZeros emp2) {
        return emp2.getNumberOfDeals() - emp1.getNumberOfDeals();
    }
}