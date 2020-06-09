package org.lj.leetcodedemo.arraydemo;

import java.util.HashMap;
import java.util.Stack;

public class stackdemo {

    /**
     * 20. 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings;
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for(int i=0;i<len;i++){
            char c= s.charAt(i);
            if(mappings.containsKey(c)){
                char top= stack.empty() ? '#':stack.pop();
                if(top!=mappings.get(c)){
                    return  false;
                }

            }else{
                stack.push(c);
            }
        }
        return  stack.isEmpty();
     }

    /**
     * 71. 简化路径
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

    }
}
