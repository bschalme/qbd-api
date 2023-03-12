package ca.airspeed.qbdapi.adapter.out.persistence.itemservice;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.inject.Singleton;

import ca.airspeed.qbdapi.adapter.out.persistence.SalesOrPurchaseDetailJpaEntity;
import ca.airspeed.qbdapi.domain.ServiceItem;

@Singleton
public class ItemServiceMapper {
    ItemServiceJpaEntity mapToJpaEntity(ServiceItem itemService) {
        ItemServiceJpaEntity result = new ItemServiceJpaEntity();
        result.setListID(itemService.getId());
        result.setName(itemService.getName());
        result.setFullName(itemService.getFullName());
        SalesOrPurchaseDetailJpaEntity detail = new SalesOrPurchaseDetailJpaEntity();
        detail.setDescription(itemService.getDescription());
        detail.setPrice(itemService.getPrice().toPlainString());
        result.setDetail(detail);
        return result;
    }

    ServiceItem mapToDomainEntity(Optional<ItemServiceJpaEntity> optional) {
        if (optional.isPresent()) {
            ItemServiceJpaEntity entity = optional.get();
            return makeDomainObject(entity);
        } else {
            return null;
        }
    }

    List<ServiceItem> mapToDomainList(List<ItemServiceJpaEntity> jpaList) {
        if (jpaList != null) {
            return jpaList.stream()
                    .map(ItemServiceMapper::makeDomainObject)
                    .collect(toList());
        }
        return new ArrayList<>();
    }

    private static ServiceItem makeDomainObject(ItemServiceJpaEntity jpa) {
        SalesOrPurchaseDetailJpaEntity detail = jpa.getDetail();
        return ServiceItem.builder()
                .id(jpa.getListID())
                .name(jpa.getName())
                .fullName(jpa.getFullName())
                .description(detail != null ? detail.getDescription() : null)
                .price(detail != null ? new BigDecimal(detail.getPrice()) : null)
                .build();
    }

}
