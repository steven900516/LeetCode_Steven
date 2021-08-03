# 1.两数相加（2）

## 数据结构

涉及数据结构： 单链表

结构如下所示

[![WplRr6.png](https://z3.ax1x.com/2021/07/10/WplRr6.png)](https://imgtu.com/i/WplRr6)

注意：是逻辑结构，在内存中节点不是一个接一个的。



## 题解

**思路**

* 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010。
* 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
* 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11





***小技巧***：对于链表问题，返回结果为头结点时，通常需要**先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head**。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}

链接：https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/

```





[<img src="https://z3.ax1x.com/2021/07/11/WCR7qI.png" alt="WCR7qI.png" style="zoom: 50%;" />](https://imgtu.com/i/WCR7qI)--->

[<img src="https://z3.ax1x.com/2021/07/11/WCW8JO.png" alt="WCW8JO.png" style="zoom:50%;" />](https://imgtu.com/i/WCW8JO)--->

[<img src="https://z3.ax1x.com/2021/07/11/WCWUOA.png" alt="WCWUOA.png" style="zoom:50%;" />](https://imgtu.com/i/WCWUOA)





---





# 2.无重复字符的最长字串（3）

## 数据结构

涉及数据结构： Map

**继承关系**如下：

[![WC2DBt.md.png](https://z3.ax1x.com/2021/07/11/WC2DBt.md.png)](https://imgtu.com/i/WC2DBt)





- Map中的集合，元素是成对存在的(理解为夫妻)。每个元素由键与值两部分组成，通过键可以找对所对应的值。

* Map中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。



Map有多个子类，这里我们主要讲解常用*的HashMap集合*、*LinkedHashMap集合*

* **HashMap<K,V>**：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。

* **LinkedHashMap<K,V>**：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。



**Map集合的功能概述**

* a:添加功能
  V put(K key,V value):添加元素。这个其实还有另一个功能?替换
  如果键是第一次存储，就直接存储元素，返回null
  如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
* b:删除功能
  void clear():移除所有的键值对元素
  V remove(Object key)：根据键删除键值对元素，并把值返回
* c:判断功能
  boolean containsKey(Object key)：判断集合是否包含指定的键
  boolean containsValue(Object value):判断集合是否包含指定的值
  boolean isEmpty()：判断集合是否为空
* d:获取功能
  Set<Map.Entry<K,V>> entrySet(): 返回一个键值对的Set集合
  V get(Object key):根据键获取值
  Set keySet():获取集合中所有键的集合
  Collection values():获取集合中所有值的集合
* e:长度功能
  int size()：返回集合中的键值对的对数



## 题解

**思路**
标签：滑动窗口

* 暴力解法时间复杂度较高，会达到 O(n^2)，故而采取滑动窗口的方法降低时间复杂度。
* 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复。
* 我们定义不重复子串的开始位置为 start，结束位置为 end。
* 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符。
* 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
  时间复杂度：O(n)



```java
public int solution(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();  
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end); 
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
}
```





[<img src="https://z3.ax1x.com/2021/07/11/WCHQw4.png" alt="WCHQw4.png" style="zoom:50%;" />](https://imgtu.com/i/WCHQw4)--->



[<img src="https://z3.ax1x.com/2021/07/12/WCHN6K.png" alt="WCHN6K.png" style="zoom:50%;" />](https://imgtu.com/i/WCHN6K)--->

[<img src="https://z3.ax1x.com/2021/07/12/WCHsfI.png" alt="WCHsfI.png" style="zoom:50%;" />](https://imgtu.com/i/WCHsfI)--->

[<img src="https://z3.ax1x.com/2021/07/12/WCb8Hg.png" alt="WCb8Hg.png" style="zoom:50%;" />](https://imgtu.com/i/WCb8Hg)--->





---

# 3.两数之和（1）

## 数据结构

涉及数据结构：数组和哈希表



### 特点

* 哈希查找的**时间复杂度**为 **O(1)**，所以可以**利用哈希容器降低时间复杂度**

​       哈希算法会根据你要存入的数据,先通过该算法,计算出一个地址值,这个地址值就是你需要存入到集合当中的数据的位置,而不会像数组那样一个个的进行挨个存    储,挨个遍历一遍后面有空位就存这种情况了,而你查找的时候,也是根据这个哈希算法来的,将你的要查找的数据进行计算,得出一个地址,这个地址会印射到集合当中的位置,这样就能够直接到这个位置上去找了,而不需要像数组那样,一个个遍历,一个个对比去寻找,这样自然增加了速度,提高了效率了。

​	**通过给定的关键字的值直接访问到具体对应的值的一个数据结构。也就是说，把关键字映射到一个表中的位置来直接访问记录，以加快访问速度。**





* 哈希表hashtable(key，value) 的做法其实很简单，就是把Key通过一个固定的算法函数既所谓的哈希函数转换成一个整型数字，然后就将该数字对数组长度进行取余，取余结果就当作数组的下标，将value存储在以该数字为下标的数组空间里。







## 题解

### 1.暴力解法

```java
public int[] solution(int[] nums, int target){
        int index = 0;
        int[] tar = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <  nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    tar[index] = i;
                    tar[index + 1] = j;
                    index += 2;
                }
            }
        }
        return tar;
    }
```





### 2. 哈希映射

**思路**

* 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
* 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止



```java
public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/

```



[<img src="https://z3.ax1x.com/2021/07/12/WFchcQ.png" alt="WFchcQ.png" style="zoom:50%;" />](https://imgtu.com/i/WFchcQ)--->

[<img src="https://z3.ax1x.com/2021/07/12/WFgEge.png" alt="WFgEge.png" style="zoom:50%;" />](https://imgtu.com/i/WFgEge)--->

[<img src="https://z3.ax1x.com/2021/07/12/WFgVjH.png" alt="WFgVjH.png" style="zoom:50%;" />](https://imgtu.com/i/WFgVjH)--->

[<img src="https://z3.ax1x.com/2021/07/12/WFgnHI.png" alt="WFgnHI.png" style="zoom:50%;" />](https://imgtu.com/i/WFgnHI)









# 4.最长回文子串（5）

## 数据结构

数组

## 题解

 ### 动态规划

**思路**

*重点*

*对于一个子串而言，如果它是回文串，并且长度大于2，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串“ababa”，如果我们已经知道“bab”是回文串，那么“ababa”一定是回文串，这是因为它的首尾两个字母都是“a”。*

[![WeEgOA.png](https://z3.ax1x.com/2021/07/14/WeEgOA.png)](https://imgtu.com/i/WeEgOA)



* 根据这样的思路，我们就可以用动态规划的方法解决本题。我们用P(i,ij)表示字符串s的第i到j个字母组成的串(下文表示成s[i:j])是否为回文串:

[![WeVFmR.png](https://z3.ax1x.com/2021/07/14/WeVFmR.png)](https://imgtu.com/i/WeVFmR)



可以得出该题的状态方程如下

[![WeJrfH.png](https://z3.ax1x.com/2021/07/14/WeJrfH.png)](https://imgtu.com/i/WeJrfH)

[![WenpU1.md.png](https://z3.ax1x.com/2021/07/14/WenpU1.md.png)](https://imgtu.com/i/WenpU1)

```java
public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
		//初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //左下角先填
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 >maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
```





# 5.字符串转换整数（8）

## 数据结构

数组

## 题解

思路：

* 根据示例 1，需要去掉前导空格；
* 根据示例 2，需要判断第 1 个字符为 + 和 - 的情况，因此，可以设计一个变量 sign，初始化的时候为 1，如果遇到 - ，将 sign 修正为 -1；
  判断是否是数字，可以使用字符的 ASCII 码数值进行比较，即 0 <= c <= '9'；
* 根据示例 3 和示例 4 ，在遇到第 1 个不是数字的字符的情况下，转换停止，退出循环；
* 根据示例 5，如果转换以后的数字超过了 int 类型的范围，需要截取。这里不能将结果 res 变量设计为 long 类型

**注意**：由于输入的字符串转换以后也有可能超过 long 类型，因此需要在循环内部就判断是否越界，只要越界就退出循环，这样也可以减少不必要的计算；
由于涉及下标访问，因此全程需要考虑数组下标是否越界的情况。



```java
public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
// trim white spaces
        str = str.trim();
        char flag = '+';
// check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
// use double to store result
        double result = 0;
// calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (flag == '-')
        result = -result;
// handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;
    }

```







# 6.盛最多水的容器（11）

## 数据结构

涉及：数组，双指针用法

对于这道题

双指针解法的要点：**指针每一次移动，都意味着排除掉了一个柱子**







## 题解

思路：

* 看下图，初始状况

<img src="https://pic.leetcode-cn.com/9341a245384b77afda31ed8b4040d7a382be107a2d22c0e1fc2652a21707cf8c.jpg" style="zoom:67%;" />

在一开始，我们考虑相距最远的两个柱子所能容纳水的面积。水的宽度是两根柱子之间的距离 d = 8d=8；水的高度取决于两根柱子之间较短的那个，即左边柱子的高度 h = 3。水的面积就是 3 * 8 =24。



* 如果选择固定一根柱子，另外一根变化，水的面积会有什么变化吗？思考可得：
  * 当前柱子是最两侧的柱子，**水的宽度 d 为最大**，其他的组合，水的宽度都比这个小
  * 左边柱子较短，决定了水的高度为 3。如**果移动左边的柱子，新的水面高度不确定，一定不会超过右边的柱子高度 7**。
    如果移动右边的柱子，新的水面高度一定不会超过左边的柱子高度 3，也就是不会超过现在的水面高度。

<img src="https://pic.leetcode-cn.com/2bce7d990e22f03d74cc1c566023f18f6f739a559d14b01cee154b67b2ae781b.jpg" style="zoom:67%;" />



所以**核心**是：比较两边的柱子，移动小的柱子，并计算每次的面积并记录比较





```java
public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
```







# 7.电话号码的字母组合

## 算法

涉及：**回溯算法**

回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。

回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。

但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。

### 一般步骤

回溯算法也叫试探法，它是一种系统地搜索问题的解的方法。

用回溯算法解决问题的一般步骤：

* 针对所给问题，定义问题的解空间，它至少包含问题的一个（最优）解。
* 确定易于搜索的解空间结构,使得能用回溯法方便地搜索整个解空间 。
* 以深度优先的方式搜索解空间，并且在搜索过程中用剪枝函数避免无效搜索。





[![WJcN26.md.png](https://z3.ax1x.com/2021/07/19/WJcN26.md.png)](https://imgtu.com/i/WJcN26)



## 思路

* 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。

[<img src="https://z3.ax1x.com/2021/07/19/WJcxZ4.png" alt="WJcxZ4.png" style="zoom: 67%;" />](https://imgtu.com/i/WJcxZ4)



* 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。

[<img src="https://z3.ax1x.com/2021/07/19/WJg70e.md.png" alt="WJg70e.md.png" style="zoom:67%;" />](https://imgtu.com/i/WJg70e)



回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。



```java
public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
```



代码流程图

[![WJ2s3t.md.png](https://z3.ax1x.com/2021/07/19/WJ2s3t.md.png)](https://imgtu.com/i/WJ2s3t)



