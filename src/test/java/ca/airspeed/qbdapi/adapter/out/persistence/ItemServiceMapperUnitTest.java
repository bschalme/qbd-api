package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.ServiceItem;

class ItemServiceMapperUnitTest {

    private ItemServiceMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = new ItemServiceMapper();
    }

    @Test
    void mapToJpaEntity() throws Exception {
        // Given:
        ServiceItem serviceItem = ServiceItem.builder()
                .id("123")
                .name("Software Development")
                .fullName("Software Development:SD100")
                .description("Software Development Services (hours)")
                .price(BigDecimal.valueOf(10000, 2))
                .build();

        // When:
        ItemServiceJpaEntity jpa = mapper.mapToJpaEntity(serviceItem);

        // Then:
        assertThat(jpa, notNullValue());
        assertThat(jpa.getListID(), is("123"));
        assertThat(jpa.getName(), is("Software Development"));
        assertThat(jpa.getFullName(), is("Software Development:SD100"));
        assertThat("SalesOrPurchaseDetail;", jpa.getDetail(), notNullValue());
        assertThat(jpa.getDetail().getDescription(), is("Software Development Services (hours)"));
        assertThat(jpa.getDetail().getPrice(), is("100.00"));
    }

    @Test
    void mapToDomainEntity_HappyPath() throws Exception {
        // Given:
        ItemServiceJpaEntity jpa = new ItemServiceJpaEntity();
        jpa.setListID("123");
        jpa.setName("Software Development");
        jpa.setFullName("Software Development:SD100");
        SalesOrPurchaseDetailJpaEntity detail = new SalesOrPurchaseDetailJpaEntity();
        detail.setDescription("Software Development Services (hours)");
        detail.setPrice("100.00");
        jpa.setDetail(detail);
        Optional<ItemServiceJpaEntity> optional = Optional.of(jpa);

        // When:
        ServiceItem serviceItem = mapper.mapToDomainEntity(optional);

        // Then:
        assertThat(serviceItem, notNullValue());
        assertThat(serviceItem.getId(), is("123"));
        assertThat(serviceItem.getName(), is("Software Development"));
        assertThat(serviceItem.getFullName(), is("Software Development:SD100"));
        assertThat(serviceItem.getDescription(), is("Software Development Services (hours)"));
        assertThat(serviceItem.getPrice(), is(BigDecimal.valueOf(10000, 2)));
    }

    @Test
    void mapDomainToEntity_NothingToConvert() throws Exception {
        // Given:
        Optional<ItemServiceJpaEntity> optional = Optional.empty();

        // When:
        ServiceItem serviceItem = mapper.mapToDomainEntity(optional);

        // Then:
        assertThat(serviceItem, nullValue());
    }

    @Test
    void mapToDomainList() throws Exception {
        // Given:
        ItemServiceJpaEntity expert = new ItemServiceJpaEntity();
        expert.setListID("123");
        expert.setFullName("Software Development:SD100");
        SalesOrPurchaseDetailJpaEntity expertDetail = new SalesOrPurchaseDetailJpaEntity();
        expertDetail.setPrice("100.00");
        expert.setDetail(expertDetail);
        ItemServiceJpaEntity guru = new ItemServiceJpaEntity();
        guru.setListID("456");
        guru.setFullName("Software Development:SD125");
        SalesOrPurchaseDetailJpaEntity guruDetail = new SalesOrPurchaseDetailJpaEntity();
        guruDetail.setPrice("125.00");
        guru.setDetail(guruDetail);

        // When:
        List<ServiceItem> serviceItemList = mapper.mapToDomainList(asList(expert, guru));

        // Then:
        assertThat(serviceItemList, hasSize(2));
    }

    @Test
    void mapToDomainList_FromNullResultSet() throws Exception {
        // When:
        List<ServiceItem> serviceItemList = mapper.mapToDomainList(null);

        // Then:
        assertThat(serviceItemList, empty());
    }
}
