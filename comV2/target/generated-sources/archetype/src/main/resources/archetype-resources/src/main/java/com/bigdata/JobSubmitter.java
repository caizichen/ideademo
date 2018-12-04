#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.bigdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JobSubmitter {
	public static void main(String[] args) throws Exception {
		
		//创建一个Job
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf,JobSubmitter.class.getSimpleName());
		//添加任务的类路径
		job.setJarByClass(JobSubmitter.class);
		
		
		//设置分析的数据源 和输出的数据 路径
		Path src=new Path("hdfs://hadoop.baizhiedu.com:8020/mr/src");
		FileInputFormat.addInputPath(job, src);
		
		//设置Mapper
		job.setMapperClass(BaizhiMapper.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		//shuffle
		
		//设置reduce端的输出类型
		job.setReducerClass(BaizhiReduce.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		
		//设置输出

        String OUTPUT_PATH = "hdfs://hadoop.baizhiedu.com:8020/mr/res1";
        deletefile(conf, OUTPUT_PATH);

		Path out = new Path("hdfs://hadoop.baizhiedu.com:8020/mr/res1");
		FileOutputFormat.setOutputPath(job, out);
		
		
		//提交任务
		job.waitForCompletion(true);
	}


    public static boolean deletefile(Configuration conf,String delpath) throws Exception {
        //输出路径用字符串表示，在主类中定义，或者由主方法参数给出
        Path path = new Path(delpath);
        FileSystem fileSystem = path.getFileSystem(conf);
        //getFileSystem()函数功能  Return the FileSystem that owns this Path.
        if (fileSystem.exists(new Path(delpath))) {
            return fileSystem.delete(new Path(delpath),true);
        }
        return false;
    }

}
