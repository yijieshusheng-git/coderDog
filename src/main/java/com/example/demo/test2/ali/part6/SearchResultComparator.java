package com.example.demo.test2.ali.part6;

import java.util.Comparator;

/**
 * @ClassName SearchResultComparator
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/23  11:15 下午
 * @Version 1.0
 */
public class SearchResultComparator implements Comparator<SearchResult> {


    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        if (o1.relativeRatio != o2.relativeRatio) {
            return o1.relativeRatio > o2.relativeRatio ? 1 : -1;
        }

        if (o1.recentOrders != o2.recentOrders) {
            return o1.recentOrders > o2.recentOrders ? 1 : -1;
        }

        if (o1.count != o2.count) {
            return o1.count > o2.count ? 1 : -1;
        }

        return 0;
    }
}
