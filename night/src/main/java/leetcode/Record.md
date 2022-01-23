### 需要反复练习十大排序算法

---

### 在线处理算法
子数组问题
> 152、乘积最大子数组

---
### 遇到超出时间限制的问题
- 先看是否有乘法占用时间太长，如果有乘法的话，将乘法逻辑换成除法的逻辑
---
### map中的键值如果设为int[]的话
map.get(new int[])这样是获取不到数据的；因为两个int[]不是同一个对象，地址是不同的；  
可以将int[]变为List<Integer>,然后map在put的时候使用map.put(Collections.**<font color="red">unmodifiableList(Arrays.asList(i,j))</font>**,0);  
一个unmodifiableList，所以键不能改变哈希码【这样就还可以使用map.get(list)来获取value了】；一个Arrays.asList(x,y...)生成list;
[参考](https://www.imooc.com/wenda/detail/598159)
---

### 摩尔投票
摩尔投票：核心就是对拼消耗-->打仗对拼，几伙人打仗，一对一的换，占到最后的那个人就是胜者；

---

### 单调栈
通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了
P739 -- 每日温度

---

### 洗牌算法
shuffle()--经典洗牌算法  

**原理**
从数组最后一个元素开始，  
每到一个位置，就把该位置的元素和随机产生的0<=x<=当前位置的一个位置的元素进行交换；  
这样就可以等概率随机生成不同的排列了 -- 但是不太懂原理。。。
```
记有temp[n];  
for(int i = n-1;i>=1;i--){
    // random.nextInt(n+1) 是返回0<=x<=n的一个数
    // 也记radom.nextInt(n) 是返回>=0且<n的一个数
    swap(temp[i],random.nextInt(i+1))
}
```

### 后缀数组
> 倍增法  &  SA-IS
>

### 字典树
P472

### 贪心+优先级队列
> P1705  每次吃最快要腐烂的苹果

### List转数组
```
String[] strings = list.toArray(new String[list.size()]);
```

### 遇到一个数组中除了0和n.length-1位置上的操作不一样，其他位置所执行的操作是一样的
- P1576是一种题
```
public String modifyString(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0;i < chars.length;i++){
        if (chars[i]=='?'){
            char a = 'a';
            // 主要是这里
            while((i>0 && chars[i-1]==a)||(i<chars.length-1&&chars[i+1]==a)){
                a++;
            }
            chars[i] = a;
        }
    }
    return String.valueOf(chars);
}
```

---
### 不会，但是为了打卡，抄的；需要再做的；

### 快速对map按照value排序
```$xslt
public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
    HashMap<K, V> finalOut = new LinkedHashMap<>();
    aMap.entrySet()
            .stream()
            .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
            .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
    return finalOut;
}
```