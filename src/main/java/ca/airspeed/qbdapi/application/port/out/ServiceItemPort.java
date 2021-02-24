package ca.airspeed.qbdapi.application.port.out;

import java.util.List;

import ca.airspeed.qbdapi.domain.ServiceItem;

public interface ServiceItemPort {
    ServiceItem findByServiceItemId(String id);

    List<ServiceItem> findByFullName(String fullName);
}
