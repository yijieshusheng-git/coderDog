package com.example.demo.test2.ali.part6;

/**
 * @ClassName SearchResult
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/23  11:09 下午
 * @Version 1.0
 */
public class SearchResult implements Comparable<SearchResult> {

     int relativeRatio;
     int count;
     int recentOrders;

    public SearchResult(int relativeRatio, int count) {
        this.relativeRatio = relativeRatio;
        this.count = count;
    }


    @Override
    public int compareTo(SearchResult o) {

        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }

        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }


    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }
}
