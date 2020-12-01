### 6. 两个数组的交集1

[349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

给定两个数组，编写一个函数来计算它们的交集。

 ```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
 ```

==解法一==：使用set和map相结合，将nums1的数存在hashmap中<值，下标>，遍历num2，判断在hashmap中是否存在对于的key，如果不存在将结果保存在set中（去重）

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int temp1 : nums2){
            if(map.containsKey(temp1) ){
                temp.add(temp1);
            }
        }
        int[] res = new int[temp.size()];
        int i = 0;
        for(int num : temp){
            res[i++] = num;
        }
        return res;
    }
}
```

==解法二==：排序  + 双指针，思路比较明确，先对两个数组进行排序，然后两个指针遍历两个数组，如果数值相等就加入到num数组中，但是题目要求是不能有重复值的，所以可以记录num中上一个pre的值，判断当前待加入的值是否与上一个相等，也可以在将该数组加入到set中去重

### 7. 两个数组的交集2

[350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)

给定两个数组，编写一个函数来计算它们的交集。

```
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
```

* 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
* 我们可以不考虑输出结果的顺序。

这个题目与上面一题有点区别，就是需要输出重复值，但是总体思路和上题一样

==解法一==，使用map，但是map中存的值为<nums[i]，元素重复的次数>，这里要记住==map中的getOrDefault(key,obj)，意思是如果当前map中有key对应的键那么取出该值作为返回值，如果没有对应的键值就使用obj作为返回值==，接着遍历nums2，依次判断在map中是否有键值对，如果在map中存在nums2[i]，那么map中的元素重复的次数就要减1，如果元素重复的次数为0，那么直接可以在map中移除该<k,v>

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        //将nums1加入hash表
        for(int i = 0;i < nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
        }
        int[] res = new int[nums1.length];
        int k = 0;
        //遍历nums2
        for(int tempnum : nums2){
            int count = 0;
            if(map.get(tempnum) != null){
                count = map.get(tempnum);
            }
            if(count > 0){
                res[k++] = tempnum;
                count--;
                if(count > 0){
                    map.put(tempnum,count);
                }else{
                    map.remove(tempnum);
                }
            }
        }
        return Arrays.copyOfRange(res,0,k);
    }
}
```

==解法二==排序和双指针，那么这题如果使用这种思路相比上题则是降低难度，因为这里不需要去重了

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
        int[] res = new int[Math.max(nums1.length,nums2.length)];
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] res2 = new int[k];
        for(int p = 0;p < k;p++){
            res2[p] = res[p];
        }
        return res2;
    }
}
```