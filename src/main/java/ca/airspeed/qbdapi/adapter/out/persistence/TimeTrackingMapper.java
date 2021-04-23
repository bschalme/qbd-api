package ca.airspeed.qbdapi.adapter.out.persistence;

import static io.micronaut.core.util.StringUtils.isNotEmpty;
import static java.lang.String.format;
import static java.time.ZoneId.systemDefault;

import java.time.Duration;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

@Singleton
class TimeTrackingMapper {

    TimeTrackingJpaEntity mapToJpaEntry(TimesheetEntry timesheetEntry) {
        TimeTrackingJpaEntity result = new TimeTrackingJpaEntity();
        result.setTxnId(timesheetEntry.getId());
        result.setEntityRefListId(timesheetEntry.getAssociateId());
        if (isNotEmpty(timesheetEntry.getJobId())) {
            CustomerJpaEntity customer = new CustomerJpaEntity();
            customer.setListID(timesheetEntry.getJobId());
            result.setCustomer(customer);
        }
        result.setItemServiceRefListId(timesheetEntry.getServiceItemId());
        result.setTxnDate(Date.from(timesheetEntry.getDateWorked().atStartOfDay(systemDefault()).toInstant()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        result.setNotes(format("%s-%s:%s",
                timesheetEntry.getStartDateTime().format(formatter),
                timesheetEntry.getEndDateTime().format(formatter),
                timesheetEntry.getNotes()));
        long durationInMinutes = timesheetEntry.getDuration().toMinutes();
        result.setDuration(
                format("PT%dH%dM", durationInMinutes / 60, durationInMinutes % 60));
        result.setBillableStatus(timesheetEntry.getBillableStatus());
        if (timesheetEntry.getBillableStatus().equals("Billable")) {
            result.setIsBillable("true");
        }
        else {
            result.setIsBillable("false");
        }
        return result;
    }

    List<TimeTrackingJpaEntity> mapListToJpaEntries(List<TimesheetEntry> timesheetEntries) {
        List<TimeTrackingJpaEntity> results = new ArrayList<>();
        for (TimesheetEntry entry: timesheetEntries) {
            results.add(mapToJpaEntry(entry));
        }
        return results;
    }

    TimesheetEntry mapToDomainObject(TimeTrackingJpaEntity entity) {
        return TimesheetEntry.builder()
                .id(entity.getTxnId())
                .associateId(entity.getEntityRefListId())
                .jobId(entity.getCustomer() != null ? entity.getCustomer().getListID() : null)
                .dateWorked(entity.getTxnDate()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())
                .duration(Duration.parse(entity.getDuration()))
                .notes(entity.getNotes())
                .billableStatus(entity.getBillableStatus())
                .build();
    }

    List<TimesheetEntry> mapListToDomainObjects(List<TimeTrackingJpaEntity> entities) {
        List<TimesheetEntry> results = new ArrayList<>();
        for (TimeTrackingJpaEntity entity: entities) {
            results.add(mapToDomainObject(entity));
        }
        return results;
    }
}
