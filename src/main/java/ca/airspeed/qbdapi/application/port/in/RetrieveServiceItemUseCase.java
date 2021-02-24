package ca.airspeed.qbdapi.application.port.in;

import java.util.List;

import ca.airspeed.qbdapi.domain.ServiceItem;

public interface RetrieveServiceItemUseCase {

    ServiceItem retrieveServiceItem(String id);

    List<ServiceItem> findByFullName(String fullName);
}
