package com.baizhi;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class UserKeyValuePair implements WritableComparable<UserKeyValuePair> {

    private Integer first;
    private Integer second;

    public UserKeyValuePair() {
    }

    public UserKeyValuePair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public UserKeyValuePair(String first, String second){
        this.first = Integer.valueOf(first);
        this.second = Integer.valueOf(second);
    }


    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "UserKeyValuePair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserKeyValuePair)) return false;
        UserKeyValuePair that = (UserKeyValuePair) o;
        return getFirst() == that.getFirst() &&
                getSecond() == that.getSecond();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirst(), getSecond());
    }


    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(first);
        out.writeInt(second);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first = in.readInt();
        second = in.readInt();
    }

    @Override
    public int compareTo(UserKeyValuePair o) {
        int i = first.compareTo(o.getFirst());
        if(i==0){
            return second.compareTo(o.getSecond());
        }

        return i;
    }
}
