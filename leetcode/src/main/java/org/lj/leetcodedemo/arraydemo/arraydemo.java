package org.lj.leetcodedemo.arraydemo;

public class arraydemo {
    /**
     * 11. 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int leftindex =0;
        int rightindex = height.length-1;

        int leftvalue =  height[leftindex];
        int rightvalue = height[rightindex];
        int maxarea = (rightindex-leftindex)*(Math.min(rightvalue,leftvalue));
        while(rightindex>leftindex){

            if(height[leftindex]<height[rightindex]){
                leftindex++;
            }else{
                rightindex--;
            }
            leftvalue =  height[leftindex];
            rightvalue = height[rightindex];
            int curarea=(rightindex-leftindex)*(Math.min(rightvalue,leftvalue));
            if(curarea>maxarea){
                maxarea=curarea;
            }

        }
        return maxarea;
    }
}
