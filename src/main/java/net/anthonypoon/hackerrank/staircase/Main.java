/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.anthonypoon.hackerrank.staircase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ypoon
 */
public class Main {

    private static Integer tSteps = 0;
    private static int[] subset = {1, 2, 3};
    private static List<List<Integer>> validCombination = new ArrayList();

    public static void main(String args[]) {
        tSteps = Integer.valueOf(args[0]);
        List<Integer> combo = new ArrayList();
        do {
            increment(combo);
            //System.out.println(combo);
            if (getTotal(combo) == tSteps) {
                validCombination.add(new ArrayList(combo));
            }
        } while (combo.size() < tSteps);
        
        for (List<Integer> c : validCombination) {
            System.out.println(c + " is valid. Total = " + getTotal(combo));
        }
        System.out.println("Valid Combo " + validCombination.size());
    }
    
    private static void increment(List<Integer> origin) {
        if (origin.isEmpty()) {
            origin.add(1);
        } else {
            int digit = origin.size() - 1;
            while (digit >= 0 && origin.get(digit) == 3 ) {
                digit = digit - 1;
            }
            if (digit >= 0) {
                for (int x = origin.size() - 1; x > digit; x --) {
                    origin.set(x, 1);
                }
                origin.set(digit, origin.get(digit) + 1);
            } else {
                for (int x = 0; x < origin.size(); x ++) {
                    origin.set(x, 1);
                }
                origin.add(1);
            }
        }
    }
    
    private static int getTotal(List<Integer> combo) {
        int sum = 0;
        for (Integer x : combo) {
            sum = x + sum;
        }
        return sum;
    }
}
