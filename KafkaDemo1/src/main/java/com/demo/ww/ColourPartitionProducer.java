package com.demo.ww;

import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.demo.ww.*;

public class ColourPartitionProducer {
 
 public static void main(String[] args) throws Exception{
    
    String topicName = "shopping_topic";
    
    Properties props = new Properties();
    props.put("bootstrap.servers", "ec2-3-7-118-173.ap-south-1.compute.amazonaws.com:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", 
       "org.apache.kafka.common.serialization.StringSerializer");
    props.put("partitioner.class", ColourPartitioner.class.getName());
    
    Producer<String, String> producer = new KafkaProducer
       <String, String>(props);
          
       producer.send(new ProducerRecord<String, String>(topicName, 
          "Blue Shirt", "blue Shirt")).get();
       producer.send(new ProducerRecord<String, String>(topicName, 
    	          "green Shirt", "Green Shirt")).get();
       producer.send(new ProducerRecord<String, String>(topicName, 
    	          "red Shirt", "Red Shirt")).get();
       
       
             System.out.println("Message sent successfully");
             producer.flush();
             producer.close();
 }
}