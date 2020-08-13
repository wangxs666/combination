package com.interview;

import org.junit.Test;

import java.util.List;

public class CombinationTest {
    @Test
    public void test1() {
        Combination combination = new Combination();
//        Integer[] arr = {2, 3};
//        Integer[] arr = {0, 1};
//        Integer[] arr = {0, 3};
        Integer[] arr = {12, 13};
//        Integer[] arr = {0, 1, 2, 0, 3};
//        Integer[] arr = {23, 45}; //implement Stage 2:converting the digits from 0 to 99 into letters

        List<String> list = combination.letterCombinations(arr);
        System.out.println(list);
    }

}
