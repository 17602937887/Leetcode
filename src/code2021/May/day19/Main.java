/*
 * Copyright (c) 2021 hangcc.cn
 * All rights reserved.
 *
 */
package code2021.May.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在这里编写类的功能描述
 *
 * @author chenhang
 * @created 2021/5/19
 */
public class Main {

    public static class Node {
        int power;
        int cost;

        public Node(int power, int cost) {
            this.power = power;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            power[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
        }
        List<List<Node>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            List<Node> preNodes = dp.get(i - 1);
            List<Node> nowNodes = dp.get(i);
            // 上一项没有维护值 则当前必买
            if (preNodes == null || preNodes.size() == 0) {
                nowNodes.add(new Node(power[i], cost[i]));
            } else {
                for (int j = 0; j < preNodes.size(); j++) {
                    // 上一项的能力值 小于当前怪兽能力值的话 直接扔掉 [大于等于的话保留]
                    if (preNodes.get(j).power >= power[i]) {
                        nowNodes.add(preNodes.get(j));
                    }
                    // 基于上次的能力值 进行贿赂
                    nowNodes.add(new Node(preNodes.get(j).power + power[i], preNodes.get(j).cost + cost[i]));
                }
            }
            dp.set(i, nowNodes);
        }
        int result = 0x3f3f3f3f;
        for (Node node : dp.get(n)) {
            result = Math.min(result, node.cost);
        }
        System.out.println(result);
    }
}