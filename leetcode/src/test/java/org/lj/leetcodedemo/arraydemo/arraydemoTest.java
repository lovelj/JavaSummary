package org.lj.leetcodedemo.arraydemo;

import org.junit.Test;

import static org.junit.Assert.*;

public class arraydemoTest {

    @Test
    public void maxArea() {
        int input[] = {1,8,6,2,5,4,8,3,7};
        arraydemo demo = new arraydemo();
        demo.maxArea(input);

    }

    @Test
    public void combinationSum2(){
        int input[] = {10,1,2,7,6,1,5};
        arraydemo demo = new arraydemo();
        demo.combinationSum2(input,8);
    }
}