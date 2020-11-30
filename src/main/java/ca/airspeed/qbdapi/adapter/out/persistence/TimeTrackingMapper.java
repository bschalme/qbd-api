package ca.airspeed.qbdapi.adapter.out.persistence;

import static io.micronaut.core.util.StringUtils.isNotEmpty;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

@Singleton
class TimeTrackingMapper {
    TimeTrackingJpaEntity mapTopJpaEntry(TimesheetEntry timesheetEntry) {
        TimeTrackingJpaEntity result = new TimeTrackingJpaEntity();
        result.setTxnId(timesheetEntry.getId());
        result.setEntityRefListId(timesheetEntry.getAssociateId());
        if (isNotEmpty(timesheetEntry.getJobId())) {
            CustomerJpaEntity customer = new CustomerJpaEntity();
            customer.setListID(timesheetEntry.getJobId());
            result.setCustomer(customer);
        }
        result.setItemServiceRefListId(timesheetEntry.getServiceItemId());
        return result;
    }
}
