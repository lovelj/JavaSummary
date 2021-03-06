package org.lj.leetcodedemo.arraydemo;

import java.util.*;

/**
 * 数组
 */
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

    /**
     *35. 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length<1) return 0;
        int start = 0;
        int end = nums.length-1;
        int mid =0;
        while(start<=end){
            mid = start +(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }

        }
        return start;
    }


    /**
     * 39. 组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs2(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }


    private void dfs2(int[] candidates,int len,int dis,int begin,Deque<Integer> path,List<List<Integer>> res){
        if(dis==0){
            res.add(new ArrayList<>(path));
        }
        for(int i=begin;i<len;i++){
            // 在数组有序的前提下，剪枝
            if (dis - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);
            dfs2(candidates, len, dis-candidates[i],i,path, res);
            path.removeLast();
        }

    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {

            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    /**
     * 40. 组合总和 II
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);
        dfs22(candidates,len,0,target, new ArrayDeque<>(),res);
        return res;
    }

    private void dfs22(int[] candidates,int len,int start,int diff,Deque<Integer> paths,List<List<Integer>> res){
        if(diff==0){
            res.add(new ArrayList<>(paths));
            return;
        }

        for(int i=start;i<len;i++){
            if(candidates[i]>diff){
                break;
            }

            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            paths.addLast(candidates[i]);
            dfs22(candidates, len, i+1,diff - candidates[i], paths, res);
            paths.removeLast();
        }
    }

    /**
     * 48. 旋转图像
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        for(int i=0;i<len/2 +len %2 ;i++){
            for(int j=0;j<len/2;j++){
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = len - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = len - 1 - x;
                }
            }
        }
    }

    /**
     * 53. 最大子序和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len<1){
            return 0;
        }
        int[] dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]>=0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
        }
        int res =dp[0];
        for(int i=1;i<len;i++){
            res=Math.max(res,dp[i]);
        }
        return  res;

//        int ans = nums[0];
//        int sum = 0;
//        for(int num: nums) {
//            if(sum > 0) {
//                sum += num;
//            } else {
//                sum = num;
//            }
//            ans = Math.max(ans, sum);
//        }
//        return ans;
    }

    /**
     * 54. 螺旋矩阵 todo://
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    /**
     * 55. 跳跃游戏
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length<1){
            return false;
        }
        int maxcanjump=0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxcanjump){
                maxcanjump=Math.max(maxcanjump,i+nums[i]);
            }
            if (maxcanjump >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }

    /**
     *56. 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparing(item -> item[0]));

        int index=0;
        for(int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            int[] point =intervals[index];
            if (interval[0] > point[1]) {
                intervals[++index] = interval;
            } else {
                intervals[index][1] = Math.max(point[1], interval[1]);
            }
        }
        return Arrays.copyOfRange(intervals, 0, index + 1);
    }

    /**
     * 62. 不同路径
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     *63. 不同路径 II
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < col; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[row - 1][col - 1];
    }

    /**
     * 64. 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0]= grid[0][0];

        for (int i = 1; i < col; i++) dp[0][i] = grid[0][i]+dp[0][i-1];
        for (int i = 1; i < row; i++) dp[i][0] = grid[i][0]+dp[i-1][0];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])+grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

    /**
<<<<<<< HEAD
     * 74. 搜索二维矩阵
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row<1){
           return false;
       }

       int col = matrix[0].length;
        if(col<1){
            return false;
        }
       int targetrow=-1;
       for(int i=0;i<row;i++){
           if(matrix[i][col-1]>=target && matrix[i][0]<=target){
               targetrow=i;
               break;
           }
       }
       if(targetrow<0){
           return false;
       }

       for(int i=0;i<col;i++){
           if(matrix[targetrow][i]==target){
               return true;
           }
       }
       return false;
    }

    /**
     * 66. 加一
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        int digsn[]=new int[len+1];
        digsn[0]=1;
        return digsn;

//        int n = digits.length;
//        for(int i = n -1;i>=0;i--){
//            if(digits[i] == 9){
//                digits[i] = 0;
//            }else{
//                digits[i]++;
//                return digits;
//            }
//        }
//        int[] a = new int [n+1];
//        a[0]=1;
//        return a;
    }

    public void setZeroes(int[][] matrix) {
        int MODIFIED = -1000000;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0) {
                    // We modify the corresponding rows and column elements in place.
                    // Note, we only change the non zeroes to MODIFIED
                    for (int k = 0; k < C; k++) {
                        if (matrix[r][k] != 0) {
                            matrix[r][k] = MODIFIED;
                        }
                    }
                    for (int k = 0; k < R; k++) {
                        if (matrix[k][c] != 0) {
                            matrix[k][c] = MODIFIED;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // Make a second pass and change all MODIFIED elements to 0 """
                if (matrix[r][c] == MODIFIED) {
                    matrix[r][c] = 0;
                }
            }
        }
    }



}
