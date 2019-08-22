package com.oracle.cloudnite.service;
import java.util.Comparator;

import com.oracle.cloudnite.model.HerosAndZeros;
 
public class RepsComparator implements Comparator<HerosAndZeros> {
 
    @Override
    public int compare(HerosAndZeros emp1, HerosAndZeros emp2) {
        return emp1.getReps().trim().toLowerCase().compareTo(emp2.getReps().trim().toLowerCase());
    }
}