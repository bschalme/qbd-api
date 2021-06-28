package ca.airspeed.qbdapi.adapter.in.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import io.micronaut.aws.sdk.v1.EnvironmentAWSCredentialsProvider;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.env.Environment;

import javax.inject.Singleton;

@Factory
public class SqsClientFactory {

    @Singleton
    AmazonSQS sqsClient(Environment environment) {
        return AmazonSQSClientBuilder
                .standard()
                .withRegion(System.getenv("AWS_REGION"))
                .withCredentials( new EnvironmentAWSCredentialsProvider(environment))
                .build();
    }
}
