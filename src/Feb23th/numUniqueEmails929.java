package Feb23th;

import java.util.HashSet;

public class numUniqueEmails929 {
    // 首先提取@之前的字符 然后提取+ 之前的字符(如果有的话) 然后忽略. 将其添加到HashSet 最后输出HashSet的size即可
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        // 对每一个邮箱地址进行判断
        for(int i = 0; i < emails.length; i++){
            String s = emails[i];
            // 提取@之前的所有字符
            s = s.substring(0, s.indexOf('@'));
            // 如果有+的话，再次提取
            if(s.indexOf('+') > 0)
                s = s.substring(0, s.indexOf('+'));
            // 定义buff存储实际的本地地址
            StringBuilder buff = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) != '.')
                    buff.append(s.charAt(j));
            }
            // 添加外部地址
            set.add(buff.toString() + emails[i].substring(emails[i].indexOf('@')));
        }
        return set.size();
    }
}
