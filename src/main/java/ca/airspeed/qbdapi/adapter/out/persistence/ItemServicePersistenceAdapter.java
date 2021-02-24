package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.ServiceItemPort;
import ca.airspeed.qbdapi.domain.ServiceItem;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ItemServicePersistenceAdapter implements ServiceItemPort {
    private final ItemServiceJpaRepository repo;
    private final ItemServiceMapper mapper;

    @Override
    public ServiceItem findByServiceItemId(String id) {
        return mapper.mapToDomainEntity(repo.findById(id));
    }

    @Override
    public List<ServiceItem> findByFullName(String fullName) {
        List<ItemServiceJpaEntity> resultSet = repo.findByFullNameStartsWith(fullName);
        return mapper.mapToDomainList(resultSet);
    }

}
