package com.interview;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Combination {
    public List<String> letterCombinations(Integer[] digitsArr) {

        String digits = StringUtils.join(digitsArr);
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0)
            return list;

        //A mapping of digit to letters (just like on the telephone buttons)
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        //Rule out entering Numbers that begin with a 0 or 1
        int idx = 0;
        while(idx < digits.length() && (digits.charAt(idx) - 48 == 0 || digits.charAt(idx) - 48 == 1)){
            idx++;
        }
        if (idx == digits.length()) {
            return list;
        }

        for(int i = idx; i < digits.length(); i++){
            //If the digit is 0 or 1, skip it
            if (digits.charAt(i) - 48 == 0 || digits.charAt(i) - 48 == 1){
                continue;
            }
            //Put the letters corresponding to the first number into the new list
            if(i == idx){
                list = Arrays.asList(map.get(digits.charAt(i) - 48).split(""));
                list = new ArrayList<String>(list);
            }else{
                /*
                * Combine the element in the list, with the letters corresponding to the current number,
                * and replace the original element with the combined result.
                * input:{2, 3}, result:{a,b,c}→{ad,ae,af,b,c}→...→{ad,ae,af,bd,be,bf,cd,ce,cf}
                * */
                String str = map.get(digits.charAt(i) - 48);
                int len = list.size();
                for(int k = 0; k < len; k++){
                    String s = list.get(0);
                    list.remove(0);
                    for(int m = 0; m < str.length(); m++){
                        list.add(s + str.substring(m,m+1));
                    }
                }
            }
        }
        return list;
    }
}
