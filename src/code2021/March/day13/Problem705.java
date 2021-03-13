/*
 * Copyright (c) 2021 maoyan.com
 * All rights reserved.
 *
 */
package code2021.March.day13;

/**
 * 在这里编写类的功能描述
 *
 * @author chenhang
 * @created 2021/3/13
 */
public class Problem705 {

}

class MyHashSet {

    private boolean[] map = new boolean[1000010];

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */