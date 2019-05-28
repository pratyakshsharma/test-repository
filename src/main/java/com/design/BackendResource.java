package com.design;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;


public class BackendResource {

    public BackendResource() {

    }


    @POST
    public Response executeBackend() {

        String userId = "dummy_user_id";
        //do all the execution here

        /*
        all the processing for analytic engine will be done in async flow,
        hence send one event of type KafkaPayload as defined in model package to a kafka topic analytic-topic.
         */
        return Response.ok().build();
    }
}
