### 1. 存在重复元素1

[217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)

给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 `true` 。如果数组中每个元素都不相同，则返回 `false` 

```
输入: [1,2,3,1]
输出: true
```

==思路一==直接双重for循环，暴力不多说

==思路二==使用哈希表，如果存在重复元素就返回true

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int temp : nums){
            if(set.contains(temp))  return true;
            set.add(temp);
        }
        return false;
    }
}
```

==思路三==还是使用哈希表，最后只判断哈希表的长度的原数组的长度是否一样，如果不一样就true

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int i:nums)
            res.add(i);
        return res.size()<nums.length?true:false;
    }
}

```

==思路四==预处理，先对数组进行排序，然后再次遍历判断nums[i]与nums[i+1]是否相等

### 2. 存在重复元素2

[219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)

给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

```java
输入: nums = [1,2,3,1], k = 3
输出: true
```

==思路一==暴力法，超时了

==思路二==哈希表，维护一个窗口，使得哈希表的长度不超过k，那么再判断哈希表是否存在num[i]

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            if(set.contains(nums[i]))   return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }    
        }
        return false;
    }
}
```

==思路三==使用hashmap，<nums[i],i>，如果遇到相同的值，那么从hashmap通过nums[i]取出下标i然后判断当前数的下标与hashmap中的i之差是否超过k

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0;i < nums.length;i++){
           if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)  return true;
            map.put(nums[i],i);
       }
       return false;
    }
}
```



`