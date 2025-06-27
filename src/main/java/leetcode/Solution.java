package leetcode;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static String staticProperty = "staticProperty";
    private String property = "property";

    static class NestedClass {
        private static String nestedClassStaticProperty = "nestedClassStaticProperty";
        private String nestedClassProperty = "nestedClassProperty";

        public void test() {
            System.out.println(nestedClassStaticProperty);
            System.out.println(this.nestedClassProperty);
            System.out.println(Solution.staticProperty);
            // System.out.println(Solution.this.property);  // Compile Error
        }
    }

    public static void main(String[] args) {
        new Solution.NestedClass().test();
    }
}
