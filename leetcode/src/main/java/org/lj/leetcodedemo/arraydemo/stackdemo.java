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
        Stack<String> stack =new Stack<>();
        String[] str = path.split("/");

        for(String s:str){
            if(s.equals("..")){
                if ( !stack.isEmpty() ) {
                    stack.pop();
                }
            }
            else if ( !s.equals("") && !s.equals(".") ) {
                stack.push(s);
            }
        }

        if ( stack.isEmpty() ) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append( "/" + stack.get(i) );
        }
        return ans.toString();

    }

    /**
     * 496. 下一个更大元素 I //todo:
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack < Integer > stack = new Stack < > ();
        HashMap < Integer, Integer > map = new HashMap < > ();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


}
