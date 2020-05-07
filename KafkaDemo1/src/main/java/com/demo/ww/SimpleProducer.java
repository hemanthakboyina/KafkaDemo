package com.demo.ww;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {
 
 public static void main(String[] args) throws Exception{
    
    String topicName = "sample1";
    
    Properties props = new Properties();
    props.put("bootstrap.servers", "ec2-3-7-118-173.ap-south-1.compute.amazonaws.com:9092,ec2-3-7-118-173.ap-south-1.compute.amazonaws.com:9094");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    
    Producer<String, String> producer = new KafkaProducer
       <String, String>(props);
          
    for(int i = 0; i < 10; i++)
		
		  producer.send(new ProducerRecord<String, String>(topicName,
		  "kewName"+Integer.toString(i), "keyValue"+Integer.toString(i))).get();
		  System.out.println("Message sent successfully");
		 
			/*
			 * producer.send(new ProducerRecord<String, String>(topicName, "Blue Shirt",
			 * "Shirt"));
			 */
             producer.close();
 }
}