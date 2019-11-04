package ca.airspeed.qbdapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;

public class StreamLambdaHandler implements RequestStreamHandler {

    private static MicronautLambdaContainerHandler handler;
    static {
        try {
            handler = MicronautLambdaContainerHandler.getAwsProxyHandler();
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Micronaut", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.proxyStream(inputStream, outputStream, context);

    }

}
