package com.baizhi;

import java.io.IOException;
import java.security.Key;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class BaizhiMapper extends Mapper<LongWritable, Text, UserKeyValuePair, LongWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
            throws IOException, InterruptedException {


	    String line = value.toString();
	    String[] numbers = line.split("\t");

	    UserKeyValuePair KeyValuePair = new UserKeyValuePair(numbers[0],numbers[1]);

        context.write(KeyValuePair,new LongWritable(Long.parseLong(numbers[1])));

	    //context.getCounter("大类","小类").increment(1L);
        context.getCounter(MyMapReduce.MAP_REDUCE_NUM).increment(1L);

	}
   
}
