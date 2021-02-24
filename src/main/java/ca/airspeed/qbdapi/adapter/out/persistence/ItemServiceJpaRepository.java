package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface ItemServiceJpaRepository extends PageableRepository<ItemServiceJpaEntity, String> {

    List<ItemServiceJpaEntity> findByFullNameStartsWith(String fullName);
}
