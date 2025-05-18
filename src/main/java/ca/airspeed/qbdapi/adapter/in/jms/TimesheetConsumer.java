package ca.airspeed.qbdapi.adapter.in.jms;

import static io.micronaut.context.env.Environment.AMAZON_EC2;
import static io.micronaut.jms.sqs.configuration.SqsConfiguration.CONNECTION_FACTORY_BEAN_NAME;

import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntryList;
import io.micronaut.context.annotation.Requires;
import io.micronaut.jms.annotations.JMSListener;
import io.micronaut.jms.annotations.Queue;
import io.micronaut.messaging.annotation.MessageBody;
import lombok.extern.slf4j.Slf4j;

@JMSListener(CONNECTION_FACTORY_BEAN_NAME)
@Slf4j
@Requires(env = AMAZON_EC2)
public class TimesheetConsumer {

    @Queue(value = "${airspeed.queues.timesheet.name}")
    public void receive(@MessageBody InputTimesheetEntryList body) {
        log.info("Received {} TimesheetEntries, but doing nothing with them.", body.getEntries().size());
    }
}
