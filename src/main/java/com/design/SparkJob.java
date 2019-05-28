package com.design;

import com.fasterxml.jackson.databind.JsonNode;
import kafka.serializer.StringDecoder;
import lombok.Data;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import java.util.*;

/*
has to be deployed on a yarn-cluster
 */
@Data
public class SparkJob {

    private String brokerList;

    private String zookeeperConnectionString;

    private String topics;

    private String phoenixConnection;
    private Long myOffsetRange;

    public void run(String master, String appName, Integer slidingInterval) {

        SparkConf sparkConf = new SparkConf().setAppName(appName)
                .setMaster(master)
                .set("spark.driver.allowMultipleContexts", "true");
        JavaStreamingContext javaStreamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(slidingInterval));

        try {
            Set<String> topicSet = new HashSet<>(Arrays.asList(topics.split(","))); //add the corresponding kafka topic to the list
            Map<String, String> kafkaParams = new HashMap<>();
            kafkaParams.put("metadata.broker.list", brokerList);
            kafkaParams.put("zookeeper.connect", zookeeperConnectionString);
            kafkaParams.put("group.id", "dummy_group");

            //create stream using the streamingContext and kafkaParams

            /*
            all the processing and storing data in hbase will be done in executors of spark job
             */
        } catch (Exception e) {
            System.out.println("exit reason: " + e.getMessage());
        }

        javaStreamingContext.start();
        javaStreamingContext.awaitTermination();
    }
}
