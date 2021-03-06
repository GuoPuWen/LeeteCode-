
[20.有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 注意空字符串可被认为是有效字符串。

**示例 1:**

```
输入: "()"
输出: true
```

**示例 2:**

```
输入: "()[]{}"
输出: true

输入: "([)]"
输出: false
```

这个题目很明显需要使用栈，这里使用双端队列来模拟栈

```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char temp : s.toCharArray()){
            if(temp == '(') stack.push(')');
            else if(temp == '[')    stack.push(']');
            else if(temp == '{') stack.push('}');
            else if(stack.isEmpty() || temp != stack.poll()) return false; 
        } 
        return stack.isEmpty();
    }
}
```

