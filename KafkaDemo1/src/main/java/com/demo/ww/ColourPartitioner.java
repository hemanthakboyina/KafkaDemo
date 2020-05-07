package com.demo.ww;

import java.util.*;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.*;
import org.apache.kafka.common.utils.*;
import org.apache.kafka.common.record.*;

public class ColourPartitioner implements Partitioner {

    private String blueColour = "blue";
    private String greenColour = "green";
    private String redColour = "red";
    
    public void configure(Map<String, ?> configs) {
    }
    
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        int p = 0;

        if (((String) key).contains(blueColour))
            p = 1;
        else if(((String) key).contains(redColour))
        	p = 2;
        else if(((String) key).contains(greenColour))
        	p = 3;

        System.out.println("Key = " + (String) key + " Partition = " + p);
        return p;
    }

    public void close() {
    }
}