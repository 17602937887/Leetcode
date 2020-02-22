package Feb22th;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class uniqueOccurrences1207 {
    //第一次存储出现的次数 第二次判断是否唯一
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            // 如果当前值 出现过 则出现次数 +1;
            if(f.containsKey(arr[i])){
                f.put(arr[i], f.remove(arr[i]) + 1);
            } else {
                // 没出现过 则 将其设置为出现过1次
                f.put(arr[i], 1);
            }
        }
        // 获取Map集合所有的键
        Set<Integer> keys = f.keySet();
        // 定义HashSet集合判断是否冲突
        HashSet<Integer> k = new HashSet<>();
        for(Integer key : keys){
            // 当前出现的次数出现过 return false;
            if(k.contains(f.get(key))){
                return false;
            } else {
                // 将当前出现的次数 添加到Set集合中
                k.add(f.get(key));
            }
        }
        return true;
    }
}
