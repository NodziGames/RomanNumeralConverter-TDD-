package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanConverter {

    private Map<Character, Integer> values;

    public RomanConverter() {
        values = new HashMap<>();

        //Add corresponding values
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }

    public int convert(String str) {

        if (str == "" || !str.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw (new IllegalArgumentException("String is poorly formatted"));
        }

        str = str.toUpperCase();

        int result = 0;
        int i = 0;

        while (i < str.length()) {
            if (i < str.length() - 1) {
                if (values.get(str.charAt(i)) < values.get(str.charAt(i + 1))) {
                    result += values.get(str.charAt(i + 1)) - values.get(str.charAt(i));
                    i += 2;
                } else {
                    result += values.get(str.charAt(i));
                    i++;
                }
            }

            if (i == str.length() - 1) {
                result += values.get(str.charAt(i));
                i++;
            }
        }

        return result;
    }
}