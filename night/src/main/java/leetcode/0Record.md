### 树的遍历中在非递归的时候，感觉这个总会用到
```$xslt
Stack<Integer> stack = new Stak();
while(rot!=null && !stack.isEmpty()){
    while(root!=null){
        stack.push(root.left)
        root = root.left;
    }
    if(!stack.iEmpty()){
        TreeNode temp = stack.pop();
        xxx
    }
}
```

### 快速幂
> 一种快速求得幂次方得方式；普通方式为O(n),快速幂为O(logn)
> https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E5%B9%82/5500243?fr=aladdin

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

### 滚动数组优化
> P97、P63、P70、Offer46