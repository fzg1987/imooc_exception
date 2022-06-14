package com.fzg.imooc.objectsize;

import org.apache.lucene.util.RamUsageEstimator;

public class Test01 {
    public static void main(String[] args) {
        Long l = Long.valueOf(999);
        long size = RamUsageEstimator.shallowSizeOf(l);
        System.out.println(size);
    }
}
