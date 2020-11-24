package Sort;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class offer51 {
    public int reversePairs(int[] nums) {
        if(nums.length < 2) return 0;
        int[] temp = new int[nums.length];
        return merge(nums,0,nums.length - 1,temp);
    }
    public int merge(int[] nums, int left, int right,int[] temp){
        //递归终止条件
        if(left == right)   return 0;
        int mid = (left + right) >> 1;
        //分
        int leftCount = merge(nums, left, mid, temp);
        int rightCount = merge(nums, mid + 1, right, temp);
        //合
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }

        int crossCount = mergeAndCount(nums, left, mid, right, temp);
        return leftCount + rightCount + crossCount;
    }
    public int mergeAndCount(int nums[], int left, int mid, int right, int[] temp){
        if(left == right)   return 0;
        int low = left, high = mid + 1, count = 0, k = 0;
        while(low <= mid || high <= right){
            //第一个数组走到了终点
            if(low == mid + 1){
                temp[k++] = nums[high++];
            }else if(high == right + 1){  //第二个数组走到了终点
                temp[k++] = nums[low++];
            }else if(nums[low] <= nums[high]){
                temp[k++] = nums[low++];
            }else{
                count += (high - mid);
                temp[k++] = nums[high++];

            }
        }
        for(int i = 0;i < k;i++){
            nums[left + i] = temp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new offer51().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
