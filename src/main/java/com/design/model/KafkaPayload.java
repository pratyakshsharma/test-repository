package com.design.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
this class has the data model for kafka topic
 */
public class KafkaPayload {

    private String userId;
    private Long timestamp;
    private Double latitude;
    private Double longitude;

    /*
    And similarly more data points can be added in this class as per the use case
     */
}
