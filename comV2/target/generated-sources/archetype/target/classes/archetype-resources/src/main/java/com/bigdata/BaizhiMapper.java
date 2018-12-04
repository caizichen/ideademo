#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.bigdata;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class BaizhiMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

	@Override
	protected void map(LongWritable key, Text value,Context context)throws IOException, InterruptedException {
		context.write(key, value);
	}
   
}
