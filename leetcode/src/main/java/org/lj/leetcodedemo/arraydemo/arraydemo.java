package org.lj.leetcodedemo.arraydemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 15. 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int numlength = nums.length;
        if(nums == null || numlength < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < numlength ; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){continue;}
            int L=i+1;
            int R=numlength-1;
            while(L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if (sum==0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R && nums[L]==nums[L+1]){
                        L++;
                    }
                    while(L<R && nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }
                else if(sum>0){
                    R--;
                }else if(sum<0){
                    L++;
                }
            }

        }
        return res;
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        int numlength = nums.length;
//        if(nums == null || numlength < 3) return res;
//        Arrays.sort(nums);
//        for(int i=0;i<numlength-2;i++){
//            for(int j=i+1;j<numlength-1;j++){
//                for(int k=j+1;k<numlength;k++){
//
//                    if(0==(nums[i]+nums[j]+nums[k])){
//                        boolean iscontain = false;
//                        for(int m=0;m<res.size();m++){
//                            List<Integer> indexes = res.get(m);
//                            if ((indexes.get(0)==nums[i]) && (indexes.get(1)==nums[j]) &&(indexes.get(2)==nums[k])){
//                                iscontain=true;
//                                break;
//                            }
//                        }
//                        if(!iscontain){
//                            List<Integer> indexes = new ArrayList<>();
//                            indexes.add(nums[i]);
//                            indexes.add(nums[j]);
//                            indexes.add(nums[k]);
//                            res.add(indexes);
//                        }
//
//                    }
//                }
//            }
//        }
//        return res;
    }
    /**
     * 16. 最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int numlength = nums.length;
        Arrays.sort(nums);
        int closestv=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < numlength ; i++) {
            int L=i+1;
            int R=numlength-1;

            while(L<R){
                int cursum = nums[i]+nums[L]+nums[R];
                if(Math.abs(cursum-target)<Math.abs(closestv-target)){
                    closestv=cursum;
                }
                if(cursum>target){
                    R--;
                }else if(cursum<target){
                    L++;
                }else{
                    return closestv;
                }
            }
        }
        return closestv;
    }

    /**
     *18. 四数之和
     * @param nums
     * @param target
     * @return
     */
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//    }

    /**
     *26. 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<1) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }

        }
        return i+1;

    }

    /**
     *27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length<1) return 0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 31. 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {

    }

    /**
     * 33. 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length<1) return -1;
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1){
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length-1;
        int mid = start+(end-start)/2;
        while (start<=end){
            mid = start+(end-start)/2;
            if(nums[mid] == target){
                int lstartindex = mid-1;
                int rendindex= mid+1;
                while (rendindex<nums.length&&(nums[rendindex]==target)){
                    rendindex++;
                }
                while (lstartindex>=0 && nums[lstartindex] ==target){
                    lstartindex--;
                }
                return  new int[]{lstartindex+1,rendindex-1};
            }else if(nums[mid]>target){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }

        return new int[]{-1,-1};
    }

}
