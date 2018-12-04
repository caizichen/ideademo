package com.bigdata;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class BaizhiReduce extends Reducer<LongWritable, Text, LongWritable, Text>{

	@Override
	protected void reduce(LongWritable key, Iterable<Text> value,Context context)throws IOException, InterruptedException {
		  context.write(key, new Text("test"));  
	} 

	
   
}
