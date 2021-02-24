package ca.airspeed.qbdapi.application.service;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.RetrieveServiceItemUseCase;
import ca.airspeed.qbdapi.application.port.out.ServiceItemPort;
import ca.airspeed.qbdapi.domain.ServiceItem;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ServiceItemService implements RetrieveServiceItemUseCase {

    private final ServiceItemPort port;

    @Override
    public ServiceItem retrieveServiceItem(String id) {
        return port.findByServiceItemId(id);
    }

    @Override
    public List<ServiceItem> findByFullName(String fullName) {
        return port.findByFullName(fullName);
    }

}
