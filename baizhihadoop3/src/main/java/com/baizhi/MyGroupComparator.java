package com.baizhi;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyGroupComparator implements RawComparator<UserKeyValuePair> {

    @Override
    public int compare(UserKeyValuePair o1, UserKeyValuePair o2) {
        return o1.compareTo(o2);
    }

    @Override
    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
        return WritableComparator.compareBytes(b1,s1,l1,b2,s2,l2);
    }
}
