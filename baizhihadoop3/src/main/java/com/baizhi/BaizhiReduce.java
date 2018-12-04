package com.baizhi;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class BaizhiReduce extends Reducer<UserKeyValuePair, LongWritable, IntWritable, LongWritable>{

    @Override
    protected void reduce(UserKeyValuePair key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {

        LongWritable result = null;
        for (LongWritable longWritable : values){
            result = longWritable;
            context.write(new IntWritable(key.getFirst()), result);
        }
    }
}
