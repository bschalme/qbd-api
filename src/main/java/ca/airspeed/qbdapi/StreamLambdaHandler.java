package ca.airspeed.qbdapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import io.micronaut.function.aws.proxy.MicronautLambdaContainerHandler;

public class StreamLambdaHandler implements RequestStreamHandler {

    private MicronautLambdaContainerHandler handler;

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        if (handler == null) {
            try {
                handler = new MicronautLambdaContainerHandler();
            } catch (ContainerInitializationException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        handler.proxyStream(inputStream, outputStream, context);

    }

}
